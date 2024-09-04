package com.manex.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_company_product_number")
public class TbCompanyProductNumber implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId private TbCompanyProductNumberId id;

    @Column(name = "ITEM_NO", nullable = false)
    private String itemNo;

    @Column(name = "BAR_CODE")
    private String barCode;

    @Column(name = "DUN_BAR_CODE")
    private String dunBarCode;

    // Getters and setters
    public TbCompanyProductNumberId getId() {
        return id;
    }

    public void setId(TbCompanyProductNumberId id) {
        this.id = id;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getDunBarCode() {
        return dunBarCode;
    }

    public void setDunBarCode(String dunBarCode) {
        this.dunBarCode = dunBarCode;
    }
}
