package com.manex.backend.repositories;

import com.manex.backend.entities.TbCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbCountryRepository
        extends JpaRepository<TbCountry, Integer>, JpaSpecificationExecutor<TbCountry> {}
