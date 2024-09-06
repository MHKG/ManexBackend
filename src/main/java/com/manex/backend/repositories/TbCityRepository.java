package com.manex.backend.repositories;

import com.manex.backend.entities.TbCity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbCityRepository
        extends JpaRepository<TbCity, Integer>, JpaSpecificationExecutor<TbCity> {}
