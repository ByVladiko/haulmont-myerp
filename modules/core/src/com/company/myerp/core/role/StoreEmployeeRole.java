package com.company.myerp.core.role;

import com.haulmont.cuba.security.app.role.AnnotatedRoleDefinition;
import com.haulmont.cuba.security.app.role.annotation.Role;

@Role(name = StoreEmployeeRole.NAME)
public class StoreEmployeeRole extends AnnotatedRoleDefinition {
    public final static String NAME = "StoreEmployee";
}
