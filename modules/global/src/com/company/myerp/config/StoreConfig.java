package com.company.myerp.config;

import com.haulmont.cuba.core.config.Config;
import com.haulmont.cuba.core.config.Property;
import com.haulmont.cuba.core.config.Source;
import com.haulmont.cuba.core.config.SourceType;
import com.haulmont.cuba.core.config.defaults.DefaultInteger;

@Source(type = SourceType.APP)
public interface StoreConfig extends Config {

    @Property("myerp.minimalNumberProductStoreItems")
    @DefaultInteger(50)
    Integer getMinimalNumberProductsStoreItems();

}