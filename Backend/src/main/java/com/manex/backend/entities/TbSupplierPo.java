package com.manex.backend.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tb_supplier_po")
public class TbSupplierPo {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private String PO_NUM;

    @Column(nullable = false)
    private Integer APP_CLIENT_ID;

    @Column(nullable = false)
    private Integer CLIENT_SUPPLIER_ID;

    @Column private Date TIMESTAMP;

    @Column private Integer CREATED_BY;

    @Column private Integer MANAGER_APPROVAL_STATUS;

    @Column private Integer STATUS;

    @Column private Integer PO_MM;

    @Column private String DESCRIPTION;
}
