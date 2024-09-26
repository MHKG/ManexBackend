package com.manex.backend.repositories;

import com.manex.backend.entities.TbSupplierOrderAp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface TbSupplierOrderApRepository
        extends JpaRepository<TbSupplierOrderAp, Integer>,
                JpaSpecificationExecutor<TbSupplierOrderAp> {

    @Query(
            "SELECT tsoa FROM TbSupplierOrderAp tsoa WHERE tsoa.SUPPLIER_INVOICE_ID = :SUPPLIER_INVOICE_ID")
    TbSupplierOrderAp findBySupplierInvoiceId(Integer SUPPLIER_INVOICE_ID);
}
