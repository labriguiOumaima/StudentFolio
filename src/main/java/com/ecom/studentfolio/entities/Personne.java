package com.ecom.studentfolio.entities;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "personne")
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    // Champs spécifiques étudiant (null si admin)
    private String universite;
    private String formation;
    private Integer annee;

    // Champs spécifiques admin
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @OneToOne(mappedBy = "personne", cascade = CascadeType.ALL)
    private Profile profile;

    @OneToOne(mappedBy = "personne", cascade = CascadeType.ALL)
    private Portfolio portfolio;
}