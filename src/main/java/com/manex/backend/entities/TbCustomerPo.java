package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_customer_po")
public class TbCustomerPo {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "CUST_PO_NUM")
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

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "STATUS")
    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustPoNum() {
        return custPoNum;
    }

    public void setCustPoNum(String custPoNum) {
        this.custPoNum = custPoNum;
    }

    public Integer getAppClientId() {
        return appClientId;
    }

    public void setAppClientId(Integer appClientId) {
        this.appClientId = appClientId;
    }

    public Integer getClientCustId() {
        return clientCustId;
    }

    public void setClientCustId(Integer clientCustId) {
        this.clientCustId = clientCustId;
    }

    public Integer getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Integer createdOn) {
        this.createdOn = createdOn;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public void setManagerApprovalStatus(Boolean managerApprovalStatus) {
        this.managerApprovalStatus = managerApprovalStatus;
    }

    public Boolean isManagerApprovalStatus() {
        return managerApprovalStatus;
    }

    public Integer getPoMm() {
        return poMm;
    }

    public void setPoMm(Integer poMm) {
        this.poMm = poMm;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean isStatus() {
        return status;
    }
}
