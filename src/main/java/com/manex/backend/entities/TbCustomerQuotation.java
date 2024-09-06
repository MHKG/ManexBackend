package com.manex.backend.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "tb_customer_quotation")
public class TbCustomerQuotation {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "CUST_PO_ID")
    private Integer custPoId;

    @Column(name = "CUST_QUOT_NUM")
    private String custQuotNum;

    @Column(name = "TOTAL_GOODS_AMOUNT")
    private Float totalGoodsAmount;

    @Column(name = "AGENTS_COMMISION_PERCENTAGE")
    private Float agentsCommisionPercentage;

    @Column(name = "AGENTS_COMMISION_AMOUNT")
    private Float agentsCommisionAmount;

    @Column(name = "INVOICE_CURRENCY")
    private Integer invoiceCurrency;

    @Column(name = "INVOICE_CURRENCY_RATE")
    private Float invoiceCurrencyRate;

    @Column(name = "SHIPPING_COST")
    private Float shippingCost;

    @Column(name = "TOTAL_INV_AMOUNT")
    private Float totalInvAmount;

    @Column(name = "QUOTATION_MM")
    private Integer quotationMm;

    @Column(name = "CREATED_ON")
    private Date createdOn;

    @Column(name = "UPDATED_BY")
    private Integer updatedBy;

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

    public Integer getCustPoId() {
        return custPoId;
    }

    public void setCustPoId(Integer custPoId) {
        this.custPoId = custPoId;
    }

    public String getCustQuotNum() {
        return custQuotNum;
    }

    public void setCustQuotNum(String custQuotNum) {
        this.custQuotNum = custQuotNum;
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

    public Float getAgentsCommisionAmount() {
        return agentsCommisionAmount;
    }

    public void setAgentsCommisionAmount(Float agentsCommisionAmount) {
        this.agentsCommisionAmount = agentsCommisionAmount;
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

    public Float getTotalInvAmount() {
        return totalInvAmount;
    }

    public void setTotalInvAmount(Float totalInvAmount) {
        this.totalInvAmount = totalInvAmount;
    }

    public Integer getQuotationMm() {
        return quotationMm;
    }

    public void setQuotationMm(Integer quotationMm) {
        this.quotationMm = quotationMm;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
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
