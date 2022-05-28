package characters;

import characters.aliance.AllianceUnit;
import characters.aliance.Human;
import characters.aliance.NightElf;
import characters.horde.HordeUnit;
import characters.horde.Orc;
import characters.horde.Tauren;
import things.Inventory;
import java.util.LinkedList;
import java.util.Random;

import static things.ItemFabric.getRandomBreastArmour;
import static things.ItemFabric.getRandomMeleeWeapon;


public class UnitFabric {

        //Метод создающий армию орды
        public static LinkedList<HordeUnit> getRandomHordeArmy () {
            LinkedList<HordeUnit> hordeArmy = new LinkedList<>();
            while (hordeArmy.size() < 10) {
                hordeArmy.add((HordeUnit) getRandomOrc());
                hordeArmy.add((HordeUnit) getRandomTauren());
            }
            return hordeArmy;
        }
        //Метод создающий армию альянса
        public static LinkedList<AllianceUnit> getRandomAllianeceArmy () {
            LinkedList<AllianceUnit> allianceArmy = new LinkedList<>();
            while (allianceArmy.size() < 10) {
                allianceArmy.add((AllianceUnit) getRandomHuman());
                allianceArmy.add((AllianceUnit) getRandomElf());
            }
            return allianceArmy;
        }

        //Метод создающий рандомного орка
        public static Unit getRandomOrc () {
            return new Orc(getRandomOrcName(), getRandomHp(), getRandomAttack(), getRandomDefence(), getRandomMoneyCount(),
                    getRandomMeleeWeapon(), getRandomBreastArmour(), getInventory(), getRandomMaxWeight());
        }
        //Метод создающий рандомного таурена
        public static Unit getRandomTauren () {
            return new Tauren(getRandomTaurenName(), getRandomHp(), getRandomAttack(), getRandomDefence(), getRandomMoneyCount(),
                    getRandomMeleeWeapon(), getRandomBreastArmour(), getInventory(), getRandomMaxWeight());
        }
        //Метод создающий рандомного ночного эльфа
        public static Unit getRandomElf () {
            return new NightElf(getRandomNightElfName(), getRandomHp(), getRandomAttack(), getRandomDefence(), getRandomMoneyCount(),
                    getRandomMeleeWeapon(), getRandomBreastArmour(), getInventory(), getRandomMaxWeight());
        }
        //Метод создающий рандомного человека
        public static Unit getRandomHuman () {
            return new Human(getRandomHumanName(), getRandomHp(), getRandomAttack(), getRandomDefence(), getRandomMoneyCount(),
                    getRandomMeleeWeapon(), getRandomBreastArmour(), getInventory(), getRandomMaxWeight());
        }

        //Метод создающий рандомного имя для орка
        public static String getRandomOrcName() {
            String[] names = {"Манрок", "Рагмаш", "Нуррог", "Тхург-Адаш", "Кхэру", "Тург", "Тальхур", "Килхак", "Корзул"};

            return names[new Random().nextInt(names.length)];
        }
        //Метод создающий рандомное имя ночного эльфа
        public static String getRandomNightElfName () {
            String[] names = {"Лирасул", "Карантир", "Монрэмир", "Нарамакил", "Синьагил", "Турохтар", "Эленандар", "Элеммакил"};

            return names[new Random().nextInt(names.length)];
        }
        //Метод создающий рандомное имя для таурена
        public static String getRandomTaurenName () {
            String[] names = {"Гавакен", "Хахарук", "Мурагорн", "Дельрельрут", "Тарнамин", "Ксанумин", "Карельтек", "Урельлег"};

            return names[new Random().nextInt(names.length)];
        }
        //Метод создающий рандомное имя для человека
        public static String getRandomHumanName () {
            String[] names = {"Ланггрекус", "Никдиотт", "Тейиниот", "Ладрорик", "Росланд", "Брендромонд", "Брэдларитт", "Кэмпинки"};

            return names[new Random().nextInt(names.length)];
        }
        //Методы создающие рандомные параметры, оружие инвентарь для рандомного персонажа
        public static int getRandomHp () {
            return new Random().nextInt(1, 101);
        }

        public static int getRandomAttack () {
            return new Random().nextInt(1, 301);
        }

        public static int getRandomDefence () {
            return new Random().nextInt(1, 201);
        }

        public static int getRandomMoneyCount () {
            return new Random().nextInt(1, 1001);
        }

        public static Inventory getInventory () {
            String[] inventoryNames = {"Рюкзачок", "Сумка", "Багаж", "Cаквояж"};
            Inventory inventory = new Inventory(inventoryNames[new Random().nextInt(inventoryNames.length)]);
            inventory.add(getRandomMeleeWeapon());
            inventory.add(getRandomBreastArmour());
            return inventory;
        }

        public static int getRandomMaxWeight () {
            return new Random().nextInt(1000, 2001);
        }
    }






