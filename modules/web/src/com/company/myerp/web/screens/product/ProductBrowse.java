package com.company.myerp.web.screens.product;

import com.haulmont.cuba.gui.screen.*;
import com.company.myerp.entity.Product;

@UiController("myerp_Product.browse")
@UiDescriptor("product-browse.xml")
@LookupComponent("productsTable")
@LoadDataBeforeShow
public class ProductBrowse extends StandardLookup<Product> {
}