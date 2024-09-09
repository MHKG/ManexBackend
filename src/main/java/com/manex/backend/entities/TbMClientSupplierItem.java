package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_m_client_supplier_item")
public class TbMClientSupplierItem {

    @EmbeddedId private TbMClientSupplierItemId ID;

    @Column private Character IS_PROD_FAV;

    @Column private Integer STATUS;

    public TbMClientSupplierItemId getID() {
        return ID;
    }

    public void setID(TbMClientSupplierItemId ID) {
        this.ID = ID;
    }

    public Character getIS_PROD_FAV() {
        return IS_PROD_FAV;
    }

    public void setIS_PROD_FAV(Character IS_PROD_FAV) {
        this.IS_PROD_FAV = IS_PROD_FAV;
    }

    public Integer getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(Integer STATUS) {
        this.STATUS = STATUS;
    }
}
