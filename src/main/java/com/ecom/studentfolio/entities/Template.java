package com.ecom.studentfolio.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "template")
public class Template {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String style;
    private String previewUrl;
    private boolean isActive;
}