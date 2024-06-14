package com.awt.boutiquehoteltechnikum.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "extra_type")
@Getter @Setter @NoArgsConstructor
public class ExtraType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;

    public ExtraType(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
