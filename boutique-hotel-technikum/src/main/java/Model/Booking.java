package Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor
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

    public Booking(String title, String additional_notes, int customer_id, String room_id, String created_at, String booking_start, String booking_end, boolean breakfast, double total_cost, boolean cancelled){
        this.title = title;
        this.additional_notes = additional_notes;
        this.customer_id = customer_id;
        this.room_id = room_id;
        this.created_at = created_at;
        this.booking_start = booking_start;
        this.booking_end = booking_end;
        this.breakfast = breakfast;
        this.total_cost = total_cost;
        this.cancelled = cancelled;
    }
}
