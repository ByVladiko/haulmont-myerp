package com.company.myerp.service;

import com.company.myerp.entity.Product;
import com.company.myerp.entity.Store;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(ManufactureService.NAME)
public class ManufactureServiceBean implements ManufactureService {

    @Inject
    private DataManager dataManager;

    @Override
    public List<Product> storeProductListCountLessNum(Store store, int count) {
        Map<String, Object> parametersQuery = new HashMap<>();
        parametersQuery.put("store", store);
        parametersQuery.put("count", count);

        String textQuery = "select a.product " +
                           "from myerp_StoreProduct a " +
                           "where a.store = :store and a.count < :count";

        return dataManager.load(Product.class)
                .query(textQuery)
                .setParameters(parametersQuery)
                .view("product-view")
                .list();
    }

    @Override
    public List<Store> storeListWhereNotSellProduct(Product product) {
        String textQuery = "select ms " +
                           "from myerp_Store ms " +
                           "left join myerp_StoreProduct msp " +
                           "on ms = msp.store and msp.product = :product " +
                           "where msp.product is NULL";

        return dataManager.load(Store.class)
                .query(textQuery)
                .parameter("product", product)
                .view("store-view")
                .list();
    }

}