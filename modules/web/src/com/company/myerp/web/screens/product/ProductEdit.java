package com.company.myerp.web.screens.product;

import com.haulmont.cuba.gui.screen.*;
import com.company.myerp.entity.Product;

@UiController("myerp_Product.edit")
@UiDescriptor("product-edit.xml")
@EditedEntityContainer("productDc")
@LoadDataBeforeShow
public class ProductEdit extends StandardEditor<Product> {
}