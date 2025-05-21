package hu.heropractice.service;

import hu.heropractice.converter.HeroConverter;
import hu.heropractice.dto.CreateHero;
import hu.heropractice.dto.ListHero;
import hu.heropractice.dto.ReadHero;
import hu.heropractice.dto.UpdateHero;
import hu.heropractice.model.Hero;
import hu.heropractice.model.Weapon;
import hu.heropractice.repository.HeroRepository;
import hu.heropractice.repository.WeaponRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroService {

    @Autowired
    HeroRepository repository;

    @Autowired
    WeaponRepository weaponRepository;


    public ReadHero get(int id) {
        if(!repository.existsById(id)) {
            throw new RuntimeException("Hero not found");
        }

        return HeroConverter.convertModelToRead(repository.getReferenceById(id));
    }

    public ReadHero create(@Valid CreateHero newHero) {
        if(!weaponRepository.existsWeaponByType(newHero.getWeaponName())) {
            throw new RuntimeException("Weapon not found");
        }
        Weapon weapon = weaponRepository.getWeaponByType(newHero.getWeaponName());
        Hero hero = HeroConverter.convertCreateToModel(newHero, weapon);
        Hero savedHero = repository.save(hero);
        return HeroConverter.convertModelToRead(savedHero);
    }

    public ReadHero update(UpdateHero updateHero, int id) {
        if(!repository.existsById(id)) {
            throw new RuntimeException("Hero not found");
        }

        Hero hero = repository.getReferenceById(id);

        if(updateHero.getWeaponName() != null) {
            if(weaponRepository.existsWeaponByType(updateHero.getWeaponName())){
                throw new RuntimeException("Weapon not found");
            }
            Weapon weapon = weaponRepository.getWeaponByType(updateHero.getWeaponName());
            hero.setWeapon(weapon);
        }

        if(updateHero.isCanFly() != hero.isCanFly()) {
            hero.setCanFly(updateHero.isCanFly());
        }
        Hero savedHero = repository.save(hero);
        return HeroConverter.convertModelToRead(savedHero);
    }

    public List<ListHero> list() {
        List<Hero> heroes = repository.findAll();
        return HeroConverter.convertModelsToList(heroes);
    }

    public ReadHero delete(int id) {

        return HeroConverter.convertModelToRead(repository.getReferenceById(id));
    }
}
