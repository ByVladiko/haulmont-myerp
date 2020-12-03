package com.company.myerp.web.screens.storeproduct;

import com.company.myerp.entity.StoreProduct;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("myerp_StoreProduct.edit")
@UiDescriptor("store-product-edit.xml")
@EditedEntityContainer("storeProductDc")
@LoadDataBeforeShow
public class StoreProductEdit extends StandardEditor<StoreProduct> {
}