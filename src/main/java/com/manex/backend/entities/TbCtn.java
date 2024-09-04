package com.manex.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_ctn")
public class TbCtn implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "APP_CLIENT_ID", nullable = false)
    private Integer appClientId;

    @Column(name = "alias_name", nullable = false)
    private String aliasName;

    @Column(name = "LENGTH")
    private Float length;

    @Column(name = "WIDTH")
    private Float width;

    @Column(name = "HEIGHT")
    private Float height;

    @Column(name = "size_unit")
    private String sizeUnit;

    @Column(name = "VOLUME")
    private Float volume;

    @Column(name = "volume_unit")
    private String volumeUnit;

    @Column(name = "MAX_WEIGHT_CAPACITY")
    private Float maxWeightCapacity;

    @Column(name = "max_weight_capacity_unit")
    private String maxWeightCapacityUnit;

    @Column(name = "CTN_ICON")
    private Integer ctnIcon;

    @Column(name = "description")
    private String description;

    @Column(name = "STATUS")
    private Boolean status;
}
