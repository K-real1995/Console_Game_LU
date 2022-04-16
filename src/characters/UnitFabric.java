package characters;

import characters.aliance.AllianceUnit;
import characters.aliance.Human;
import characters.aliance.NightElf;
import characters.horde.HordeUnit;
import characters.horde.Orc;
import characters.horde.Tauren;
import things.Item;
import things.ItemFabric;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import static things.ItemFabric.getRandomBreastArmour;
import static things.ItemFabric.getRandomMeleeWeapon;

public class UnitFabric {


        public static LinkedList<HordeUnit> getRandomHordeArmy () {
            LinkedList<HordeUnit> hordeArmy = new LinkedList<>();
            while (hordeArmy.size() < 10) {
                hordeArmy.add((HordeUnit) getRandomOrc());
                hordeArmy.add((HordeUnit) getRandomTauren());
            }
            return hordeArmy;
        }

        public static LinkedList<AllianceUnit> getRandomAllianeceArmy () {
            LinkedList<AllianceUnit> allianceArmy = new LinkedList<>();
            while (allianceArmy.size() < 10) {
                allianceArmy.add((AllianceUnit) getRandomHuman());
                allianceArmy.add((AllianceUnit) getRandomElf());
            }
            return allianceArmy;
        }


        public static Unit getRandomOrc () {
            return new Orc(getRandomOrcName(), getRandomHp(), getRandomAttack(), getRandomDefence(), getRandomMoneyCount(),
                    getRandomMeleeWeapon(), getRandomBreastArmour(), getInventory(), getRandomMaxWeight());
        }

        public static Unit getRandomTauren () {
            return new Tauren(getRandomTaurenName(), getRandomHp(), getRandomAttack(), getRandomDefence(), getRandomMoneyCount(),
                    getRandomMeleeWeapon(), getRandomBreastArmour(), getInventory(), getRandomMaxWeight());
        }

        public static Unit getRandomElf () {
            return new NightElf(getRandomNightElfName(), getRandomHp(), getRandomAttack(), getRandomDefence(), getRandomMoneyCount(),
                    getRandomMeleeWeapon(), getRandomBreastArmour(), getInventory(), getRandomMaxWeight());
        }

        public static Unit getRandomHuman () {
            return new Human(getRandomHumanName(), getRandomHp(), getRandomAttack(), getRandomDefence(), getRandomMoneyCount(),
                    getRandomMeleeWeapon(), getRandomBreastArmour(), getInventory(), getRandomMaxWeight());
        }


        public static String getRandomOrcName() {
            String[] names = {"Манрок", "Рагмаш", "Нуррог", "Тхург-Адаш", "Кхэру", "Тург", "Тальхур", "Килхак", "Корзул"};

            return names[new Random().nextInt(names.length)];
        }

        public static String getRandomNightElfName () {
            String[] names = {"Лирасул", "Карантир", "Монрэмир", "Нарамакил", "Синьагил", "Турохтар", "Эленандар", "Элеммакил"};

            return names[new Random().nextInt(names.length)];
        }

        public static String getRandomTaurenName () {
            String[] names = {"Гавакен", "Хахарук", "Мурагорн", "Дельрельрут", "Тарнамин", "Ксанумин", "Карельтек", "Урельлег"};

            return names[new Random().nextInt(names.length)];
        }

        public static String getRandomHumanName () {
            String[] names = {"Ланггрекус", "Никдиотт", "Тейиниот", "Ладрорик", "Росланд", "Брендромонд", "Брэдларитт", "Кэмпинки"};

            return names[new Random().nextInt(names.length)];
        }

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
            int i = new Random().nextInt(1, 1001);
            return i;
        }

        public static ArrayList<Item> getInventory () {
            ArrayList<Item> inventory = new ArrayList<>();
            inventory.add(ItemFabric.getRandomMeleeWeapon());
            inventory.add(ItemFabric.getRandomBreastArmour());
            return inventory;
        }

        public static int getRandomMaxWeight () {
            return new Random().nextInt(1000, 2001);
        }
    }






