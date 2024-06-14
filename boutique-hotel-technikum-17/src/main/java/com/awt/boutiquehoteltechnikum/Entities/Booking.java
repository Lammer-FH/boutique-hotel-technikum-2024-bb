package com.awt.boutiquehoteltechnikum.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Table(name="booking")
@Entity
@Getter @Setter @NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "additional_notes")
    private String additionalNotes;
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "room_id")
    private String roomId;
    @Column(name = "created_at")
    private OffsetDateTime createdAt = OffsetDateTime.now();
    @Column(name = "booking_start")
    private String bookingStart;
    @Column(name = "booking_end")
    private String bookingEnd;
    @Column(name = "breakfast")
    private boolean breakfast;
    @Column(name = "total_cost")
    private double totalCost;
    @Column(name = "cancelled")
    private boolean cancelled = false;

    public Booking(String title, String additional_notes, int customer_id, String room_id, String booking_start, String booking_end, boolean breakfast, double total_cost){
        this.title = title;
        this.additionalNotes = additional_notes;
        this.customerId = customer_id;
        this.roomId = room_id;
        this.bookingStart = booking_start;
        this.bookingEnd = booking_end;
        this.breakfast = breakfast;
        this.totalCost = total_cost;
    }
}
