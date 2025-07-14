package com.manex.backend.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.Formula;

import java.util.Date;

@Getter
@Setter
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

    @Formula("TOTAL_GOODS_AMOUNT + SHIPPING_COST")
    private Float GRAND_TOTAL;
}
