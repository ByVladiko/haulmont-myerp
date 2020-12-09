package com.company.myerp.core.component;

import com.company.myerp.entity.CommercialNetwork;
import com.company.myerp.entity.Store;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.Map;
import java.util.stream.Collectors;

@Component(StoreStatistics.NAME)
public class StoreStatistics {
    public static final String NAME = "myerp_StoreStatistics";

    @Inject
    protected DataManager dataManager;

    public Map<Store, Long> countPurchasesCommercialNetwork(CommercialNetwork commercialNetwork) {
        String params = (commercialNetwork == null) ? "" : "where ms.commercialNetwork = :commercialNetwork ";
        String textQuery = "select ms, count(mp.id) " +
                "from myerp_Store ms " +
                "left join myerp_Purchase mp " +
                "on ms = mp.store " +
                params +
                "group by ms";

        return dataManager.loadValues(textQuery)
                .properties("store", "count")
                .parameter("commercialNetwork", commercialNetwork)
                .list().stream()
                .collect(Collectors.toMap(item -> item.getValue("store"), item ->  item.getValue("count")));
    }
}