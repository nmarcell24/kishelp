package hu.heropractice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Weapon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String type;

}
