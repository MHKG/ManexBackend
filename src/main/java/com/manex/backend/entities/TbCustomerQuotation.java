package com.manex.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_customer_quotation")
public class TbCustomerQuotation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "CUST_PO_ID")
    private Integer custPoId;

    @Column(name = "cust_quot_num")
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
    private Integer createdOn;

    @Column(name = "UPDATED_BY")
    private Integer updatedBy;

    @Column(name = "description")
    private String description;

    @Column(name = "STATUS")
    private Boolean status;
}
