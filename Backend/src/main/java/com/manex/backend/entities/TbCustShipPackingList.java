package com.manex.backend.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
