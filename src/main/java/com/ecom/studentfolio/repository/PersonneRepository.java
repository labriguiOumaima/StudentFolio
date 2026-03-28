package com.ecom.studentfolio.repository;

import com.ecom.studentfolio.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
    Optional<Personne> findByEmail(String email);
}