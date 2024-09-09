package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_supplier_po_items")
public class TbSupplierPoItems {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private Integer SUPPLIER_PO_ID;

    @Column(nullable = false)
    private Integer PRODUCT_ID;

    @Column private Float PRICE_PER_ITEM;

    @Column private Integer QTY;

    @Column private String DESCRIPTION;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getSUPPLIER_PO_ID() {
        return SUPPLIER_PO_ID;
    }

    public void setSUPPLIER_PO_ID(Integer SUPPLIER_PO_ID) {
        this.SUPPLIER_PO_ID = SUPPLIER_PO_ID;
    }

    public Integer getPRODUCT_ID() {
        return PRODUCT_ID;
    }

    public void setPRODUCT_ID(Integer PRODUCT_ID) {
        this.PRODUCT_ID = PRODUCT_ID;
    }

    public Float getPRICE_PER_ITEM() {
        return PRICE_PER_ITEM;
    }

    public void setPRICE_PER_ITEM(Float PRICE_PER_ITEM) {
        this.PRICE_PER_ITEM = PRICE_PER_ITEM;
    }

    public Integer getQTY() {
        return QTY;
    }

    public void setQTY(Integer QTY) {
        this.QTY = QTY;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }
}
