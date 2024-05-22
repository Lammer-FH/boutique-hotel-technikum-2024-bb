package Model;

import javax.persistence.*;

@Entity
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

    public Room() {}
}
