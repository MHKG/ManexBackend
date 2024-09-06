package com.manex.backend.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "tb_customer_pi")
public class TbCustomerPi {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "CUST_QUOT_ID", nullable = false)
    private Integer custQuotId;

    @Column(name = "CUST_PI_NUM")
    private String custPiNum;

    @Column(name = "UPDATED_BY")
    private Integer updatedBy;

    @Column(name = "PI_MM")
    private Integer piMm;

    @Column(name = "CREATED_ON")
    private Date createdOn;

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

    public Integer getCustQuotId() {
        return custQuotId;
    }

    public void setCustQuotId(Integer custQuotId) {
        this.custQuotId = custQuotId;
    }

    public String getCustPiNum() {
        return custPiNum;
    }

    public void setCustPiNum(String custPiNum) {
        this.custPiNum = custPiNum;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Integer getPiMm() {
        return piMm;
    }

    public void setPiMm(Integer piMm) {
        this.piMm = piMm;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
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
