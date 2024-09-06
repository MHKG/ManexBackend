package com.manex.backend.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "tb_customer_invoice")
public class TbCustomerInvoice {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "CUST_PI_ID", nullable = false)
    private Integer custPiId;

    @Column(name = "CUST_INV_NUM")
    private String custInvNum;

    @Column(name = "INV_MM")
    private Integer invMm;

    @Column(name = "UPDATED_BY", nullable = false)
    private Integer updatedBy;

    @Column(name = "CREATED_ON")
    private Date createdOn;

    @Column(name = "TOTAL_GOODS_AMOUNT", nullable = false)
    private Float totalGoodsAmount;

    @Column(name = "AGENTS_COMMISION_PERCENTAGE", nullable = false)
    private Float agentsCommisionPercentage;

    @Column(name = "INVOICE_CURRENCY", nullable = false)
    private Integer invoiceCurrency;

    @Column(name = "INVOICE_CURRENCY_RATE", nullable = false)
    private Float invoiceCurrencyRate;

    @Column(name = "SHIPPING_COST")
    private Float shippingCost;

    @Column(name = "TOTAL_INVOICE_VALUE", nullable = false)
    private Float totalInvoiceValue;

    @Column(name = "PAYMENT_STATUS")
    private Integer paymentStatus;

    @Column(name = "DELIVERY_DATE")
    private Date deliveryDate;

    @Column(name = "SHIPPING_DATE")
    private Date shippingDate;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "STATUS")
    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustPiId() {
        return custPiId;
    }

    public void setCustPiId(Integer custPiId) {
        this.custPiId = custPiId;
    }

    public String getCustInvNum() {
        return custInvNum;
    }

    public void setCustInvNum(String custInvNum) {
        this.custInvNum = custInvNum;
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

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Float getTotalGoodsAmount() {
        return totalGoodsAmount;
    }

    public void setTotalGoodsAmount(Float totalGoodsAmount) {
        this.totalGoodsAmount = totalGoodsAmount;
    }

    public Float getAgentsCommisionPercentage() {
        return agentsCommisionPercentage;
    }

    public void setAgentsCommisionPercentage(Float agentsCommisionPercentage) {
        this.agentsCommisionPercentage = agentsCommisionPercentage;
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

    public Float getTotalInvoiceValue() {
        return totalInvoiceValue;
    }

    public void setTotalInvoiceValue(Float totalInvoiceValue) {
        this.totalInvoiceValue = totalInvoiceValue;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean isStatus() {
        return status;
    }
}
