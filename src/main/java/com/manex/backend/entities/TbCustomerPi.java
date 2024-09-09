package com.manex.backend.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "tb_customer_pi")
public class TbCustomerPi {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private Integer CUST_QUOT_ID;

    @Column private String CUST_PI_NUM;

    @Column private Integer UPDATED_BY;

    @Column private Integer PI_MM;

    @Column private Date CREATED_ON;

    @Column private Integer STATUS;

    @Column private String REMARK;

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK;
    }

    public Integer getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(Integer STATUS) {
        this.STATUS = STATUS;
    }

    public Date getCREATED_ON() {
        return CREATED_ON;
    }

    public void setCREATED_ON(Date CREATED_ON) {
        this.CREATED_ON = CREATED_ON;
    }

    public Integer getPI_MM() {
        return PI_MM;
    }

    public void setPI_MM(Integer PI_MM) {
        this.PI_MM = PI_MM;
    }

    public Integer getUPDATED_BY() {
        return UPDATED_BY;
    }

    public void setUPDATED_BY(Integer UPDATED_BY) {
        this.UPDATED_BY = UPDATED_BY;
    }

    public String getCUST_PI_NUM() {
        return CUST_PI_NUM;
    }

    public void setCUST_PI_NUM(String CUST_PI_NUM) {
        this.CUST_PI_NUM = CUST_PI_NUM;
    }

    public Integer getCUST_QUOT_ID() {
        return CUST_QUOT_ID;
    }

    public void setCUST_QUOT_ID(Integer CUST_QUOT_ID) {
        this.CUST_QUOT_ID = CUST_QUOT_ID;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
}
