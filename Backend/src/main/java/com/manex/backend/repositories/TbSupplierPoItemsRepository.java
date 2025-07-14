package com.manex.backend.repositories;

import com.manex.backend.entities.TbSupplierPoItems;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TbSupplierPoItemsRepository
        extends JpaRepository<TbSupplierPoItems, Integer>,
                JpaSpecificationExecutor<TbSupplierPoItems> {

    @Query("SELECT tspi FROM TbSupplierPoItems tspi WHERE tspi.SUPPLIER_PO_ID = :SUPPLIER_PO_ID")
    List<TbSupplierPoItems> findAllBySupplierPoId(Integer SUPPLIER_PO_ID);
}
