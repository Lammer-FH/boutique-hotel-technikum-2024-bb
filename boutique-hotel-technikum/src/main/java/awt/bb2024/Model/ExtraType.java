package awt.bb2024.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "extra_type")
@Getter @Setter @NoArgsConstructor
public class ExtraType {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;

    public ExtraType(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
