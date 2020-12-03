package com.company.myerp.web.screens.purchaseproduct;

import com.company.myerp.entity.Product;
import com.company.myerp.entity.PurchaseProduct;
import com.company.myerp.entity.Store;
import com.company.myerp.entity.StoreProduct;
import com.company.myerp.web.screens.storeproduct.StoreProductBrowse;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.PickerField;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;
import java.math.BigDecimal;

@UiController("myerp_PurchaseProduct.edit")
@UiDescriptor("purchase-product-edit.xml")
@EditedEntityContainer("purchaseProductDc")
@LoadDataBeforeShow
public class PurchaseProductEdit extends StandardEditor<PurchaseProduct> {

    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    private PickerField<Product> productField;
    @Inject
    private TextField<BigDecimal> priceField;
    @Inject
    private Notifications notifications;
    private ScreenOptions screenOptions;

    @Subscribe
    private void onInit(InitEvent event) {
        screenOptions = event.getOptions();
    }

    @Subscribe("productField.lookup")
    public void onProductFieldLookup(Action.ActionPerformedEvent event) {
        Store store = (Store) ((MapScreenOptions) screenOptions).getParams().get("store");

        if (store == null) {
            notifications.create()
                    .withCaption("Store not found")
                    .withType(Notifications.NotificationType.TRAY)
                    .show();
            return;
        }

        StoreProductBrowse screen = configScreenBrowseStoreProducts(store);
        screen.show();
    }

    private StoreProductBrowse configScreenBrowseStoreProducts(Store store) {
        StoreProductBrowse screen = screenBuilders.lookup(StoreProduct.class, this)
                .withScreenClass(StoreProductBrowse.class)
                .withOpenMode(OpenMode.DIALOG)
                .withSelectHandler(storeProducts -> {
                    StoreProduct storeProduct = storeProducts.stream().findFirst().get();
                    Product product = storeProduct.getProduct();
                    productField.setValue(product);
                    priceField.setValue(storeProduct.getPrice());
                })
                .build();
        screen.setStore(store);
        return screen;
    }
}