package com.manex.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_container")
public class TbContainer implements Serializable {

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

    @Column(name = "TARE_WT")
    private Integer tareWt;

    @Column(name = "MAX_WEIGHT")
    private Float maxWeight;

    @Column(name = "weight_unit")
    private String weightUnit;

    @Column(name = "VOLUME")
    private Float volume;

    @Column(name = "volume_unit")
    private String volumeUnit;

    @Column(name = "CONTAINER_ICON")
    private Integer containerIcon;

    @Column(name = "description")
    private String description;

    @Column(name = "STATUS")
    private Boolean status;
}
