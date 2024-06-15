package com.awt.boutiquehoteltechnikum.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "room_extra")
@Getter @Setter @NoArgsConstructor
public class RoomExtraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomEntity roomEntity;
    @ManyToOne
    @JoinColumn(name = "extra_id")
    private ExtraTypeEntity extraTypeEntity;

    public RoomExtraEntity(RoomEntity room_id, ExtraTypeEntity extra_id){
        this.roomEntity = room_id;
        this.extraTypeEntity = extra_id;
    }
}
