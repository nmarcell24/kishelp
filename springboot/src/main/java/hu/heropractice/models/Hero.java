package hu.heropractice.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String nationality;
    private boolean canFly;
    @ManyToOne
    private Weapon weapon;

}
