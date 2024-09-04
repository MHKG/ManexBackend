package com.manex.backend.repositories;

import com.manex.backend.entities.TbProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbProductsRepository
        extends JpaRepository<TbProducts, Integer>, JpaSpecificationExecutor<TbProducts> {}
