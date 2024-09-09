package com.manex.backend.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_supplier_quotation")
public class TbSupplierQuotation {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private Integer SUPP_PO_ID;

    @Column private String SUPPLIER_QUOT_NUM;

    @Column private Integer QUOTATION_MM;

    @Column private Date TIMESTAMP;

    @Column private Integer UPDATED_BY;

    @Column private Integer STATUS;

    @Column private String DESCRIPTION;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getSUPP_PO_ID() {
        return SUPP_PO_ID;
    }

    public void setSUPP_PO_ID(Integer SUPP_PO_ID) {
        this.SUPP_PO_ID = SUPP_PO_ID;
    }

    public String getSUPPLIER_QUOT_NUM() {
        return SUPPLIER_QUOT_NUM;
    }

    public void setSUPPLIER_QUOT_NUM(String SUPPLIER_QUOT_NUM) {
        this.SUPPLIER_QUOT_NUM = SUPPLIER_QUOT_NUM;
    }

    public Integer getQUOTATION_MM() {
        return QUOTATION_MM;
    }

    public void setQUOTATION_MM(Integer QUOTATION_MM) {
        this.QUOTATION_MM = QUOTATION_MM;
    }

    public Date getTIMESTAMP() {
        return TIMESTAMP;
    }

    public void setTIMESTAMP(Date TIMESTAMP) {
        this.TIMESTAMP = TIMESTAMP;
    }

    public Integer getUPDATED_BY() {
        return UPDATED_BY;
    }

    public void setUPDATED_BY(Integer UPDATED_BY) {
        this.UPDATED_BY = UPDATED_BY;
    }

    public Integer getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(Integer STATUS) {
        this.STATUS = STATUS;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }
}
