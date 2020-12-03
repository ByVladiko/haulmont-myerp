package com.company.myerp.web.screens.purchaseproduct;

import com.company.myerp.entity.Store;
import com.haulmont.cuba.gui.screen.ScreenOptions;

public class StorePurchaseOption implements ScreenOptions {

    private Store store;

    public StorePurchaseOption(Store store) {
        this.store = store;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
