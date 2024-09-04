package com.manex.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_cust_shipment")
public class TbCustShipment implements Serializable {

    private static final long serialVersionUID = 1L;

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
}
