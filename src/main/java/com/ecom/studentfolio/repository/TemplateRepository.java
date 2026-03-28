package com.ecom.studentfolio.repository;

import com.ecom.studentfolio.entities.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TemplateRepository extends JpaRepository<Template, Long> {
    List<Template> findByIsActiveTrue();
}