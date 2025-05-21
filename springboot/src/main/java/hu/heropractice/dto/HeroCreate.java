package hu.heropractice.dto;

import hu.heropractice.models.Weapon;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class HeroCreate {
    @NotNull
    private String name;
    @NotNull
    private String nationality;
    @NotNull
    private boolean canFly;
    @NotNull
    private String weaponType;
}
