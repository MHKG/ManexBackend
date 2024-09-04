package com.manex.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_supplier_quotation")
public class TbSupplierQuotation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "SUPP_PO_ID", nullable = false)
    private Integer suppPoId;

    @Column(name = "supplier_quot_num")
    private String supplierQuotNum;

    @Column(name = "QUOTATION_MM")
    private Integer quotationMm;

    @Column(name = "TIMESTAMP")
    private Date timestamp;

    @Column(name = "UPDATED_BY")
    private Integer updatedBy;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "description")
    private String description;
}
