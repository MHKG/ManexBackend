package com.manex.backend.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_cust_shipment")
public class TbCustShipment {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "CONTAINER_ID", nullable = false)
    private Integer containerId;

    @Column(name = "CONTAINER_QR_NUM")
    private Integer containerQrNum;

    @Column(name = "SEAL_NUMBER")
    private Integer sealNumber;

    @Column(name = "SHIPPING_FROM_ADDR")
    private Integer shippingFromAddr;

    @Column(name = "SHIPPING_TO_ADDR")
    private Integer shippingToAddr;

    @Column(name = "SHIPPING_DATE")
    private Date shippingDate;

    @Column(name = "DELIVERY_STATUS")
    private Integer deliveryStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContainerId() {
        return containerId;
    }

    public void setContainerId(Integer containerId) {
        this.containerId = containerId;
    }

    public Integer getContainerQrNum() {
        return containerQrNum;
    }

    public void setContainerQrNum(Integer containerQrNum) {
        this.containerQrNum = containerQrNum;
    }

    public Integer getSealNumber() {
        return sealNumber;
    }

    public void setSealNumber(Integer sealNumber) {
        this.sealNumber = sealNumber;
    }

    public Integer getShippingFromAddr() {
        return shippingFromAddr;
    }

    public void setShippingFromAddr(Integer shippingFromAddr) {
        this.shippingFromAddr = shippingFromAddr;
    }

    public Integer getShippingToAddr() {
        return shippingToAddr;
    }

    public void setShippingToAddr(Integer shippingToAddr) {
        this.shippingToAddr = shippingToAddr;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public Integer getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(Integer deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}
