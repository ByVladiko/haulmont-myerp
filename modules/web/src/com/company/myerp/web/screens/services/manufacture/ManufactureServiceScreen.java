package com.company.myerp.web.screens.services.manufacture;

import com.company.myerp.entity.Product;
import com.company.myerp.entity.Store;
import com.company.myerp.service.ManufactureService;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.PickerField;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

import javax.inject.Inject;
import java.util.List;

@UiController("myerp_ManufactureService")
@UiDescriptor("manufacture_service_screen.xml")
public class ManufactureServiceScreen extends Screen {

    @Inject
    private ManufactureService manufactureService;
    @Inject
    private PickerField<Store> storeField;
    @Inject
    private TextField<Integer> countField;
    @Inject
    private PickerField<Product> productField;
    @Inject
    private CollectionContainer<Product> productsDc;
    @Inject
    private CollectionContainer<Store> storesDc;
    @Inject
    private Notifications notifications;

    @Subscribe("refreshProductsButton")
    public void onRefreshProductsButtonClick(Button.ClickEvent event) {
        storeField.validate();
        Store store = storeField.getValue();
        countField.validate();
        int count = countField.getValue();

        List<Product> products = manufactureService.storeProductListCountLessNum(store, count);
        productsDc.setItems(products);

        notifyIfEmptyResult(products);
    }

    @Subscribe("refreshStoresButton")
    public void onRefreshStoresButtonClick(Button.ClickEvent event) {
        productField.validate();
        Product product = productField.getValue();

        List<Store> stores = manufactureService.storeListWhereNotSellProduct(product);
        storesDc.setItems(stores);

        notifyIfEmptyResult(stores);
    }

    private void notifyIfEmptyResult(List<?> list) {
        if (list.isEmpty()) {
            notifications.create(Notifications.NotificationType.TRAY).withCaption("Empty result").show();
        }
    }
}