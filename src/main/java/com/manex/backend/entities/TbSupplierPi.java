package com.manex.backend.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_supplier_pi")
public class TbSupplierPi {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private Integer SUPP_QUOT_ID;

    @Column private String SUPP_PI_NUM;

    @Column private Integer PI_MM;

    @Column private Integer UPDATED_BY;

    @Column private Date TIMESTAMP;

    @Column private Integer STATUS;

    @Column private String REMARK;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getSUPP_QUOT_ID() {
        return SUPP_QUOT_ID;
    }

    public void setSUPP_QUOT_ID(Integer SUPP_QUOT_ID) {
        this.SUPP_QUOT_ID = SUPP_QUOT_ID;
    }

    public String getSUPP_PI_NUM() {
        return SUPP_PI_NUM;
    }

    public void setSUPP_PI_NUM(String SUPP_PI_NUM) {
        this.SUPP_PI_NUM = SUPP_PI_NUM;
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

    public Date getTIMESTAMP() {
        return TIMESTAMP;
    }

    public void setTIMESTAMP(Date TIMESTAMP) {
        this.TIMESTAMP = TIMESTAMP;
    }

    public Integer getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(Integer STATUS) {
        this.STATUS = STATUS;
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK;
    }
}
