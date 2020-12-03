package com.company.myerp.service;

import com.company.myerp.core.StoreStatistics;
import com.company.myerp.entity.CommercialNetwork;
import com.company.myerp.entity.Store;
import com.company.myerp.web.screens.services.stores.NumberPurchases;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service(StoreService.NAME)
public class StoreServiceBean implements StoreService {

    @Inject
    private StoreStatistics storeStatistics;

    @Override
    public List<NumberPurchases> countPurchasesCommercialNetwork(CommercialNetwork commercialNetwork) {
        Map<Store, Long> countPurchases = storeStatistics.countPurchasesCommercialNetwork(commercialNetwork);
        List<NumberPurchases> numberPurchasesList = new ArrayList<>();
        countPurchases.forEach((key, value) -> numberPurchasesList.add(new NumberPurchases(key, value)));
        return numberPurchasesList;
    }

}