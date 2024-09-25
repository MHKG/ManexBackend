package com.manex.backend.repositories;

import com.manex.backend.entities.TbSupplierQuotation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface TbSupplierQuotationRepository
        extends JpaRepository<TbSupplierQuotation, Integer>,
                JpaSpecificationExecutor<TbSupplierQuotation> {

    @Query(
            "SELECT tsq FROM TbSupplierQuotation tsq WHERE tsq.SUPP_PO_ID = :SUPP_PO_ID ORDER BY tsq.TIMESTAMP desc LIMIT 1")
    TbSupplierQuotation findLatestBySuppPoId(Integer SUPP_PO_ID);
}
