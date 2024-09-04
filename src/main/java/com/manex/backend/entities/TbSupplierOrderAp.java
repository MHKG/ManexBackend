package com.manex.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_supplier_order_ap")
public class TbSupplierOrderAp implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "SUPPLIER_INVOICE_ID", nullable = false)
    private Integer supplierInvoiceId;

    @Column(name = "AMOUNT_PAID", nullable = false)
    private Float amountPaid;

    @Column(name = "DATE_PAID", nullable = false)
    private Integer datePaid;

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    @Column(name = "txn_id")
    private String txnId;

    @Column(name = "PAYMENT_MM")
    private Integer paymentMm;

    @Column(name = "description")
    private String description;
}
