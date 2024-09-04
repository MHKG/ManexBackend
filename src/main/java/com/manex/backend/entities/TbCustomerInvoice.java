package com.manex.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_customer_invoice")
public class TbCustomerInvoice implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "CUST_PI_ID", nullable = false)
    private Integer custPiId;

    @Column(name = "cust_inv_num")
    private String custInvNum;

    @Column(name = "INV_MM")
    private Integer invMm;

    @Column(name = "UPDATED_BY", nullable = false)
    private Integer updatedBy;

    @Column(name = "CREATED_ON")
    private Integer createdOn;

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
    private Integer deliveryDate;

    @Column(name = "SHIPPING_DATE")
    private Integer shippingDate;

    @Column(name = "description")
    private String description;

    @Column(name = "STATUS")
    private Boolean status;
}
