package com.manex.backend.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tb_supplier_quotation")
public class TbSupplierQuotation {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private Integer SUPP_PO_ID;

    @Column private String SUPPLIER_QUOT_NUM;

    @Column private Integer QUOTATION_MM;

    @Column private Date TIMESTAMP;

    @Column private Integer UPDATED_BY;

    @Column private Integer STATUS;

    @Column private String DESCRIPTION;
}
