package hu.heropractice.converter;

import hu.heropractice.dto.CreateHero;
import hu.heropractice.dto.ListHero;
import hu.heropractice.dto.ReadHero;
import hu.heropractice.model.Hero;
import hu.heropractice.model.Weapon;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

public class HeroConverter {
    public static ReadHero convertModelToRead(Hero hero) {
        ReadHero readHero = new ReadHero();
        readHero.setId(hero.getId());
        readHero.setName(hero.getName());
        readHero.setNationality(hero.getNationality());
        readHero.setCanFly(hero.isCanFly());
        readHero.setWeaponName(hero.getWeapon().getType());
        return readHero;
    }

    public static Hero convertCreateToModel(@Valid CreateHero newHero, Weapon weapon) {
        Hero hero = new Hero();
        hero.setName(newHero.getName());
        hero.setNationality(newHero.getNationality());
        hero.setCanFly(newHero.isCanFly());
        hero.setWeapon(weapon);
        return hero;
    }

    public static List<ListHero> convertModelsToList(List<Hero> heroes) {
        List<ListHero> readHeroes = new ArrayList<>();
        for (Hero hero : heroes) {
            readHeroes.add(HeroConverter.convertModelToListItem(hero));
        }
        return readHeroes;
    }

    private static ListHero convertModelToListItem(Hero hero) {
        ListHero listHero = new ListHero();
        listHero.setName(hero.getName());
        listHero.setNationality(hero.getNationality());
        return listHero;
    }
}
