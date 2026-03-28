package com.ecom.studentfolio.repository;

import com.ecom.studentfolio.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByPersonneId(Long personneId);
}