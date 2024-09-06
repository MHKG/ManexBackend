package com.manex.backend.repositories;

import com.manex.backend.entities.TbCompanyProductNumber;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbCompanyProductNumberRepository
        extends JpaRepository<TbCompanyProductNumber, Integer>,
                JpaSpecificationExecutor<TbCompanyProductNumber> {}
