package com.manex.backend.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
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
}
