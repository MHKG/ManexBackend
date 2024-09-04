package com.manex.backend.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TbMClientSupplierItemId implements Serializable {

    private Integer clientSuppId;
    private Integer prodId;

    // Default constructor
    public TbMClientSupplierItemId() {}

    // Parameterized constructor
    public TbMClientSupplierItemId(Integer productId, Integer companyId) {
        this.clientSuppId = productId;
        this.prodId = companyId;
    }

    // Getters, setters, equals, and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbMClientSupplierItemId that = (TbMClientSupplierItemId) o;
        return Objects.equals(clientSuppId, that.clientSuppId)
                && Objects.equals(prodId, that.prodId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientSuppId, prodId);
    }

    // Getters and setters
    public Integer getClientSuppId() {
        return clientSuppId;
    }

    public void setClientSuppId(Integer clientSuppId) {
        this.clientSuppId = clientSuppId;
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }
}
