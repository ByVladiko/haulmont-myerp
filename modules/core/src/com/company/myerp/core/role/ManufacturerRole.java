package com.company.myerp.core.role;

import com.haulmont.cuba.security.app.role.AnnotatedRoleDefinition;
import com.haulmont.cuba.security.app.role.annotation.Role;

@Role(name = ManufacturerRole.NAME)
public class ManufacturerRole extends AnnotatedRoleDefinition {
    public final static String NAME = "Manufacturer";
}
