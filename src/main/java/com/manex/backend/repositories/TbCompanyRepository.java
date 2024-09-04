package com.manex.backend.repositories;

import com.manex.backend.entities.TbCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbCompanyRepository
        extends JpaRepository<TbCompany, Integer>, JpaSpecificationExecutor<TbCompany> {}
