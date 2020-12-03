package com.company.myerp.web.screens.commercialnetwork;

import com.haulmont.cuba.gui.screen.*;
import com.company.myerp.entity.CommercialNetwork;

@UiController("myerp_CommercialNetwork.edit")
@UiDescriptor("commercial-network-edit.xml")
@EditedEntityContainer("commercialNetworkDc")
@LoadDataBeforeShow
public class CommercialNetworkEdit extends StandardEditor<CommercialNetwork> {
}