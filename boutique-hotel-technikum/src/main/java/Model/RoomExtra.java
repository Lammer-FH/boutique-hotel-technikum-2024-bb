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
}
