package com.company.myerp.web.screens.storeproduct;

import com.company.myerp.entity.Store;
import com.company.myerp.web.screens.store.StoreBrowse;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.myerp.entity.StoreProduct;

import javax.inject.Inject;
import java.util.Map;

@UiController("myerp_StoreProduct.browse")
@UiDescriptor("store-product-browse.xml")
@LookupComponent("storeProductsTable")
@LoadDataBeforeShow
public class StoreProductBrowse extends StandardLookup<StoreProduct> {

    @Inject
    private CollectionLoader<StoreProduct> storeProductsDl;
    private Store store;

    public void setStore(Store store) {
        this.store = store;
    }

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        if (store == null) throw new IllegalStateException("store parameter is null");

        storeProductsDl.setParameter("store", store);
        storeProductsDl.load();
    }
}