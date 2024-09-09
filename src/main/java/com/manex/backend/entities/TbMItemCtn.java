package com.manex.backend.entities;

import com.manex.backend.enums.WeightUnit;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_m_item_ctn")
public class TbMItemCtn {

    @EmbeddedId private TbMItemCtnId ID;

    @Column private Integer QTY_PER_CTN;

    @Column private String PKG_TYPE;

    @Column private Float NET_WT;

    @Column private Float GROSS_WT;

    @Column
    @Enumerated(EnumType.STRING)
    private WeightUnit WEIGHT_UNIT;

    public TbMItemCtnId getID() {
        return ID;
    }

    public void setID(TbMItemCtnId ID) {
        this.ID = ID;
    }

    public Integer getQTY_PER_CTN() {
        return QTY_PER_CTN;
    }

    public void setQTY_PER_CTN(Integer QTY_PER_CTN) {
        this.QTY_PER_CTN = QTY_PER_CTN;
    }

    public String getPKG_TYPE() {
        return PKG_TYPE;
    }

    public void setPKG_TYPE(String PKG_TYPE) {
        this.PKG_TYPE = PKG_TYPE;
    }

    public Float getNET_WT() {
        return NET_WT;
    }

    public void setNET_WT(Float NET_WT) {
        this.NET_WT = NET_WT;
    }

    public Float getGROSS_WT() {
        return GROSS_WT;
    }

    public void setGROSS_WT(Float GROSS_WT) {
        this.GROSS_WT = GROSS_WT;
    }

    public WeightUnit getWEIGHT_UNIT() {
        return WEIGHT_UNIT;
    }

    public void setWEIGHT_UNIT(WeightUnit WEIGHT_UNIT) {
        this.WEIGHT_UNIT = WEIGHT_UNIT;
    }
}
