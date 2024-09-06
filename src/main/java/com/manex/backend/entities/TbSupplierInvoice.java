package com.manex.backend.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_supplier_invoice")
public class TbSupplierInvoice {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "SUPP_PI_ID", nullable = false)
    private Integer suppPiId;

    @Column(name = "SUPP_INV_NUM")
    private String suppInvNum;

    @Column(name = "INV_MM")
    private Integer invMm;

    @Column(name = "UPDATED_BY")
    private Integer updatedBy;

    @Column(name = "TIMESTAMP")
    private Date timestamp;

    @Column(name = "TOTAL_GOODS_AMOUNT")
    private Float totalGoodsAmount;

    @Column(name = "INVOICE_CURRENCY")
    private Integer invoiceCurrency;

    @Column(name = "INVOICE_CURRENCY_RATE")
    private Float invoiceCurrencyRate;

    @Column(name = "SHIPPING_COST")
    private Float shippingCost;

    @Column(name = "PAYMENT_STATUS")
    private Integer paymentStatus;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "REMARK")
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSuppPiId() {
        return suppPiId;
    }

    public void setSuppPiId(Integer suppPiId) {
        this.suppPiId = suppPiId;
    }

    public String getSuppInvNum() {
        return suppInvNum;
    }

    public void setSuppInvNum(String suppInvNum) {
        this.suppInvNum = suppInvNum;
    }

    public Integer getInvMm() {
        return invMm;
    }

    public void setInvMm(Integer invMm) {
        this.invMm = invMm;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Float getTotalGoodsAmount() {
        return totalGoodsAmount;
    }

    public void setTotalGoodsAmount(Float totalGoodsAmount) {
        this.totalGoodsAmount = totalGoodsAmount;
    }

    public Integer getInvoiceCurrency() {
        return invoiceCurrency;
    }

    public void setInvoiceCurrency(Integer invoiceCurrency) {
        this.invoiceCurrency = invoiceCurrency;
    }

    public Float getInvoiceCurrencyRate() {
        return invoiceCurrencyRate;
    }

    public void setInvoiceCurrencyRate(Float invoiceCurrencyRate) {
        this.invoiceCurrencyRate = invoiceCurrencyRate;
    }

    public Float getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(Float shippingCost) {
        this.shippingCost = shippingCost;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
