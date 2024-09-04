package com.manex.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_lookup")
public class TbLookup implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "lookup_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer lookupId;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "field_name", nullable = false)
    private String fieldName;

    @Column(name = "STATUS")
    private Boolean status;

    @Column(name = "addl_info")
    private String addlInfo;
}
