package com.ecom.studentfolio.repository;

import com.ecom.studentfolio.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByProfileId(Long profileId);
}