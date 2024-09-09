package com.manex.backend.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "tb_customer_invoice")
public class TbCustomerInvoice {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private Integer CUST_PI_ID;

    @Column private String CUST_INV_NUM;

    @Column private Integer INV_MM;

    @Column(nullable = false)
    private Integer UPDATED_BY;

    @Column private Date CREATED_ON;

    @Column(nullable = false)
    private Float TOTAL_GOODS_AMOUNT;

    @Column(nullable = false)
    private Float AGENTS_COMMISION_PERCENTAGE;

    @Column(nullable = false)
    private Integer INVOICE_CURRENCY;

    @Column(nullable = false)
    private Float INVOICE_CURRENCY_RATE;

    @Column private Float SHIPPING_COST;

    @Column(nullable = false)
    private Float TOTAL_INVOICE_VALUE;

    @Column private Integer PAYMENT_STATUS;

    @Column private Date DELIVERY_DATE;

    @Column private Date SHIPPING_DATE;

    @Column private String DESCRIPTION;

    @Column private Boolean STATUS;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getCUST_PI_ID() {
        return CUST_PI_ID;
    }

    public void setCUST_PI_ID(Integer CUST_PI_ID) {
        this.CUST_PI_ID = CUST_PI_ID;
    }

    public String getCUST_INV_NUM() {
        return CUST_INV_NUM;
    }

    public void setCUST_INV_NUM(String CUST_INV_NUM) {
        this.CUST_INV_NUM = CUST_INV_NUM;
    }

    public Integer getINV_MM() {
        return INV_MM;
    }

    public void setINV_MM(Integer INV_MM) {
        this.INV_MM = INV_MM;
    }

    public Integer getUPDATED_BY() {
        return UPDATED_BY;
    }

    public void setUPDATED_BY(Integer UPDATED_BY) {
        this.UPDATED_BY = UPDATED_BY;
    }

    public Date getCREATED_ON() {
        return CREATED_ON;
    }

    public void setCREATED_ON(Date CREATED_ON) {
        this.CREATED_ON = CREATED_ON;
    }

    public Float getTOTAL_GOODS_AMOUNT() {
        return TOTAL_GOODS_AMOUNT;
    }

    public void setTOTAL_GOODS_AMOUNT(Float TOTAL_GOODS_AMOUNT) {
        this.TOTAL_GOODS_AMOUNT = TOTAL_GOODS_AMOUNT;
    }

    public Float getAGENTS_COMMISION_PERCENTAGE() {
        return AGENTS_COMMISION_PERCENTAGE;
    }

    public void setAGENTS_COMMISION_PERCENTAGE(Float AGENTS_COMMISION_PERCENTAGE) {
        this.AGENTS_COMMISION_PERCENTAGE = AGENTS_COMMISION_PERCENTAGE;
    }

    public Integer getINVOICE_CURRENCY() {
        return INVOICE_CURRENCY;
    }

    public void setINVOICE_CURRENCY(Integer INVOICE_CURRENCY) {
        this.INVOICE_CURRENCY = INVOICE_CURRENCY;
    }

    public Float getINVOICE_CURRENCY_RATE() {
        return INVOICE_CURRENCY_RATE;
    }

    public void setINVOICE_CURRENCY_RATE(Float INVOICE_CURRENCY_RATE) {
        this.INVOICE_CURRENCY_RATE = INVOICE_CURRENCY_RATE;
    }

    public Float getSHIPPING_COST() {
        return SHIPPING_COST;
    }

    public void setSHIPPING_COST(Float SHIPPING_COST) {
        this.SHIPPING_COST = SHIPPING_COST;
    }

    public Float getTOTAL_INVOICE_VALUE() {
        return TOTAL_INVOICE_VALUE;
    }

    public void setTOTAL_INVOICE_VALUE(Float TOTAL_INVOICE_VALUE) {
        this.TOTAL_INVOICE_VALUE = TOTAL_INVOICE_VALUE;
    }

    public Integer getPAYMENT_STATUS() {
        return PAYMENT_STATUS;
    }

    public void setPAYMENT_STATUS(Integer PAYMENT_STATUS) {
        this.PAYMENT_STATUS = PAYMENT_STATUS;
    }

    public Date getDELIVERY_DATE() {
        return DELIVERY_DATE;
    }

    public void setDELIVERY_DATE(Date DELIVERY_DATE) {
        this.DELIVERY_DATE = DELIVERY_DATE;
    }

    public Date getSHIPPING_DATE() {
        return SHIPPING_DATE;
    }

    public void setSHIPPING_DATE(Date SHIPPING_DATE) {
        this.SHIPPING_DATE = SHIPPING_DATE;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public Boolean getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(Boolean STATUS) {
        this.STATUS = STATUS;
    }
}
