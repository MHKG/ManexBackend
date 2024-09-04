package com.manex.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_cust_order_ar")
public class TbCustOrderAr implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "CUST_INVOICE_ID", nullable = false)
    private Integer custInvoiceId;

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
