package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_product_spec")
public class TbProductSpec {

    @Id @Column private Integer PRODUCT_ID;

    @Column private String COLOUR;

    @Column private String MATERIAL;

    @Column private String PACKING;

    @Column private Float PRICE;

    public Integer getPRODUCT_ID() {
        return PRODUCT_ID;
    }

    public void setPRODUCT_ID(Integer PRODUCT_ID) {
        this.PRODUCT_ID = PRODUCT_ID;
    }

    public String getCOLOUR() {
        return COLOUR;
    }

    public void setCOLOUR(String COLOUR) {
        this.COLOUR = COLOUR;
    }

    public String getMATERIAL() {
        return MATERIAL;
    }

    public void setMATERIAL(String MATERIAL) {
        this.MATERIAL = MATERIAL;
    }

    public String getPACKING() {
        return PACKING;
    }

    public void setPACKING(String PACKING) {
        this.PACKING = PACKING;
    }

    public Float getPRICE() {
        return PRICE;
    }

    public void setPRICE(Float PRICE) {
        this.PRICE = PRICE;
    }
}
