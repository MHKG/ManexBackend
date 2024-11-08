package com.manex.backend.repositories;

import com.manex.backend.entities.TbSystemSettings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbSystemSettingsRepository
        extends JpaRepository<TbSystemSettings, Integer>,
                JpaSpecificationExecutor<TbSystemSettings> {}
