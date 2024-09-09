package com.manex.backend.entities;

import com.manex.backend.enums.MultiMediaTypes;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_mm")
public class TbMm {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column private String MM_TITLE;

    @Column(nullable = false)
    private String MM_FILE_NAME;

    @Column
    @Enumerated(EnumType.STRING)
    private MultiMediaTypes MM_TYPE;

    @Column private Integer MM_SIZE;

    @Column private Boolean STATUS;

    @Column private String DESCRIPTION;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getMM_TITLE() {
        return MM_TITLE;
    }

    public void setMM_TITLE(String MM_TITLE) {
        this.MM_TITLE = MM_TITLE;
    }

    public String getMM_FILE_NAME() {
        return MM_FILE_NAME;
    }

    public void setMM_FILE_NAME(String MM_FILE_NAME) {
        this.MM_FILE_NAME = MM_FILE_NAME;
    }

    public MultiMediaTypes getMM_TYPE() {
        return MM_TYPE;
    }

    public void setMM_TYPE(MultiMediaTypes MM_TYPE) {
        this.MM_TYPE = MM_TYPE;
    }

    public Integer getMM_SIZE() {
        return MM_SIZE;
    }

    public void setMM_SIZE(Integer MM_SIZE) {
        this.MM_SIZE = MM_SIZE;
    }

    public Boolean getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(Boolean STATUS) {
        this.STATUS = STATUS;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }
}
