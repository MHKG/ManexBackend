package com.manex.backend.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_supplier_invoice")
public class TbSupplierInvoice {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private Integer SUPP_PI_ID;

    @Column private String SUPP_INV_NUM;

    @Column private Integer INV_MM;

    @Column private Integer UPDATED_BY;

    @Column private Date TIMESTAMP;

    @Column private Float TOTAL_GOODS_AMOUNT;

    @Column private Integer INVOICE_CURRENCY;

    @Column private Float INVOICE_CURRENCY_RATE;

    @Column private Float SHIPPING_COST;

    @Column private Integer PAYMENT_STATUS;

    @Column private Integer STATUS;

    @Column private String REMARK;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getSUPP_PI_ID() {
        return SUPP_PI_ID;
    }

    public void setSUPP_PI_ID(Integer SUPP_PI_ID) {
        this.SUPP_PI_ID = SUPP_PI_ID;
    }

    public String getSUPP_INV_NUM() {
        return SUPP_INV_NUM;
    }

    public void setSUPP_INV_NUM(String SUPP_INV_NUM) {
        this.SUPP_INV_NUM = SUPP_INV_NUM;
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

    public Date getTIMESTAMP() {
        return TIMESTAMP;
    }

    public void setTIMESTAMP(Date TIMESTAMP) {
        this.TIMESTAMP = TIMESTAMP;
    }

    public Float getTOTAL_GOODS_AMOUNT() {
        return TOTAL_GOODS_AMOUNT;
    }

    public void setTOTAL_GOODS_AMOUNT(Float TOTAL_GOODS_AMOUNT) {
        this.TOTAL_GOODS_AMOUNT = TOTAL_GOODS_AMOUNT;
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

    public Integer getPAYMENT_STATUS() {
        return PAYMENT_STATUS;
    }

    public void setPAYMENT_STATUS(Integer PAYMENT_STATUS) {
        this.PAYMENT_STATUS = PAYMENT_STATUS;
    }

    public Integer getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(Integer STATUS) {
        this.STATUS = STATUS;
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK;
    }
}
