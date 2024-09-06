package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_m_client_supplier_item")
public class TbMClientSupplierItem {

    @EmbeddedId private TbMClientSupplierItemId id;

    @Column(name = "IS_PROD_FAV")
    private Character prodFav;

    @Column(name = "STATUS")
    private Integer status;

    public TbMClientSupplierItemId getId() {
        return id;
    }

    public void setId(TbMClientSupplierItemId id) {
        this.id = id;
    }

    public Character getProdFav() {
        return prodFav;
    }

    public void setProdFav(Character prodFav) {
        this.prodFav = prodFav;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
