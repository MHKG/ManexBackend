package com.manex.backend.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
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
}
