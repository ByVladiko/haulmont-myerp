package com.company.myerp.web.screens.services.stores;

import com.company.myerp.entity.Store;
import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseUuidEntity;

@MetaClass(name = "myerp_NumberPurchases")
@NamePattern("%s|store,number")
public class NumberPurchases extends BaseUuidEntity {
    private static final long serialVersionUID = 3199469257314709170L;

    public NumberPurchases(Store store, Long number) {
        this.store = store;
        this.number = number;
    }

    @MetaProperty
    private Store store;

    @MetaProperty
    private Long number;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}