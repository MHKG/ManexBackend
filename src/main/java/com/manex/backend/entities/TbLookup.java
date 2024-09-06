package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_lookup")
public class TbLookup {

    @Id
    @Column(name = "LOOKUP_ID", nullable = false, columnDefinition = "smallint unsigned")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer lookupId;

    @Column(name = "CATEGORY", nullable = false)
    private String category;

    @Column(name = "FIELD_NAME", nullable = false)
    private String fieldName;

    @Column(name = "STATUS")
    private Boolean status;

    @Column(name = "ADDL_INFO")
    private String addlInfo;

    public Integer getLookupId() {
        return lookupId;
    }

    public void setLookupId(Integer lookupId) {
        this.lookupId = lookupId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean isStatus() {
        return status;
    }

    public String getAddlInfo() {
        return addlInfo;
    }

    public void setAddlInfo(String addlInfo) {
        this.addlInfo = addlInfo;
    }
}
