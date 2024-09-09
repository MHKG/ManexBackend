package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_client_inventory")
public class TbClientInventory {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private Integer APP_CLIENT_ID;

    @Column(nullable = false)
    private Integer PRODUCT_ID;

    @Column private Float LAST_PRICE;

    @Column private Integer QTY;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getAPP_CLIENT_ID() {
        return APP_CLIENT_ID;
    }

    public void setAPP_CLIENT_ID(Integer APP_CLIENT_ID) {
        this.APP_CLIENT_ID = APP_CLIENT_ID;
    }

    public Integer getPRODUCT_ID() {
        return PRODUCT_ID;
    }

    public void setPRODUCT_ID(Integer PRODUCT_ID) {
        this.PRODUCT_ID = PRODUCT_ID;
    }

    public Float getLAST_PRICE() {
        return LAST_PRICE;
    }

    public void setLAST_PRICE(Float LAST_PRICE) {
        this.LAST_PRICE = LAST_PRICE;
    }

    public Integer getQTY() {
        return QTY;
    }

    public void setQTY(Integer QTY) {
        this.QTY = QTY;
    }
}
