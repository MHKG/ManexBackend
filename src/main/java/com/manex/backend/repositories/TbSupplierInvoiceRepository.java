package com.manex.backend.repositories;

import com.manex.backend.entities.TbSupplierInvoice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface TbSupplierInvoiceRepository
        extends JpaRepository<TbSupplierInvoice, Integer>,
                JpaSpecificationExecutor<TbSupplierInvoice> {

    @Query(
            "SELECT tsi FROM TbSupplierInvoice tsi WHERE tsi.SUPP_PI_ID = :SUPP_PI_ID ORDER BY tsi.TIMESTAMP desc LIMIT 1")
    TbSupplierInvoice findLatestBySuppPiId(Integer SUPP_PI_ID);
}
