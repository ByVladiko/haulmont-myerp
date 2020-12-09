package com.company.myerp.service.exception;

import com.haulmont.cuba.core.global.SupportedByClient;

@SupportedByClient
public class PurchaseServiceException extends Exception {

    public PurchaseServiceException(String message) {
        super(message);
    }
}
