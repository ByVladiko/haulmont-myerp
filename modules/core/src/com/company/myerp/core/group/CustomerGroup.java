package com.company.myerp.core.group;

import com.haulmont.cuba.security.app.group.AnnotatedAccessGroupDefinition;
import com.haulmont.cuba.security.app.group.annotation.AccessGroup;

@AccessGroup(name = "Customer")
public class CustomerGroup extends AnnotatedAccessGroupDefinition {
}
