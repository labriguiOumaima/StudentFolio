package com.ecom.studentfolio.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "portfolio")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String publicUrl;

    @Column(columnDefinition = "TEXT")
    private String generatedContent;

    private boolean isPublished;

    @OneToOne
    @JoinColumn(name = "personne_id")
    private Personne personne;

    @ManyToOne
    @JoinColumn(name = "template_id")
    private Template template;
}