package com.manex.backend.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tb_supplier_pi")
public class TbSupplierPi {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private Integer SUPP_QUOT_ID;

    @Column private String SUPP_PI_NUM;

    @Column private Integer PI_MM;

    @Column private Integer UPDATED_BY;

    @Column private Date TIMESTAMP;

    @Column private Integer STATUS;

    @Column private String REMARK;
}
