package com.manex.backend.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
