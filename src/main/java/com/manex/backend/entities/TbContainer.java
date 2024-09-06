package com.manex.backend.entities;

import com.manex.backend.enums.SizeUnit;

import com.manex.backend.enums.VolumeUnit;
import com.manex.backend.enums.WeightUnit;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_container")
public class TbContainer {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "APP_CLIENT_ID", nullable = false)
    private Integer appClientId;

    @Column(name = "ALIAS_NAME", nullable = false)
    private String aliasName;

    @Column(name = "LENGTH")
    private Float length;

    @Column(name = "WIDTH")
    private Float width;

    @Column(name = "HEIGHT")
    private Float height;

    @Column(name = "SIZE_UNIT")
    @Enumerated(EnumType.STRING)
    private SizeUnit sizeUnit;

    @Column(name = "TARE_WT")
    private Integer tareWt;

    @Column(name = "MAX_WEIGHT")
    private Float maxWeight;

    @Column(name = "WEIGHT_UNIT")@Enumerated(EnumType.STRING)
    private WeightUnit weightUnit;

    @Column(name = "VOLUME")
    private Float volume;

    @Column(name = "VOLUME_UNIT")
	@Enumerated(EnumType.STRING)
    private VolumeUnit volumeUnit;

    @Column(name = "CONTAINER_ICON")
    private Integer containerIcon;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "STATUS")
    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAppClientId() {
        return appClientId;
    }

    public void setAppClientId(Integer appClientId) {
        this.appClientId = appClientId;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public SizeUnit getSizeUnit() {
        return sizeUnit;
    }

    public void setSizeUnit(SizeUnit sizeUnit) {
        this.sizeUnit = sizeUnit;
    }

    public Integer getTareWt() {
        return tareWt;
    }

    public void setTareWt(Integer tareWt) {
        this.tareWt = tareWt;
    }

    public Float getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Float maxWeight) {
        this.maxWeight = maxWeight;
    }

    public WeightUnit getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(WeightUnit weightUnit) {
        this.weightUnit = weightUnit;
    }

    public Float getVolume() {
        return volume;
    }

    public void setVolume(Float volume) {
        this.volume = volume;
    }

    public VolumeUnit getVolumeUnit() {
        return volumeUnit;
    }

    public void setVolumeUnit(VolumeUnit volumeUnit) {
        this.volumeUnit = volumeUnit;
    }

    public Integer getContainerIcon() {
        return containerIcon;
    }

    public void setContainerIcon(Integer containerIcon) {
        this.containerIcon = containerIcon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
