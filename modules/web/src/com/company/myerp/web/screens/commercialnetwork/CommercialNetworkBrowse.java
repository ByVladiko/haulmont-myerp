package com.company.myerp.web.screens.commercialnetwork;

import com.haulmont.cuba.gui.screen.*;
import com.company.myerp.entity.CommercialNetwork;

@UiController("myerp_CommercialNetwork.browse")
@UiDescriptor("commercial-network-browse.xml")
@LookupComponent("commercialNetworksTable")
@LoadDataBeforeShow
public class CommercialNetworkBrowse extends StandardLookup<CommercialNetwork> {
}