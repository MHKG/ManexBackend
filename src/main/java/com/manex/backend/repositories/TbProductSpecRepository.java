package com.manex.backend.repositories;

import com.manex.backend.entities.TbProductSpec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbProductSpecRepository
        extends JpaRepository<TbProductSpec, Void>, JpaSpecificationExecutor<TbProductSpec> {}
