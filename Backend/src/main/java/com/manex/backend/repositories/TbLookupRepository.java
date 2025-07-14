package com.manex.backend.repositories;

import com.manex.backend.entities.TbLookup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbLookupRepository
        extends JpaRepository<TbLookup, Integer>, JpaSpecificationExecutor<TbLookup> {}
