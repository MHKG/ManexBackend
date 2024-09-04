package com.manex.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_m_item_ctn")
public class TbMItemCtn implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId private TbCompanyProductNumberId id;

    @Column(name = "QTY_PER_CTN")
    private Integer qtyPerCtn;

    @Column(name = "pkg_type")
    private String pkgType;

    @Column(name = "NET_WT")
    private Float netWt;

    @Column(name = "GROSS_WT")
    private Float grossWt;

    @Column(name = "weight_unit")
    private String weightUnit;
}
