package com.manex.backend.entities;

import com.manex.backend.enums.SizeUnit;
import com.manex.backend.enums.VolumeUnit;
import com.manex.backend.enums.WeightUnit;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_ctn")
public class TbCtn {

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

    @Column(name = "VOLUME")
    private Float volume;

    @Column(name = "VOLUME_UNIT")
    @Enumerated(EnumType.STRING)
    private VolumeUnit volumeUnit;

    @Column(name = "MAX_WEIGHT_CAPACITY")
    private Float maxWeightCapacity;

    @Column(name = "MAX_WEIGHT_CAPACITY_UNIT")
    @Enumerated(EnumType.STRING)
    private WeightUnit maxWeightCapacityUnit;

    @Column(name = "CTN_ICON")
    private Integer ctnIcon;

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

    public Float getMaxWeightCapacity() {
        return maxWeightCapacity;
    }

    public void setMaxWeightCapacity(Float maxWeightCapacity) {
        this.maxWeightCapacity = maxWeightCapacity;
    }

    public WeightUnit getMaxWeightCapacityUnit() {
        return maxWeightCapacityUnit;
    }

    public void setMaxWeightCapacityUnit(WeightUnit maxWeightCapacityUnit) {
        this.maxWeightCapacityUnit = maxWeightCapacityUnit;
    }

    public Integer getCtnIcon() {
        return ctnIcon;
    }

    public void setCtnIcon(Integer ctnIcon) {
        this.ctnIcon = ctnIcon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean isStatus() {
        return status;
    }
}
