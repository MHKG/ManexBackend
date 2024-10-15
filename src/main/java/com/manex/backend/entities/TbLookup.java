package com.manex.backend.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_lookup")
public class TbLookup {

    @Id
    @Column(nullable = false, columnDefinition = "smallint unsigned")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer LOOKUP_ID;

    @Column(nullable = false)
    private String CATEGORY;

    @Column(nullable = false)
    private String FIELD_NAME;

    @Column private Boolean STATUS;

    @Column private String ADDL_INFO;
}
