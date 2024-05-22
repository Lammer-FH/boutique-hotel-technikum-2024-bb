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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAdditional_notes() {
        return additional_notes;
    }

    public void setAdditional_notes(String additional_notes) {
        this.additional_notes = additional_notes;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getBooking_start() {
        return booking_start;
    }

    public void setBooking_start(String booking_start) {
        this.booking_start = booking_start;
    }

    public String getBooking_end() {
        return booking_end;
    }

    public void setBooking_end(String booking_end) {
        this.booking_end = booking_end;
    }

    public boolean isBreakfast() {
        return breakfast;
    }

    public void setBreakfast(boolean breakfast) {
        this.breakfast = breakfast;
    }

    public double getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(double total_cost) {
        this.total_cost = total_cost;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
