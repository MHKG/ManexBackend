package com.manex.backend.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TbMItemCtnId implements Serializable {

    private Integer PRODUCT_ID;
    private Integer CTN_ID;

    // Default constructor
    public TbMItemCtnId() {}

    // Parameterized constructor
    public TbMItemCtnId(Integer productId, Integer companyId) {
        this.PRODUCT_ID = productId;
        this.CTN_ID = companyId;
    }

    // Getters, setters, equals, and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbMItemCtnId that = (TbMItemCtnId) o;
        return Objects.equals(PRODUCT_ID, that.PRODUCT_ID) && Objects.equals(CTN_ID, that.CTN_ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(PRODUCT_ID, CTN_ID);
    }

    // Getters and setters
    public Integer getPRODUCT_ID() {
        return PRODUCT_ID;
    }

    public void setPRODUCT_ID(Integer PRODUCT_ID) {
        this.PRODUCT_ID = PRODUCT_ID;
    }

    public Integer getCTN_ID() {
        return CTN_ID;
    }

    public void setCTN_ID(Integer CTN_ID) {
        this.CTN_ID = CTN_ID;
    }
}
