package com.manex.backend.entities;

import com.manex.backend.enums.WeightUnit;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
