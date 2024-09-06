package com.manex.backend.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_supplier_quotation")
public class TbSupplierQuotation {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "SUPP_PO_ID", nullable = false)
    private Integer suppPoId;

    @Column(name = "SUPPLIER_QUOT_NUM")
    private String supplierQuotNum;

    @Column(name = "QUOTATION_MM")
    private Integer quotationMm;

    @Column(name = "TIMESTAMP")
    private Date timestamp;

    @Column(name = "UPDATED_BY")
    private Integer updatedBy;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "DESCRIPTION")
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSuppPoId() {
        return suppPoId;
    }

    public void setSuppPoId(Integer suppPoId) {
        this.suppPoId = suppPoId;
    }

    public String getSupplierQuotNum() {
        return supplierQuotNum;
    }

    public void setSupplierQuotNum(String supplierQuotNum) {
        this.supplierQuotNum = supplierQuotNum;
    }

    public Integer getQuotationMm() {
        return quotationMm;
    }

    public void setQuotationMm(Integer quotationMm) {
        this.quotationMm = quotationMm;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
