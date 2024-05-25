package awt.bb2024.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "room_extra")
@Getter @Setter @NoArgsConstructor
public class RoomExtra {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "room_id")
    private int room_id;
    @Column(name = "extra_id")
    private int extra_id;

    public RoomExtra(int room_id, int extra_id){
        this.room_id = room_id;
        this.extra_id = extra_id;
    }
}
