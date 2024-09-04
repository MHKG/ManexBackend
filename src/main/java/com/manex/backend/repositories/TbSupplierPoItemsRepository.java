package com.manex.backend.repositories;

import com.manex.backend.entities.TbSupplierPoItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbSupplierPoItemsRepository
        extends JpaRepository<TbSupplierPoItems, Integer>,
                JpaSpecificationExecutor<TbSupplierPoItems> {}
