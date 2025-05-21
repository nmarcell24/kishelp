package hu.heropractice.repository;

import hu.heropractice.model.Weapon;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeaponRepository extends JpaRepository<Weapon, Integer> {


    boolean existsWeaponByType(String weaponName);

    Weapon getWeaponByType(String weaponName);
}
