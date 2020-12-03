package com.company.myerp.web.screens.services.stores;

import com.company.myerp.entity.CommercialNetwork;
import com.company.myerp.service.StoreService;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.PickerField;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

import javax.inject.Inject;
import java.util.List;

@UiController("myerp_StoreServiceScreen")
@UiDescriptor("store_service_screen.xml")
public class StoreServiceScreen extends Screen {

    @Inject
    private PickerField<CommercialNetwork> commercialNetworkField;
    @Inject
    private CollectionContainer<NumberPurchases> numberPurchaseDc;
    @Inject
    private StoreService storeService;

    @Subscribe("showNumberSalesButton")
    public void onShowNumberSalesButtonClick(Button.ClickEvent event) {
        commercialNetworkField.validate();
        CommercialNetwork commercialNetwork = commercialNetworkField.getValue();

        List<NumberPurchases> numberPurchasesList = storeService.countPurchasesCommercialNetwork(commercialNetwork);

        numberPurchaseDc.setItems(numberPurchasesList);
    }
}