package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_product_spec")
public class TbProductSpec {

    @Id
    @Column(name = "PRODUCT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(name = "COLOUR")
    private String colour;

    @Column(name = "MATERIAL")
    private String material;

    @Column(name = "PACKING")
    private String packing;

    @Column(name = "PRICE")
    private Float price;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getPacking() {
        return packing;
    }

    public void setPacking(String packing) {
        this.packing = packing;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
