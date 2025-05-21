package hu.heropractice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateHero {
    @NotNull
    @Min(30)
    private String name;
    @NotNull
    private String nationality;
    @NotNull
    private boolean canFly;
    @NotNull
    private String weaponName;
}
