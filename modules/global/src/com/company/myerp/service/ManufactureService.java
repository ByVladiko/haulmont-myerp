package com.company.myerp.service;

import com.company.myerp.entity.Product;
import com.company.myerp.entity.Store;

import java.util.List;

public interface ManufactureService {
    String NAME = "myerp_ManufactureServices";

    List<Product> storeProductListCountLessNum(Store store, int count);

    List<Store> storeListWhereNotSellProduct(Product product);

}