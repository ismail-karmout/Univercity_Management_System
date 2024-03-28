package com.umi.moduleservice.repositories;

import com.umi.moduleservice.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<Module, Long> {
}
