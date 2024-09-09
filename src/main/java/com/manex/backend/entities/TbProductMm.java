package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_product_mm")
public class TbProductMm {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private Integer PRODUCT_ID;

    @Column(nullable = false)
    private Integer MM_FILE;

    @Column private Character DEFAULT_MM;

    @Column private Boolean STATUS;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getPRODUCT_ID() {
        return PRODUCT_ID;
    }

    public void setPRODUCT_ID(Integer PRODUCT_ID) {
        this.PRODUCT_ID = PRODUCT_ID;
    }

    public Integer getMM_FILE() {
        return MM_FILE;
    }

    public void setMM_FILE(Integer MM_FILE) {
        this.MM_FILE = MM_FILE;
    }

    public Character getDEFAULT_MM() {
        return DEFAULT_MM;
    }

    public void setDEFAULT_MM(Character DEFAULT_MM) {
        this.DEFAULT_MM = DEFAULT_MM;
    }

    public void setSTATUS(Boolean STATUS) {
        this.STATUS = STATUS;
    }

    public Boolean isStatus() {
        return STATUS;
    }
}
