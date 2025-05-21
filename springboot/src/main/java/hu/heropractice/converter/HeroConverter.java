package hu.heropractice.converter;

import hu.heropractice.dto.HeroCreate;
import hu.heropractice.dto.HeroRead;
import hu.heropractice.models.Hero;
import hu.heropractice.models.Weapon;

public class HeroConverter {
    public static HeroRead convertModelToRead(Hero hero) {
        HeroRead heroRead = new HeroRead();
        heroRead.setId( hero.getId() );
        heroRead.setName( hero.getName() );
        heroRead.setNationality( hero.getNationality() );
        heroRead.setCanFly( hero.isCanFly() );
        heroRead.setWeapon( hero.getWeapon() );
        return heroRead;
    }

    public static Hero convertCreateToModel(HeroCreate newHero, Weapon weapon) {
        Hero hero = new Hero();
        hero.setName( newHero.getName() );
        hero.setNationality( newHero.getNationality() );
        hero.setCanFly( newHero.isCanFly() );
        hero.setWeapon(weapon);
        return hero;
    }
}
