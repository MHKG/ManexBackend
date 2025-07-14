package com.manex.backend.repositories;

import com.manex.backend.entities.TbMClientSupplierItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TbMClientSupplierItemRepository
        extends JpaRepository<TbMClientSupplierItem, Integer>,
                JpaSpecificationExecutor<TbMClientSupplierItem> {

    @Query(
            "SELECT tmcsi FROM TbMClientSupplierItem tmcsi WHERE tmcsi.ID.CLIENT_SUPP_ID = :clientSupplierId")
    List<TbMClientSupplierItem> findAllByClientSupplierId(int clientSupplierId);
}
