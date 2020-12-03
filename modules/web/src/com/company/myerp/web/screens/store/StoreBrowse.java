package com.company.myerp.web.screens.store;

import com.company.myerp.entity.StoreProduct;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.myerp.entity.Store;

import javax.inject.Inject;

@UiController("myerp_Store.browse")
@UiDescriptor("store-browse.xml")
@LookupComponent("storesTable")
@LoadDataBeforeShow
public class StoreBrowse extends StandardLookup<Store> {
}