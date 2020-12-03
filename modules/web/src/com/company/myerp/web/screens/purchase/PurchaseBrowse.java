package com.company.myerp.web.screens.purchase;

import com.haulmont.cuba.gui.screen.*;
import com.company.myerp.entity.Purchase;

@UiController("myerp_Purchase.browse")
@UiDescriptor("purchase-browse.xml")
@LookupComponent("purchasesTable")
@LoadDataBeforeShow
public class PurchaseBrowse extends StandardLookup<Purchase> {
}