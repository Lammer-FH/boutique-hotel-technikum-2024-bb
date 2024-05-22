package Model;

import javax.persistence.*;

@Entity
public class Booking {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "additional_notes")
    private String additional_notes;
    @Column(name = "customer_id")
    private int customer_id;
    @Column(name = "room_id")
    private String room_id;
    @Column(name = "created_at")
    private String created_at;
    @Column(name = "booking_start")
    private String booking_start;
    @Column(name = "booking_end")
    private String booking_end;
    @Column(name = "breakfast")
    private boolean breakfast;
    @Column(name = "total_cost")
    private double total_cost;
    @Column(name = "cancelled")
    private boolean cancelled;

    public Booking() {}
}
