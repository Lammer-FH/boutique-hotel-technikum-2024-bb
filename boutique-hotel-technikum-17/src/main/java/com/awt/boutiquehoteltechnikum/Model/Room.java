package com.awt.boutiquehoteltechnikum.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter @Setter @NoArgsConstructor
public class Room {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private double price;
    @Column(name = "room_type")
    private String room_type;
    @Column(name = "bed_type")
    private String bed_type;
    @Column(name = "bed_count")
    private int bed_count;
    @Column(name = "image")
    private String image;

    public Room(String title, String description, double price, String room_type, String bed_type, int bed_count, String image) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.room_type = room_type;
        this.bed_type = bed_type;
        this.bed_count = bed_count;
        this.image = image;
    }
}
