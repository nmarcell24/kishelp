package hu.heropractice.dto;

import hu.heropractice.model.Weapon;
import lombok.Data;

@Data
public class UpdateHero {
    private boolean canFly;
    private String weaponName;
}
