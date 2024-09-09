package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_lookup")
public class TbLookup {

    @Id
    @Column(nullable = false, columnDefinition = "smallint unsigned")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer LOOKUP_ID;

    @Column(nullable = false)
    private String CATEGORY;

    @Column(nullable = false)
    private String FIELD_NAME;

    @Column private Boolean STATUS;

    @Column private String ADDL_INFO;

    public Integer getLOOKUP_ID() {
        return LOOKUP_ID;
    }

    public void setLOOKUP_ID(Integer LOOKUP_ID) {
        this.LOOKUP_ID = LOOKUP_ID;
    }

    public String getCATEGORY() {
        return CATEGORY;
    }

    public void setCATEGORY(String CATEGORY) {
        this.CATEGORY = CATEGORY;
    }

    public String getFIELD_NAME() {
        return FIELD_NAME;
    }

    public void setFIELD_NAME(String FIELD_NAME) {
        this.FIELD_NAME = FIELD_NAME;
    }

    public Boolean getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(Boolean STATUS) {
        this.STATUS = STATUS;
    }

    public String getADDL_INFO() {
        return ADDL_INFO;
    }

    public void setADDL_INFO(String ADDL_INFO) {
        this.ADDL_INFO = ADDL_INFO;
    }
}
