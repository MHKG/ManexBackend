package com.manex.backend.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_supplier_po")
public class TbSupplierPo {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "PO_NUM", nullable = false)
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

    @Column(name = "DESCRIPTION")
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPoNum() {
        return poNum;
    }

    public void setPoNum(String poNum) {
        this.poNum = poNum;
    }

    public Integer getAppClientId() {
        return appClientId;
    }

    public void setAppClientId(Integer appClientId) {
        this.appClientId = appClientId;
    }

    public Integer getClientSupplierId() {
        return clientSupplierId;
    }

    public void setClientSupplierId(Integer clientSupplierId) {
        this.clientSupplierId = clientSupplierId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
}
