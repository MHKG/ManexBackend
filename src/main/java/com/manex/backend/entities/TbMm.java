package com.manex.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_mm")
public class TbMm implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "mm_title")
    private String mmTitle;

    @Column(name = "mm_file_name", nullable = false)
    private String mmFileName;

    @Column(name = "mm_type")
    private String mmType;

    @Column(name = "MM_SIZE")
    private Integer mmSize;

    @Column(name = "STATUS")
    private Boolean status;

    @Column(name = "description")
    private String description;
}
