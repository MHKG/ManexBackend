package com.manex.backend.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "tb_customer_po")
public class TbCustomerPo {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column private String CUST_PO_NUM;

    @Column(nullable = false)
    private Integer APP_CLIENT_ID;

    @Column(nullable = false)
    private Integer CLIENT_CUST_ID;

    @Column private Date CREATED_ON;

    @Column private Integer CREATED_BY;

    @Column private Boolean MANAGER_APPROVAL_STATUS;

    @Column private Integer PO_MM;

    @Column private String DESCRIPTION;

    @Column private Boolean STATUS;
}
