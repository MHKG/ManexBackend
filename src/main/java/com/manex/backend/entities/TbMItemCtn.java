package com.manex.backend.entities;

import com.manex.backend.enums.WeightUnit;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_m_item_ctn")
public class TbMItemCtn {

    @EmbeddedId private TbMItemCtnId id;

    @Column(name = "QTY_PER_CTN")
    private Integer qtyPerCtn;

    @Column(name = "PKG_TYPE")
    private String pkgType;

    @Column(name = "NET_WT")
    private Float netWt;

    @Column(name = "GROSS_WT")
    private Float grossWt;

    @Column(name = "WEIGHT_UNIT")
    @Enumerated(EnumType.STRING)
    private WeightUnit weightUnit;

    public TbMItemCtnId getId() {
        return id;
    }

    public void setId(TbMItemCtnId id) {
        this.id = id;
    }

    public Integer getQtyPerCtn() {
        return qtyPerCtn;
    }

    public void setQtyPerCtn(Integer qtyPerCtn) {
        this.qtyPerCtn = qtyPerCtn;
    }

    public String getPkgType() {
        return pkgType;
    }

    public void setPkgType(String pkgType) {
        this.pkgType = pkgType;
    }

    public Float getNetWt() {
        return netWt;
    }

    public void setNetWt(Float netWt) {
        this.netWt = netWt;
    }

    public Float getGrossWt() {
        return grossWt;
    }

    public void setGrossWt(Float grossWt) {
        this.grossWt = grossWt;
    }

    public WeightUnit getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(WeightUnit weightUnit) {
        this.weightUnit = weightUnit;
    }
}
