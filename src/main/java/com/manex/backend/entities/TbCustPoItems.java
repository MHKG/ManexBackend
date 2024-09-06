package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_cust_po_items")
public class TbCustPoItems {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "CUST_PO_ID", nullable = false)
    private Integer custPoId;

    @Column(name = "PRODUCT_ID", nullable = false)
    private Integer productId;

    @Column(name = "PRICE_PER_ITEM")
    private Float pricePerItem;

    @Column(name = "QTY")
    private Integer qty;

    @Column(name = "DESCRIPTION")
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustPoId() {
        return custPoId;
    }

    public void setCustPoId(Integer custPoId) {
        this.custPoId = custPoId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Float getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(Float pricePerItem) {
        this.pricePerItem = pricePerItem;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
