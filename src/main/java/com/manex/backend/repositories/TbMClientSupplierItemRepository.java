package com.manex.backend.repositories;

import com.manex.backend.entities.TbMClientSupplierItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbMClientSupplierItemRepository
        extends JpaRepository<TbMClientSupplierItem, Integer>,
                JpaSpecificationExecutor<TbMClientSupplierItem> {}
