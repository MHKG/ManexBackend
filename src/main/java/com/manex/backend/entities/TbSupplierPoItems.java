package com.manex.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_supplier_po_items")
public class TbSupplierPoItems implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "SUPPLIER_PO_ID", nullable = false)
    private Integer supplierPoId;

    @Column(name = "PRODUCT_ID", nullable = false)
    private Integer productId;

    @Column(name = "PRICE_PER_ITEM")
    private Float pricePerItem;

    @Column(name = "QTY")
    private Integer qty;

    @Column(name = "description")
    private String description;
}
