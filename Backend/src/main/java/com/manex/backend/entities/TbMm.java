package com.manex.backend.entities;

import com.manex.backend.enums.MultiMediaTypes;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_mm")
public class TbMm {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column private String MM_TITLE;

    @Column(nullable = false)
    private String MM_FILE_NAME;

    @Column
    @Enumerated(EnumType.STRING)
    private MultiMediaTypes MM_TYPE;

    @Column private Integer MM_SIZE;

    @Column private Boolean STATUS;

    @Column private String DESCRIPTION;
}
