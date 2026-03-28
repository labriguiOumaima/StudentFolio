package com.ecom.studentfolio.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bio;
    private String skills;
    private String experiences;
    private String languages;

    @OneToOne
    @JoinColumn(name = "personne_id")
    private Personne personne;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private List<Project> projects;
}