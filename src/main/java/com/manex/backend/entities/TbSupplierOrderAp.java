package com.manex.backend.entities;

import com.manex.backend.enums.PaymentMethod;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "tb_supplier_order_ap")
public class TbSupplierOrderAp {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "SUPPLIER_INVOICE_ID", nullable = false)
    private Integer supplierInvoiceId;

    @Column(name = "AMOUNT_PAID", nullable = false)
    private Float amountPaid;

    @Column(name = "DATE_PAID", nullable = false)
    private Date datePaid;

    @Column(name = "PAYMENT_METHOD", nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Column(name = "TXN_ID")
    private String txnId;

    @Column(name = "PAYMENT_MM")
    private Integer paymentMm;

    @Column(name = "DESCRIPTION")
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSupplierInvoiceId() {
        return supplierInvoiceId;
    }

    public void setSupplierInvoiceId(Integer supplierInvoiceId) {
        this.supplierInvoiceId = supplierInvoiceId;
    }

    public Float getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Float amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Date getDatePaid() {
        return datePaid;
    }

    public void setDatePaid(Date datePaid) {
        this.datePaid = datePaid;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getTxnId() {
        return txnId;
    }

    public void setTxnId(String txnId) {
        this.txnId = txnId;
    }

    public Integer getPaymentMm() {
        return paymentMm;
    }

    public void setPaymentMm(Integer paymentMm) {
        this.paymentMm = paymentMm;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
