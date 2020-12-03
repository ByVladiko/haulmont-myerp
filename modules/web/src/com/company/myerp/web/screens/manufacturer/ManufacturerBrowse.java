package com.company.myerp.web.screens.manufacturer;

import com.haulmont.cuba.gui.screen.*;
import com.company.myerp.entity.Manufacturer;

@UiController("myerp_Manufacturer.browse")
@UiDescriptor("manufacturer-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class ManufacturerBrowse extends MasterDetailScreen<Manufacturer> {
}