package com.manex.backend.entities;

import com.manex.backend.enums.MultiMediaTypes;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_mm")
public class TbMm {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "MM_TITLE")
    private String mmTitle;

    @Column(name = "MM_FILE_NAME", nullable = false)
    private String mmFileName;

    @Column(name = "MM_TYPE")
    @Enumerated(EnumType.STRING)
    private MultiMediaTypes mmType;

    @Column(name = "MM_SIZE")
    private Integer mmSize;

    @Column(name = "STATUS")
    private Boolean status;

    @Column(name = "DESCRIPTION")
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMmTitle() {
        return mmTitle;
    }

    public void setMmTitle(String mmTitle) {
        this.mmTitle = mmTitle;
    }

    public String getMmFileName() {
        return mmFileName;
    }

    public void setMmFileName(String mmFileName) {
        this.mmFileName = mmFileName;
    }

    public MultiMediaTypes getMmType() {
        return mmType;
    }

    public void setMmType(MultiMediaTypes mmType) {
        this.mmType = mmType;
    }

    public Integer getMmSize() {
        return mmSize;
    }

    public void setMmSize(Integer mmSize) {
        this.mmSize = mmSize;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean isStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
