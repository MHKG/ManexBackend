package com.manex.backend.repositories;

import com.manex.backend.entities.TbProductMm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TbProductMmRepository
        extends JpaRepository<TbProductMm, Integer>, JpaSpecificationExecutor<TbProductMm> {

    @Query("SELECT tpm FROM TbProductMm tpm WHERE tpm.PRODUCT_ID = :id")
    List<TbProductMm> findAllByProductId(Integer id);

    @Query("SELECT tpm FROM TbProductMm tpm WHERE tpm.MM_FILE = :MM_FILE")
    TbProductMm findByMmFile(Integer MM_FILE);

    @Query(
            "SELECT tpm FROM TbProductMm tpm WHERE tpm.PRODUCT_ID = :PRODUCT_ID and DEFAULT_MM = 'Y'")
    TbProductMm findDefaultByProductId(Integer PRODUCT_ID);
}
