package Model;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "email")
    private String email;
    @Column(name = "number")
    private String number;
    @Column(name = "address")
    private String address;

    public Customer() {}
}
