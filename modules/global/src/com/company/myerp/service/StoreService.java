package com.company.myerp.service;

import com.company.myerp.entity.CommercialNetwork;
import com.company.myerp.web.screens.services.stores.NumberPurchases;

import java.util.List;

public interface StoreService {
    String NAME = "myerp_StoreService";

    List<NumberPurchases> countPurchasesCommercialNetwork(CommercialNetwork commercialNetwork);
}