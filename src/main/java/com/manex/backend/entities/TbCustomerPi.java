package com.manex.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_customer_pi")
public class TbCustomerPi implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "CUST_QUOT_ID", nullable = false)
    private Integer custQuotId;

    @Column(name = "cust_pi_num")
    private String custPiNum;

    @Column(name = "UPDATED_BY")
    private Integer updatedBy;

    @Column(name = "PI_MM")
    private Integer piMm;

    @Column(name = "CREATED_ON")
    private Integer createdOn;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "remark")
    private String remark;
}
