import abstractFabric.AbstractUnitFactory;
import abstractFabric.AllUnitFactory;
import characters.Unit;
import characters.aliance.Human;

import characters.aliance.NightElf;
import characters.horde.Orc;
import characters.horde.Tauren;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import strategy.GetStrongCharacter;
import strategy.GetWeakCharacter;
import things.Inventory;
import things.armour.Armour;
import things.armour.HeadArmour;
import things.armour.LegArmour;
import things.weapons.MagicWeapon;
import things.weapons.MeeleWeapon;
import things.weapons.RangedWeapon;
import things.weapons.Weapon;


public class Game {
    public static void main(String[] args) {

        //Cоздаем пустого юнита и генерируем его через класс GetStrongUnit по принципу паттерна стратегия
        Unit strongUnit = new Human();
        strongUnit.setStrategy(new GetStrongCharacter());
        strongUnit.executeStrategy(strongUnit);
        System.out.println(strongUnit);

        //Cоздаем пустого юнита и генерируем его через класс GetWeakUnit по принципу паттерна стратегия
        Unit weakUnit = new Orc();
        weakUnit.setStrategy(new GetWeakCharacter());
        weakUnit.executeStrategy(weakUnit);
        System.out.println(weakUnit);

        //Cоздаем персонажей по шаблону абстрактной фабрики
        AbstractUnitFactory unitFactory = new AllUnitFactory();

        Human humanUnit = unitFactory.getHuman();
        System.out.println(humanUnit);
        NightElf nightElfUnit = unitFactory.getNightElf();
        System.out.println(nightElfUnit);
        Orc orcUnit = unitFactory.getOrc();
        System.out.println(orcUnit);
        Tauren taurenUnit = unitFactory.getTauren();
        System.out.println(taurenUnit);

        //Создаем персонажей и добавляем их в базу данных
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Unit.class)
                .addAnnotatedClass(Human.class)
                .addAnnotatedClass(Inventory.class)
                .addAnnotatedClass(Armour.class)
                .addAnnotatedClass(Weapon.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            HeadArmour armour = new HeadArmour("Шлем", 500, 100);
            MeeleWeapon weapon = new MeeleWeapon("Топор", 500, 100, 214, 290);
            LegArmour armour1 = new LegArmour("Наколенники", 500, 100, 200);
            MagicWeapon weapon1 = new MagicWeapon("Посох", 1000, 100, 100, 50);
            RangedWeapon weapon2 = new RangedWeapon("Арбалет", 500, 100, 214, 512);
            Inventory inventory = new Inventory("Рюкзачок");
            inventory.addArmourToInventory(armour1);
            inventory.addWeaponToInventory(weapon1);
            inventory.addWeaponToInventory(weapon2);
            Human unit1 = new Human("Тимофей", 100, 100, 100, 10, weapon, armour, inventory, 1000);
            session.beginTransaction();
            session.persist(unit1);
            session.getTransaction().commit();
        }
        finally {
            assert session != null;
            session.close();
            factory.close();
        }
    }
}
