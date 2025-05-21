package hu.heropractice.dto;

import hu.heropractice.models.Weapon;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class HeroRead {
    private int id;
    private String name;
    private String nationality;
    private boolean canFly;
    @ManyToOne
    @JoinColumn(name = "weapon_id")
    private Weapon weapon;
}
