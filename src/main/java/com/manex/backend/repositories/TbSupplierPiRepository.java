package com.manex.backend.repositories;

import com.manex.backend.entities.TbSupplierPi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface TbSupplierPiRepository
        extends JpaRepository<TbSupplierPi, Integer>, JpaSpecificationExecutor<TbSupplierPi> {

    @Query(
            "SELECT tsp FROM TbSupplierPi tsp WHERE tsp.SUPP_QUOT_ID = :SUPP_QUOT_ID ORDER BY tsp.TIMESTAMP desc LIMIT 1")
    TbSupplierPi findLatestBySuppQuotId(Integer SUPP_QUOT_ID);
}
