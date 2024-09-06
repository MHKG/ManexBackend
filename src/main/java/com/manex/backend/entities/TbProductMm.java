package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_product_mm")
public class TbProductMm {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "PRODUCT_ID", nullable = false)
    private Integer productId;

    @Column(name = "MM_FILE", nullable = false)
    private Integer mmFile;

    @Column(name = "DEFAULT_MM")
    private Character defaultMm;

    @Column(name = "STATUS")
    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getMmFile() {
        return mmFile;
    }

    public void setMmFile(Integer mmFile) {
        this.mmFile = mmFile;
    }

    public Character getDefaultMm() {
        return defaultMm;
    }

    public void setDefaultMm(Character defaultMm) {
        this.defaultMm = defaultMm;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean isStatus() {
        return status;
    }
}
