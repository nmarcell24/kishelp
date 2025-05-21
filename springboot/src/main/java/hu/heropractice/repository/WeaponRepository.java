package hu.heropractice.repository;

import hu.heropractice.models.Weapon;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeaponRepository extends JpaRepository<Weapon, Integer> {
    boolean existsWeaponByType(String type);

    Weapon getWeaponByType(@NotNull String weaponType);
}
