package com.manex.backend.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "tb_customer_quotation")
public class TbCustomerQuotation {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column private Integer CUST_PO_ID;

    @Column private String CUST_QUOT_NUM;

    @Column private Float TOTAL_GOODS_AMOUNT;

    @Column private Float AGENTS_COMMISION_PERCENTAGE;

    @Column private Float AGENTS_COMMISION_AMOUNT;

    @Column private Integer INVOICE_CURRENCY;

    @Column private Float INVOICE_CURRENCY_RATE;

    @Column private Float SHIPPING_COST;

    @Column private Float TOTAL_INV_AMOUNT;

    @Column private Integer QUOTATION_MM;

    @Column private Date CREATED_ON;

    @Column private Integer UPDATED_BY;

    @Column private String DESCRIPTION;

    @Column private Boolean STATUS;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getCUST_PO_ID() {
        return CUST_PO_ID;
    }

    public void setCUST_PO_ID(Integer CUST_PO_ID) {
        this.CUST_PO_ID = CUST_PO_ID;
    }

    public String getCUST_QUOT_NUM() {
        return CUST_QUOT_NUM;
    }

    public void setCUST_QUOT_NUM(String CUST_QUOT_NUM) {
        this.CUST_QUOT_NUM = CUST_QUOT_NUM;
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

    public Float getAGENTS_COMMISION_AMOUNT() {
        return AGENTS_COMMISION_AMOUNT;
    }

    public void setAGENTS_COMMISION_AMOUNT(Float AGENTS_COMMISION_AMOUNT) {
        this.AGENTS_COMMISION_AMOUNT = AGENTS_COMMISION_AMOUNT;
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

    public Float getTOTAL_INV_AMOUNT() {
        return TOTAL_INV_AMOUNT;
    }

    public void setTOTAL_INV_AMOUNT(Float TOTAL_INV_AMOUNT) {
        this.TOTAL_INV_AMOUNT = TOTAL_INV_AMOUNT;
    }

    public Integer getQUOTATION_MM() {
        return QUOTATION_MM;
    }

    public void setQUOTATION_MM(Integer QUOTATION_MM) {
        this.QUOTATION_MM = QUOTATION_MM;
    }

    public Date getCREATED_ON() {
        return CREATED_ON;
    }

    public void setCREATED_ON(Date CREATED_ON) {
        this.CREATED_ON = CREATED_ON;
    }

    public Integer getUPDATED_BY() {
        return UPDATED_BY;
    }

    public void setUPDATED_BY(Integer UPDATED_BY) {
        this.UPDATED_BY = UPDATED_BY;
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
