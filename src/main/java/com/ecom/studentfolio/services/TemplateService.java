package com.ecom.studentfolio.services;

import com.ecom.studentfolio.entities.Template;
import com.ecom.studentfolio.repository.TemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TemplateService {

    private final TemplateRepository templateRepository;

    public List<Template> findAll() {
        return templateRepository.findAll();
    }

    public List<Template> findActifs() {
        return templateRepository.findByIsActiveTrue();
    }

    public Optional<Template> findById(Long id) {
        return templateRepository.findById(id);
    }

    public Template save(Template template) {
        return templateRepository.save(template);
    }

    public void deleteById(Long id) {
        templateRepository.deleteById(id);
    }
}