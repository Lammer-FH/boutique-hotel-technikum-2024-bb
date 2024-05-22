package Model;

import javax.persistence.*;

@Entity(name = "extra_type")
public class ExtraType {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;

    public ExtraType() {}
}
