package com.company.myerp.web.screens.purchase;

import com.company.myerp.entity.Purchase;
import com.company.myerp.entity.PurchaseProduct;
import com.company.myerp.entity.Store;
import com.company.myerp.service.PurchaseService;
import com.company.myerp.service.exception.PurchaseServiceException;
import com.haulmont.bali.util.ParamsMap;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.PickerField;
import com.haulmont.cuba.gui.model.CollectionChangeType;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionPropertyContainer;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;
import java.util.Collection;
import java.util.List;

@UiController("myerp_Purchase.edit")
@UiDescriptor("purchase-edit.xml")
@EditedEntityContainer("purchaseDc")
@LoadDataBeforeShow
public class PurchaseEdit extends StandardEditor<Purchase> {

    @Inject
    private PickerField<Store> storeField;
    @Inject
    private CollectionPropertyContainer<PurchaseProduct> purchaseProductsDc;
    @Inject
    private DataContext dataContext;
    @Inject
    private PurchaseService purchaseService;
    @Inject
    private Notifications notifications;

    @Install(to = "purchaseProductsTable.create", subject = "screenOptionsSupplier")
    private ScreenOptions purchaseProductsTableScreenOptionsSupplier() {
        return new MapScreenOptions(ParamsMap.of("store", storeField.getValue()));
    }

    @Subscribe(id = "purchaseProductsDc", target = Target.DATA_CONTAINER)
    public void onPurchaseProductsDcCollectionChange(CollectionContainer.CollectionChangeEvent<PurchaseProduct> event) {
        Collection<? extends PurchaseProduct> changesStoreProducts = event.getChanges();
        List<PurchaseProduct> storeProductList = purchaseProductsDc.getMutableItems();

        if (event.getChangeType().equals(CollectionChangeType.ADD_ITEMS)) {
            PurchaseProduct changeItem = changesStoreProducts.iterator().next();
            sumMatchingItems(storeProductList, changeItem);
        }
    }

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        List<PurchaseProduct> purchaseProducts = getEditedEntity().getPurchaseProducts();
        try {
            purchaseService.WriteOutStoreProductsOfPurchase(purchaseProducts);
        } catch (PurchaseServiceException exception) {
            notifications.create(Notifications.NotificationType.ERROR)
                    .withCaption(exception.getMessage())
                    .show();
            event.preventCommit();
        }
    }

    private void sumMatchingItems(List<PurchaseProduct> storeProductList, PurchaseProduct changeItem) {
        PurchaseProduct coincidenceStoreProduct = storeProductList.stream()
                .filter(item -> item.getProduct().equals(changeItem.getProduct()) && !item.equals(changeItem))
                .findFirst().orElse(null);
        if (coincidenceStoreProduct != null) {
            coincidenceStoreProduct.setCount(coincidenceStoreProduct.getCount() + changeItem.getCount());
            coincidenceStoreProduct.setPrice(changeItem.getPrice());

            purchaseProductsDc.replaceItem(coincidenceStoreProduct);
            storeProductList.remove(changeItem);
            dataContext.remove(changeItem);
        }
    }
}