package com.manex.backend.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TbCompanyProductNumberId implements Serializable {

    private Integer productId;
    private Integer appClientId;
    private Integer companyId;

    // Default constructor
    public TbCompanyProductNumberId() {}

    // Parameterized constructor
    public TbCompanyProductNumberId(Integer productId, Integer appClientId, Integer companyId) {
        this.productId = productId;
        this.appClientId = appClientId;
        this.companyId = companyId;
    }

    // Getters, setters, equals, and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbCompanyProductNumberId that = (TbCompanyProductNumberId) o;
        return Objects.equals(productId, that.productId)
                && Objects.equals(appClientId, that.appClientId)
                && Objects.equals(companyId, that.companyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, appClientId, companyId);
    }

    // Getters and setters
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getAppClientId() {
        return appClientId;
    }

    public void setAppClientId(Integer appClientId) {
        this.appClientId = appClientId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}
