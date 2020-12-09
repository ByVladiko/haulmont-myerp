package com.company.myerp.core.role;

import com.haulmont.cuba.security.app.role.AnnotatedRoleDefinition;
import com.haulmont.cuba.security.app.role.annotation.Role;

@Role(name = OnlineStoreEmployeeRole.NAME)
public class OnlineStoreEmployeeRole extends AnnotatedRoleDefinition {
    public final static String NAME = "OnlineStoreEmployee";
}
