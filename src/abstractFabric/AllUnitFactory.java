package abstractFabric;

import characters.aliance.Human;
import characters.aliance.NightElf;
import characters.horde.Orc;
import characters.horde.Tauren;
import things.Inventory;
import things.ItemFabric;
import things.armour.BreastАrmour;
import things.weapons.MeeleWeapon;
import java.util.Random;

public class AllUnitFactory implements AbstractUnitFactory{


    //Метод создания рандомного человека
    @Override
    public Human getHuman(){
        String[] names = {"Ланггрекус", "Никдиотт", "Тейиниот", "Ладрорик", "Росланд", "Брендромонд", "Брэдларитт", "Кэмпинки"};
        String humanName = names[new Random().nextInt(names.length)];
        int hp = new Random().nextInt(1, 101);
        int attack = new Random().nextInt(1, 301);
        int defence = new Random().nextInt(1, 201);
        int moneyCount = new Random().nextInt(1, 1001);
        BreastАrmour armour = ItemFabric.getRandomBreastArmour();
        MeeleWeapon weapon = ItemFabric.getRandomMeleeWeapon();
        String[] inventoryNames = {"Рюкзачок", "Сумка", "Багаж", "Cаквояж"};
        Inventory inventory = new Inventory(inventoryNames[new Random().nextInt(inventoryNames.length)]);
        int maxWeight = new Random().nextInt(1000, 2001);

        return new Human(humanName,hp,attack,defence, moneyCount,weapon,armour, inventory, maxWeight);
    }

    //Метод создания рандомного орка
    @Override
    public Orc getOrc(){
        String[] names = {"Манрок", "Рагмаш", "Нуррог", "Тхург-Адаш", "Кхэру", "Тург", "Тальхур", "Килхак", "Корзул"};
        String orcName = names[new Random().nextInt(names.length)];
        int hp = new Random().nextInt(1, 101);
        int attack = new Random().nextInt(1, 301);
        int defence = new Random().nextInt(1, 201);
        int moneyCount = new Random().nextInt(1, 1001);
        BreastАrmour armour = ItemFabric.getRandomBreastArmour();
        MeeleWeapon weapon = ItemFabric.getRandomMeleeWeapon();
        String[] inventoryNames = {"Рюкзачок", "Сумка", "Багаж", "Cаквояж"};
        Inventory inventory = new Inventory(inventoryNames[new Random().nextInt(inventoryNames.length)]);
        int maxWeight = new Random().nextInt(1000, 2001);

        return new Orc(orcName,hp,attack,defence, moneyCount,weapon,armour, inventory, maxWeight);
    }

    //Метод создания рандомного ночного эльфа
    @Override
    public NightElf getNightElf(){
        String[] names = {"Лирасул", "Карантир", "Монрэмир", "Нарамакил", "Синьагил", "Турохтар", "Эленандар", "Элеммакил"};
        String nightElfName = names[new Random().nextInt(names.length)];
        int hp = new Random().nextInt(1, 101);
        int attack = new Random().nextInt(1, 301);
        int defence = new Random().nextInt(1, 201);
        int moneyCount = new Random().nextInt(1, 1001);
        BreastАrmour armour = ItemFabric.getRandomBreastArmour();
        MeeleWeapon weapon = ItemFabric.getRandomMeleeWeapon();
        String[] inventoryNames = {"Рюкзачок", "Сумка", "Багаж", "Cаквояж"};
        Inventory inventory = new Inventory(inventoryNames[new Random().nextInt(inventoryNames.length)]);
        int maxWeight = new Random().nextInt(1000, 2001);

        return new NightElf(nightElfName,hp,attack,defence, moneyCount,weapon,armour, inventory, maxWeight);
    }


    //Метод создания рандомного таурена
    @Override
    public Tauren getTauren(){
        String[] names = {"Гавакен", "Хахарук", "Мурагорн", "Дельрельрут", "Тарнамин", "Ксанумин", "Карельтек", "Урельлег"};
        String taurenName = names[new Random().nextInt(names.length)];
        int hp = new Random().nextInt(1, 101);
        int attack = new Random().nextInt(1, 301);
        int defence = new Random().nextInt(1, 201);
        int moneyCount = new Random().nextInt(1, 1001);
        BreastАrmour armour = ItemFabric.getRandomBreastArmour();
        MeeleWeapon weapon = ItemFabric.getRandomMeleeWeapon();
        String[] inventoryNames = {"Рюкзачок", "Сумка", "Багаж", "Cаквояж"};
        Inventory inventory = new Inventory(inventoryNames[new Random().nextInt(inventoryNames.length)]);
        int maxWeight = new Random().nextInt(1000, 2001);

        return new Tauren(taurenName,hp,attack,defence, moneyCount,weapon,armour, inventory, maxWeight);
    }
}
