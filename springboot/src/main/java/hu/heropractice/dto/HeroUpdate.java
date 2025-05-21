package hu.heropractice.dto;

import hu.heropractice.models.Weapon;
import lombok.Data;

@Data
public class HeroUpdate {
    private boolean canFly;
    private String weaponType;
}
