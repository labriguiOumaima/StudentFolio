package com.ecom.studentfolio.rest;

import com.ecom.studentfolio.dto.ProfileDTO;
import com.ecom.studentfolio.entities.Profile;
import com.ecom.studentfolio.repository.ProfileRepository;
import com.ecom.studentfolio.services.ProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profiles")
public class ProfileRestController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private ProfileRepository profileRepository;

    // GET /api/profiles - pagination + tri via Pageable
    @GetMapping
    public Page<ProfileDTO> getAll(Pageable pageable) {
        return profileRepository.findAll(pageable).map(profile -> {
            ProfileDTO dto = new ProfileDTO();
            dto.setId(profile.getId());
            dto.setBio(profile.getBio());
            dto.setSkills(profile.getSkills());
            dto.setExperiences(profile.getExperiences());
            dto.setLanguages(profile.getLanguages());
            if (profile.getPersonne() != null) {
                dto.setPersonneId(profile.getPersonne().getId());
            }
            return dto;
        });
    }

    // GET /api/profiles/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ProfileDTO> getById(@PathVariable Long id) {
        return profileService.findById(id).map(profile -> {
            ProfileDTO dto = new ProfileDTO();
            dto.setId(profile.getId());
            dto.setBio(profile.getBio());
            dto.setSkills(profile.getSkills());
            dto.setExperiences(profile.getExperiences());
            dto.setLanguages(profile.getLanguages());
            if (profile.getPersonne() != null) {
                dto.setPersonneId(profile.getPersonne().getId());
            }
            return ResponseEntity.ok(dto);
        }).orElse(ResponseEntity.notFound().build());
    }

    // GET /api/profiles/personne/{personneId}
    @GetMapping("/personne/{personneId}")
    public ResponseEntity<ProfileDTO> getByPersonneId(@PathVariable Long personneId) {
        return profileService.findByPersonneId(personneId).map(profile -> {
            ProfileDTO dto = new ProfileDTO();
            dto.setId(profile.getId());
            dto.setBio(profile.getBio());
            dto.setSkills(profile.getSkills());
            dto.setExperiences(profile.getExperiences());
            dto.setLanguages(profile.getLanguages());
            dto.setPersonneId(personneId);
            return ResponseEntity.ok(dto);
        }).orElse(ResponseEntity.notFound().build());
    }

    // POST /api/profiles
    @PostMapping
    public ResponseEntity<ProfileDTO> create(@Valid @RequestBody ProfileDTO dto) {
        Profile profile = new Profile();
        profile.setBio(dto.getBio());
        profile.setSkills(dto.getSkills());
        profile.setExperiences(dto.getExperiences());
        profile.setLanguages(dto.getLanguages());
        Profile saved = profileService.save(profile);
        dto.setId(saved.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    // PUT /api/profiles/{id}
    @PutMapping("/{id}")
    public ResponseEntity<ProfileDTO> update(@PathVariable Long id, @Valid @RequestBody ProfileDTO dto) {
        return profileService.findById(id).map(profile -> {
            profile.setBio(dto.getBio());
            profile.setSkills(dto.getSkills());
            profile.setExperiences(dto.getExperiences());
            profile.setLanguages(dto.getLanguages());
            Profile updated = profileService.save(profile);
            dto.setId(updated.getId());
            return ResponseEntity.ok(dto);
        }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/profiles/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (profileService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        profileService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}