package com.company.myerp.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum StoreType implements EnumClass<String> {

    NEAR_HOME("Near home"),
    SUPER_MARKET("Super market"),
    HYPER_MARKET("Hyper market");

    private String id;

    StoreType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static StoreType fromId(String id) {
        for (StoreType at : StoreType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}