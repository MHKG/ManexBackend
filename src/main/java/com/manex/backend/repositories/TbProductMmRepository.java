package com.manex.backend.repositories;

import com.manex.backend.entities.TbProductMm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbProductMmRepository
        extends JpaRepository<TbProductMm, Integer>, JpaSpecificationExecutor<TbProductMm> {}
