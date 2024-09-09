package com.manex.backend.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_cust_shipment")
public class TbCustShipment {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private Integer CONTAINER_ID;

    @Column private Integer CONTAINER_QR_NUM;

    @Column private Integer SEAL_NUMBER;

    @Column private Integer SHIPPING_FROM_ADDR;

    @Column private Integer SHIPPING_TO_ADDR;

    @Column private Date SHIPPING_DATE;

    @Column private Integer DELIVERY_STATUS;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getCONTAINER_ID() {
        return CONTAINER_ID;
    }

    public void setCONTAINER_ID(Integer CONTAINER_ID) {
        this.CONTAINER_ID = CONTAINER_ID;
    }

    public Integer getCONTAINER_QR_NUM() {
        return CONTAINER_QR_NUM;
    }

    public void setCONTAINER_QR_NUM(Integer CONTAINER_QR_NUM) {
        this.CONTAINER_QR_NUM = CONTAINER_QR_NUM;
    }

    public Integer getSEAL_NUMBER() {
        return SEAL_NUMBER;
    }

    public void setSEAL_NUMBER(Integer SEAL_NUMBER) {
        this.SEAL_NUMBER = SEAL_NUMBER;
    }

    public Integer getSHIPPING_FROM_ADDR() {
        return SHIPPING_FROM_ADDR;
    }

    public void setSHIPPING_FROM_ADDR(Integer SHIPPING_FROM_ADDR) {
        this.SHIPPING_FROM_ADDR = SHIPPING_FROM_ADDR;
    }

    public Integer getSHIPPING_TO_ADDR() {
        return SHIPPING_TO_ADDR;
    }

    public void setSHIPPING_TO_ADDR(Integer SHIPPING_TO_ADDR) {
        this.SHIPPING_TO_ADDR = SHIPPING_TO_ADDR;
    }

    public Date getSHIPPING_DATE() {
        return SHIPPING_DATE;
    }

    public void setSHIPPING_DATE(Date SHIPPING_DATE) {
        this.SHIPPING_DATE = SHIPPING_DATE;
    }

    public Integer getDELIVERY_STATUS() {
        return DELIVERY_STATUS;
    }

    public void setDELIVERY_STATUS(Integer DELIVERY_STATUS) {
        this.DELIVERY_STATUS = DELIVERY_STATUS;
    }
}
