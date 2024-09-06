package com.manex.backend.entities;

import com.manex.backend.enums.SizeUnit;
import com.manex.backend.enums.VolumeUnit;
import com.manex.backend.enums.WeightUnit;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_products")
public class TbProducts {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "CLIENT_SUPPLIER_ID", nullable = false)
    private Integer clientSupplierId;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "LENGTH")
    private Float length;

    @Column(name = "WIDTH")
    private Float width;

    @Column(name = "HEIGHT")
    private Float height;

    @Column(name = "SIZE_UNIT")
    @Enumerated(EnumType.STRING)
    private SizeUnit sizeUnit;

    @Column(name = "WEIGHT")
    private Float weight;

    @Column(name = "WEIGHT_UNIT")
    @Enumerated(EnumType.STRING)
    private WeightUnit weightUnit;

    @Column(name = "VOLUME")
    private Float volume;

    @Column(name = "VOLUME_UNIT")
    @Enumerated(EnumType.STRING)
    private VolumeUnit volumeUnit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientSupplierId() {
        return clientSupplierId;
    }

    public void setClientSupplierId(Integer clientSupplierId) {
        this.clientSupplierId = clientSupplierId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
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
}
