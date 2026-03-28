package com.ecom.studentfolio.repository;

import com.ecom.studentfolio.entities.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    Optional<Portfolio> findByPersonneId(Long personneId);
    Optional<Portfolio> findByPublicUrl(String publicUrl);
}