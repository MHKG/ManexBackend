package com.manex.backend.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
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
}
