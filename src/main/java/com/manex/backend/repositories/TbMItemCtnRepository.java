package com.manex.backend.repositories;

import com.manex.backend.entities.TbMItemCtn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbMItemCtnRepository
        extends JpaRepository<TbMItemCtn, Integer>, JpaSpecificationExecutor<TbMItemCtn> {}
