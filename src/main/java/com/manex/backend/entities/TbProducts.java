package com.manex.backend.entities;

import com.manex.backend.enums.SizeUnit;
import com.manex.backend.enums.VolumeUnit;
import com.manex.backend.enums.WeightUnit;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_products")
public class TbProducts {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private Integer CLIENT_SUPPLIER_ID;

    @Column(nullable = false)
    private String DESCRIPTION;

    @Column private Float LENGTH;

    @Column private Float WIDTH;

    @Column private Float HEIGHT;

    @Column
    @Enumerated(EnumType.STRING)
    private SizeUnit SIZE_UNIT;

    @Column private Float WEIGHT;

    @Column
    @Enumerated(EnumType.STRING)
    private WeightUnit WEIGHT_UNIT;

    @Column private Float VOLUME;

    @Column
    @Enumerated(EnumType.STRING)
    private VolumeUnit VOLUME_UNIT;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getCLIENT_SUPPLIER_ID() {
        return CLIENT_SUPPLIER_ID;
    }

    public void setCLIENT_SUPPLIER_ID(Integer CLIENT_SUPPLIER_ID) {
        this.CLIENT_SUPPLIER_ID = CLIENT_SUPPLIER_ID;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
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

    public Float getWEIGHT() {
        return WEIGHT;
    }

    public void setWEIGHT(Float WEIGHT) {
        this.WEIGHT = WEIGHT;
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
}
