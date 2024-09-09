package com.manex.backend.entities;

import com.manex.backend.enums.PaymentMethod;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "tb_cust_order_ar")
public class TbCustOrderAr {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private Integer CUST_INVOICE_ID;

    @Column(nullable = false)
    private Float AMOUNT_PAID;

    @Column(nullable = false)
    private Date DATE_PAID;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentMethod PAYMENT_METHOD;

    @Column private String TXN_ID;

    @Column private Integer PAYMENT_MM;

    @Column private String DESCRIPTION;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getCUST_INVOICE_ID() {
        return CUST_INVOICE_ID;
    }

    public void setCUST_INVOICE_ID(Integer CUST_INVOICE_ID) {
        this.CUST_INVOICE_ID = CUST_INVOICE_ID;
    }

    public Float getAMOUNT_PAID() {
        return AMOUNT_PAID;
    }

    public void setAMOUNT_PAID(Float AMOUNT_PAID) {
        this.AMOUNT_PAID = AMOUNT_PAID;
    }

    public Date getDATE_PAID() {
        return DATE_PAID;
    }

    public void setDATE_PAID(Date DATE_PAID) {
        this.DATE_PAID = DATE_PAID;
    }

    public PaymentMethod getPAYMENT_METHOD() {
        return PAYMENT_METHOD;
    }

    public void setPAYMENT_METHOD(PaymentMethod PAYMENT_METHOD) {
        this.PAYMENT_METHOD = PAYMENT_METHOD;
    }

    public String getTXN_ID() {
        return TXN_ID;
    }

    public void setTXN_ID(String TXN_ID) {
        this.TXN_ID = TXN_ID;
    }

    public Integer getPAYMENT_MM() {
        return PAYMENT_MM;
    }

    public void setPAYMENT_MM(Integer PAYMENT_MM) {
        this.PAYMENT_MM = PAYMENT_MM;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }
}
