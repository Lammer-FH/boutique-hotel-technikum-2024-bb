package com.awt.boutiquehoteltechnikum.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "room_extra")
@Getter @Setter @NoArgsConstructor
public class RoomExtra {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "room_id")
    private int roomId;
    @Column(name = "extra_id")
    private int extraId;

    public RoomExtra(int room_id, int extra_id){
        this.roomId = room_id;
        this.extraId = extra_id;
    }
}