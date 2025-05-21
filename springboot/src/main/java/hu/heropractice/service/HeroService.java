package hu.heropractice.service;

import hu.heropractice.converter.HeroConverter;
import hu.heropractice.dto.HeroCreate;
import hu.heropractice.dto.HeroRead;
import hu.heropractice.dto.HeroUpdate;
import hu.heropractice.models.Hero;
import hu.heropractice.models.Weapon;
import hu.heropractice.repository.HeroRepository;
import hu.heropractice.repository.WeaponRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeroService {

    @Autowired
    HeroRepository repository;

    @Autowired
    WeaponRepository weaponRepository;

    public HeroRead get(int id) {
        if(!repository.existsById(id)) {
            throw new RuntimeException("Hero not found");
        }

        Hero hero = repository.getReferenceById(id);
        return HeroConverter.convertModelToRead(hero);

    }

    public HeroRead create(@Valid HeroCreate newHero) {
        if (!weaponRepository.existsWeaponByType(newHero.getWeaponType())) {
            throw new RuntimeException("Weapon not exists");
        }

        Weapon weapon = weaponRepository.getWeaponByType(newHero.getWeaponType());
        Hero hero = HeroConverter.convertCreateToModel(newHero, weapon);
        Hero savedHero = repository.save(hero);
        return HeroConverter.convertModelToRead(savedHero);
    }

    public HeroRead update(HeroUpdate updateHero, int id) {
        if(!repository.existsById(id)) {
            throw new RuntimeException("Hero not found");
        }

        Hero hero = repository.getReferenceById(id);

        if(updateHero.getWeaponType() != null) {
            if(weaponRepository.existsWeaponByType(updateHero.getWeaponType())) {
                throw new RuntimeException("Weapon not found");
            }
            Weapon newWeapon = weaponRepository.getWeaponByType(updateHero.getWeaponType());
            hero.setWeapon(newWeapon);
        }
        if(updateHero.isCanFly() != hero.isCanFly()) {
            hero.setCanFly(updateHero.isCanFly());
        }

        Hero savedHero = repository.save(hero);
        return HeroConverter.convertModelToRead(savedHero);
    }
}
