package com.manex.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_supplier_pi")
public class TbSupplierPi implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "SUPP_QUOT_ID", nullable = false)
    private Integer suppQuotId;

    @Column(name = "supp_pi_num")
    private String suppPiNum;

    @Column(name = "PI_MM")
    private Integer piMm;

    @Column(name = "UPDATED_BY")
    private Integer updatedBy;

    @Column(name = "TIMESTAMP")
    private Date timestamp;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "remark")
    private String remark;
}
