package com.manex.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_customer_po")
public class TbCustomerPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cust_po_num")
    private String custPoNum;

    @Column(name = "APP_CLIENT_ID", nullable = false)
    private Integer appClientId;

    @Column(name = "CLIENT_CUST_ID", nullable = false)
    private Integer clientCustId;

    @Column(name = "CREATED_ON")
    private Integer createdOn;

    @Column(name = "CREATED_BY")
    private Integer createdBy;

    @Column(name = "MANAGER_APPROVAL_STATUS")
    private Boolean managerApprovalStatus;

    @Column(name = "PO_MM")
    private Integer poMm;

    @Column(name = "description")
    private String description;

    @Column(name = "STATUS")
    private Boolean status;
}
