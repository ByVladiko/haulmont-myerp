package com.company.myerp.service;

import com.company.myerp.entity.PurchaseProduct;

import java.util.List;

public interface PurchaseService {
    String NAME = "myerp_PurchaseService";

    void WriteOutStoreProductsOfPurchase(List<PurchaseProduct> purchaseProducts) throws com.company.myerp.service.exception.PurchaseServiceException;
}