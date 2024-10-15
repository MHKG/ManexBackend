package com.manex.backend.entities;

import com.manex.backend.enums.PaymentMethod;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "tb_cust_order_ar")
public class TbCustOrderAr {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private Integer CUST_INVOICE_ID;

    @Column(nullable = false)
    private Float AMOUNT_PAID;

    @Column(nullable = false)
    private Date DATE_PAID;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentMethod PAYMENT_METHOD;

    @Column private String TXN_ID;

    @Column private Integer PAYMENT_MM;

    @Column private String DESCRIPTION;
}
