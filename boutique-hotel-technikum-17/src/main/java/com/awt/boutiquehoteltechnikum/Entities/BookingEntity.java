package com.awt.boutiquehoteltechnikum.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.Date;

@Table(name="booking")
@Entity
@Getter @Setter @NoArgsConstructor
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "additional_notes")
    private String additionalNotes;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomEntity roomEntity;
    @Column(name = "created_at")
    private OffsetDateTime createdAt = OffsetDateTime.now();
    @Column(name = "booking_start")
    private Date bookingStart;
    @Column(name = "booking_end")
    private Date bookingEnd;
    @Column(name = "breakfast")
    private boolean breakfast;
    @Column(name = "total_cost")
    private double totalCost;
    @Column(name = "cancelled")
    private boolean cancelled = false;

    public BookingEntity(String title, String additional_notes, CustomerEntity customer_entity, RoomEntity room_entity, Date booking_start, Date booking_end, boolean breakfast, double total_cost){
        this.title = title;
        this.additionalNotes = additional_notes;
        this.customerEntity = customer_entity;
        this.roomEntity = room_entity;
        this.bookingStart = booking_start;
        this.bookingEnd = booking_end;
        this.breakfast = breakfast;
        this.totalCost = total_cost;
    }
}
