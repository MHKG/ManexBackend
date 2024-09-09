package com.manex.backend.entities;

import com.manex.backend.enums.SizeUnit;
import com.manex.backend.enums.VolumeUnit;
import com.manex.backend.enums.WeightUnit;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_ctn")
public class TbCtn {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private Integer APP_CLIENT_ID;

    @Column(nullable = false)
    private String ALIAS_NAME;

    @Column private Float LENGTH;

    @Column private Float WIDTH;

    @Column private Float HEIGHT;

    @Column
    @Enumerated(EnumType.STRING)
    private SizeUnit SIZE_UNIT;

    @Column private Float VOLUME;

    @Column
    @Enumerated(EnumType.STRING)
    private VolumeUnit VOLUME_UNIT;

    @Column private Float MAX_WEIGHT_CAPACITY;

    @Column
    @Enumerated(EnumType.STRING)
    private WeightUnit MAX_WEIGHT_CAPACITY_UNIT;

    @Column private Integer CTN_ICON;

    @Column private String DESCRIPTION;

    @Column private Boolean STATUS;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getAPP_CLIENT_ID() {
        return APP_CLIENT_ID;
    }

    public void setAPP_CLIENT_ID(Integer APP_CLIENT_ID) {
        this.APP_CLIENT_ID = APP_CLIENT_ID;
    }

    public String getALIAS_NAME() {
        return ALIAS_NAME;
    }

    public void setALIAS_NAME(String ALIAS_NAME) {
        this.ALIAS_NAME = ALIAS_NAME;
    }

    public Float getLENGTH() {
        return LENGTH;
    }

    public void setLENGTH(Float LENGTH) {
        this.LENGTH = LENGTH;
    }

    public Float getWIDTH() {
        return WIDTH;
    }

    public void setWIDTH(Float WIDTH) {
        this.WIDTH = WIDTH;
    }

    public Float getHEIGHT() {
        return HEIGHT;
    }

    public void setHEIGHT(Float HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public SizeUnit getSIZE_UNIT() {
        return SIZE_UNIT;
    }

    public void setSIZE_UNIT(SizeUnit SIZE_UNIT) {
        this.SIZE_UNIT = SIZE_UNIT;
    }

    public Float getVOLUME() {
        return VOLUME;
    }

    public void setVOLUME(Float VOLUME) {
        this.VOLUME = VOLUME;
    }

    public VolumeUnit getVOLUME_UNIT() {
        return VOLUME_UNIT;
    }

    public void setVOLUME_UNIT(VolumeUnit VOLUME_UNIT) {
        this.VOLUME_UNIT = VOLUME_UNIT;
    }

    public Float getMAX_WEIGHT_CAPACITY() {
        return MAX_WEIGHT_CAPACITY;
    }

    public void setMAX_WEIGHT_CAPACITY(Float MAX_WEIGHT_CAPACITY) {
        this.MAX_WEIGHT_CAPACITY = MAX_WEIGHT_CAPACITY;
    }

    public WeightUnit getMAX_WEIGHT_CAPACITY_UNIT() {
        return MAX_WEIGHT_CAPACITY_UNIT;
    }

    public void setMAX_WEIGHT_CAPACITY_UNIT(WeightUnit MAX_WEIGHT_CAPACITY_UNIT) {
        this.MAX_WEIGHT_CAPACITY_UNIT = MAX_WEIGHT_CAPACITY_UNIT;
    }

    public Integer getCTN_ICON() {
        return CTN_ICON;
    }

    public void setCTN_ICON(Integer CTN_ICON) {
        this.CTN_ICON = CTN_ICON;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public Boolean getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(Boolean STATUS) {
        this.STATUS = STATUS;
    }
}
