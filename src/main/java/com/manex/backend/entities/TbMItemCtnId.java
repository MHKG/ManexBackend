package com.manex.backend.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TbMItemCtnId implements Serializable {

    private Integer productId;
    private Integer ctnId;

    // Default constructor
    public TbMItemCtnId() {}

    // Parameterized constructor
    public TbMItemCtnId(Integer productId, Integer companyId) {
        this.productId = productId;
        this.ctnId = companyId;
    }

    // Getters, setters, equals, and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbMItemCtnId that = (TbMItemCtnId) o;
        return Objects.equals(productId, that.productId) && Objects.equals(ctnId, that.ctnId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, ctnId);
    }

    // Getters and setters
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCtnId() {
        return ctnId;
    }

    public void setCtnId(Integer ctnId) {
        this.ctnId = ctnId;
    }
}
