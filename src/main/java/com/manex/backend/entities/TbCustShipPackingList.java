package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_cust_ship_packing_list")
public class TbCustShipPackingList {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private Integer SHIPMENT_ID;

    @Column(nullable = false)
    private Integer CUST_INV_ID;

    @Column(nullable = false)
    private Integer PRODUCT_ID;

    @Column(nullable = false)
    private Integer CTN_ID;

    @Column private Integer CTN_QR_NUMBER;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getSHIPMENT_ID() {
        return SHIPMENT_ID;
    }

    public void setSHIPMENT_ID(Integer SHIPMENT_ID) {
        this.SHIPMENT_ID = SHIPMENT_ID;
    }

    public Integer getCUST_INV_ID() {
        return CUST_INV_ID;
    }

    public void setCUST_INV_ID(Integer CUST_INV_ID) {
        this.CUST_INV_ID = CUST_INV_ID;
    }

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

    public Integer getCTN_QR_NUMBER() {
        return CTN_QR_NUMBER;
    }

    public void setCTN_QR_NUMBER(Integer CTN_QR_NUMBER) {
        this.CTN_QR_NUMBER = CTN_QR_NUMBER;
    }
}
