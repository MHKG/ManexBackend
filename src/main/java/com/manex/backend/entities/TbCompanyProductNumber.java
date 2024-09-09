package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_company_product_number")
public class TbCompanyProductNumber {

    @EmbeddedId private TbCompanyProductNumberId ID;

    @Column(nullable = false)
    private String ITEM_NO;

    @Column private String BAR_CODE;

    @Column private String DUN_BAR_CODE;

    public TbCompanyProductNumberId getID() {
        return ID;
    }

    public void setID(TbCompanyProductNumberId ID) {
        this.ID = ID;
    }

    public String getITEM_NO() {
        return ITEM_NO;
    }

    public void setITEM_NO(String ITEM_NO) {
        this.ITEM_NO = ITEM_NO;
    }

    public String getBAR_CODE() {
        return BAR_CODE;
    }

    public void setBAR_CODE(String BAR_CODE) {
        this.BAR_CODE = BAR_CODE;
    }

    public String getDUN_BAR_CODE() {
        return DUN_BAR_CODE;
    }

    public void setDUN_BAR_CODE(String DUN_BAR_CODE) {
        this.DUN_BAR_CODE = DUN_BAR_CODE;
    }
}
