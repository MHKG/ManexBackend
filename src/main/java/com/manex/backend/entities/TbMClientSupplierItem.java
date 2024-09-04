package com.manex.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_m_client_supplier_item")
public class TbMClientSupplierItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId private TbMClientSupplierItemId id;

    @Column(name = "is_prod_fav")
    private Boolean prodFav;

    @Column(name = "STATUS")
    private Integer status;
}
