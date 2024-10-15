package com.manex.backend.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_m_client_supplier_item")
public class TbMClientSupplierItem {

    @EmbeddedId private TbMClientSupplierItemId ID;

    @Column private Character IS_PROD_FAV;

    @Column private Integer STATUS;
}
