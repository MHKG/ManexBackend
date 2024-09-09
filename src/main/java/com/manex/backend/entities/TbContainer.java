package com.manex.backend.entities;

import com.manex.backend.enums.SizeUnit;
import com.manex.backend.enums.VolumeUnit;
import com.manex.backend.enums.WeightUnit;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_container")
public class TbContainer {

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

    @Column private Integer TARE_WT;

    @Column private Float MAX_WEIGHT;

    @Column
    @Enumerated(EnumType.STRING)
    private WeightUnit WEIGHT_UNIT;

    @Column private Float VOLUME;

    @Column
    @Enumerated(EnumType.STRING)
    private VolumeUnit VOLUME_UNIT;

    @Column private Integer CONTAINER_ICON;

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

    public Integer getTARE_WT() {
        return TARE_WT;
    }

    public void setTARE_WT(Integer TARE_WT) {
        this.TARE_WT = TARE_WT;
    }

    public Float getMAX_WEIGHT() {
        return MAX_WEIGHT;
    }

    public void setMAX_WEIGHT(Float MAX_WEIGHT) {
        this.MAX_WEIGHT = MAX_WEIGHT;
    }

    public WeightUnit getWEIGHT_UNIT() {
        return WEIGHT_UNIT;
    }

    public void setWEIGHT_UNIT(WeightUnit WEIGHT_UNIT) {
        this.WEIGHT_UNIT = WEIGHT_UNIT;
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

    public Integer getCONTAINER_ICON() {
        return CONTAINER_ICON;
    }

    public void setCONTAINER_ICON(Integer CONTAINER_ICON) {
        this.CONTAINER_ICON = CONTAINER_ICON;
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
