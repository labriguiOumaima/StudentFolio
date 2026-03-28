package com.ecom.studentfolio.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String techStack;
    private String github;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;
}