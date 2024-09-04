package com.manex.backend.repositories;

import com.manex.backend.entities.TbClientSupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbClientSupplierRepository
        extends JpaRepository<TbClientSupplier, Integer>,
                JpaSpecificationExecutor<TbClientSupplier> {}
