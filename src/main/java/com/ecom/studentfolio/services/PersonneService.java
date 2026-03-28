package com.ecom.studentfolio.services;

import com.ecom.studentfolio.entities.Personne;
import com.ecom.studentfolio.repository.PersonneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonneService {

    private final PersonneRepository personneRepository;

    public List<Personne> findAll() {
        return personneRepository.findAll();
    }

    public Optional<Personne> findById(Long id) {
        return personneRepository.findById(id);
    }

    public Optional<Personne> findByEmail(String email) {
        return personneRepository.findByEmail(email);
    }

    public Personne save(Personne personne) {
        return personneRepository.save(personne);
    }

    public void deleteById(Long id) {
        personneRepository.deleteById(id);
    }
}