package Model;

import javax.persistence.*;

@Entity(name = "room_extra")
public class RoomExtra {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "room_id")
    private int room_id;
    @Column(name = "extra_id")
    private String extra_id;

    public RoomExtra(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getExtra_id() {
        return extra_id;
    }

    public void setExtra_id(String extra_id) {
        this.extra_id = extra_id;
    }
}
