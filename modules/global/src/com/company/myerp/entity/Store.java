package com.company.myerp.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.EmbeddedParameters;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Table(name = "MYERP_STORE")
@Entity(name = "myerp_Store")
@NamePattern("%s %s|number,name")
public class Store extends StandardEntity {
    private static final long serialVersionUID = 2163667556375863415L;

    @NotNull
    @Column(name = "NUMBER_", nullable = false, unique = true)
    private String number;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @NotNull
    @Embedded
    @EmbeddedParameters(nullAllowed = false)
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "ADDRESS_CITY")),
            @AttributeOverride(name = "street", column = @Column(name = "ADDRESS_STREET")),
            @AttributeOverride(name = "house", column = @Column(name = "ADDRESS_HOUSE"))
    })
    private Address address;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "COMMERCIAL_NETWORK_ID")
    private CommercialNetwork commercialNetwork;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "store")
    private List<StoreProduct> products;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public CommercialNetwork getCommercialNetwork() {
        return commercialNetwork;
    }

    public void setCommercialNetwork(CommercialNetwork commercialNetwork) {
        this.commercialNetwork = commercialNetwork;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<StoreProduct> getProducts() {
        return products;
    }

    public void setProducts(List<StoreProduct> products) {
        this.products = products;
    }
}