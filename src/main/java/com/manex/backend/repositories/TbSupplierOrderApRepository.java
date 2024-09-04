package com.manex.backend.repositories;

import com.manex.backend.entities.TbSupplierOrderAp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbSupplierOrderApRepository
        extends JpaRepository<TbSupplierOrderAp, Integer>,
                JpaSpecificationExecutor<TbSupplierOrderAp> {}
