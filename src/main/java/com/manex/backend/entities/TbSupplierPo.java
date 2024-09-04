package com.manex.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_supplier_po")
public class TbSupplierPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "po_num", nullable = false)
    private String poNum;

    @Column(name = "APP_CLIENT_ID", nullable = false)
    private Integer appClientId;

    @Column(name = "CLIENT_SUPPLIER_ID", nullable = false)
    private Integer clientSupplierId;

    @Column(name = "TIMESTAMP")
    private Date timestamp;

    @Column(name = "CREATED_BY")
    private Integer createdBy;

    @Column(name = "MANAGER_APPROVAL_STATUS")
    private Boolean managerApprovalStatus;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "PO_MM")
    private Integer poMm;

    @Column(name = "description")
    private String description;
}
