package com.ecom.studentfolio.services;

import com.ecom.studentfolio.entities.Portfolio;
import com.ecom.studentfolio.repository.PortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;

    public List<Portfolio> findAll() {
        return portfolioRepository.findAll();
    }

    public Optional<Portfolio> findById(Long id) {
        return portfolioRepository.findById(id);
    }

    public Optional<Portfolio> findByPersonneId(Long personneId) {
        return portfolioRepository.findByPersonneId(personneId);
    }

    public Optional<Portfolio> findByPublicUrl(String publicUrl) {
        return portfolioRepository.findByPublicUrl(publicUrl);
    }

    public Portfolio save(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    public void deleteById(Long id) {
        portfolioRepository.deleteById(id);
    }
}