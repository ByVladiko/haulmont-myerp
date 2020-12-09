package com.company.myerp.core.role;

import com.haulmont.cuba.security.app.role.AnnotatedRoleDefinition;
import com.haulmont.cuba.security.app.role.annotation.Role;

@Role(name = CashierRole.NAME)
public class CashierRole extends AnnotatedRoleDefinition {
    public final static String NAME = "Cashier";
}
