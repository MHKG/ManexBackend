package com.manex.backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TbCompanyProductNumberId implements Serializable {

    @Column(name = "PRODUCT_ID")
    private int PRODUCT_ID;

    @Column(name = "APP_CLIENT_ID")
    private int APP_CLIENT_ID;

    @Column(name = "COMPANY_ID")
    private int COMPANY_ID;

    // Default constructor
    public TbCompanyProductNumberId() {}

    // Parameterized constructor
    public TbCompanyProductNumberId(Integer PRODUCT_ID, Integer APP_CLIENT_ID, Integer COMPANY_ID) {
        this.PRODUCT_ID = PRODUCT_ID;
        this.APP_CLIENT_ID = APP_CLIENT_ID;
        this.COMPANY_ID = COMPANY_ID;
    }

    // Getters, setters, equals, and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbCompanyProductNumberId that = (TbCompanyProductNumberId) o;
        return Objects.equals(PRODUCT_ID, that.PRODUCT_ID)
                && Objects.equals(APP_CLIENT_ID, that.APP_CLIENT_ID)
                && Objects.equals(COMPANY_ID, that.COMPANY_ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(PRODUCT_ID, APP_CLIENT_ID, COMPANY_ID);
    }

    public Integer getPRODUCT_ID() {
        return PRODUCT_ID;
    }

    public void setPRODUCT_ID(Integer PRODUCT_ID) {
        this.PRODUCT_ID = PRODUCT_ID;
    }

    public Integer getAPP_CLIENT_ID() {
        return APP_CLIENT_ID;
    }

    public void setAPP_CLIENT_ID(Integer APP_CLIENT_ID) {
        this.APP_CLIENT_ID = APP_CLIENT_ID;
    }

    public Integer getCOMPANY_ID() {
        return COMPANY_ID;
    }

    public void setCOMPANY_ID(Integer COMPANY_ID) {
        this.COMPANY_ID = COMPANY_ID;
    }
}
