package com.manex.backend.repositories;

import com.manex.backend.entities.TbCustPoItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbCustPoItemsRepository
        extends JpaRepository<TbCustPoItems, Integer>, JpaSpecificationExecutor<TbCustPoItems> {}
