package com.manex.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_cust_ship_packing_list")
public class TbCustShipPackingList implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "SHIPMENT_ID", nullable = false)
    private Integer shipmentId;

    @Column(name = "CUST_INV_ID", nullable = false)
    private Integer custInvId;

    @Column(name = "PRODUCT_ID", nullable = false)
    private Integer productId;

    @Column(name = "CTN_ID", nullable = false)
    private Integer ctnId;

    @Column(name = "CTN_QR_NUMBER")
    private Integer ctnQrNumber;
}
