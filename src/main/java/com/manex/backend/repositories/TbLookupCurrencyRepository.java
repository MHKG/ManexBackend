package com.manex.backend.repositories;

import com.manex.backend.entities.TbLookupCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbLookupCurrencyRepository
        extends JpaRepository<TbLookupCurrency, Integer>,
                JpaSpecificationExecutor<TbLookupCurrency> {}
