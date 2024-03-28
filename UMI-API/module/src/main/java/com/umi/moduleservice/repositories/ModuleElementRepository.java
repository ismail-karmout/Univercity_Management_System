package com.umi.moduleservice.repositories;

import com.umi.moduleservice.entities.Module;
import com.umi.moduleservice.entities.ModuleElement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModuleElementRepository extends JpaRepository<ModuleElement, Long> {
    List<ModuleElement> findByModule(Module module);

}
