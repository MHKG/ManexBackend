package com.manex.backend.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_supplier_pi")
public class TbSupplierPi {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "SUPP_QUOT_ID", nullable = false)
    private Integer suppQuotId;

    @Column(name = "SUPP_PI_NUM")
    private String suppPiNum;

    @Column(name = "PI_MM")
    private Integer piMm;

    @Column(name = "UPDATED_BY")
    private Integer updatedBy;

    @Column(name = "TIMESTAMP")
    private Date timestamp;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "REMARK")
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSuppQuotId() {
        return suppQuotId;
    }

    public void setSuppQuotId(Integer suppQuotId) {
        this.suppQuotId = suppQuotId;
    }

    public String getSuppPiNum() {
        return suppPiNum;
    }

    public void setSuppPiNum(String suppPiNum) {
        this.suppPiNum = suppPiNum;
    }

    public Integer getPiMm() {
        return piMm;
    }

    public void setPiMm(Integer piMm) {
        this.piMm = piMm;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
