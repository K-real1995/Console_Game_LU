package characters;

import strategy.Strategy;
import characters.aliance.AllianceUnit;
import characters.horde.HordeUnit;
import things.Item;
import things.armour.Armour;
import things.weapons.Weapon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

import static characters.UnitFabric.*;


public class Unit implements UnitInterface, Serializable {
    public ArrayList<Item> inventory;
    public String name;
    public int hp;
    public int attack;
    public int defence;
    public int moneyCount;
    public Weapon weapon;
    public Armour armour;
    public int maxWeight;
    Strategy strategy;


    public Unit(String name, int hp, int attack, int defence, int moneyCount, Weapon weapon, Armour armour,
                ArrayList<Item> inventory, int maxWeight){
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.defence = defence;
        this.moneyCount = moneyCount;
        this.inventory = inventory;
        this.weapon = weapon;
        this.armour = armour;
        this.maxWeight = maxWeight;

    }

    public Unit() {
    }


    //Для двух полей выше разработать механизм прочности, когда при битвах прочность оружия и брони уменьшается.
    //В случае, когда прочность достигнет 0 эффекты которые дают предметы должны перестать работать
    public void attack(Unit target){
        int damage;

        if (weapon.getWeaponAttack() > target.armour.getItemStrength()) {
            System.out.println(target.armour.getItemName() + ": данный предмет разбит и больше вас не защищает!");
            target.defence -= target.armour.getItemStrength();
            damage = attack - target.defence;
        }

        else if (weapon.getItemStrength() < target.armour.getItemStrength()) {
            System.out.println("Ваше оружие " + weapon.getItemName() + " :cломано, атака снижена!");
            attack -= weapon.getWeaponAttack();
            damage = attack - target.defence;
        }

        else {
            damage = attack - target.defence;
        }

        if (damage > 0) {
            target.hp -= damage;
            System.out.println(name + " наносит " + damage + " урона!");
            System.out.println("Здоровье " + target.name + ": " + target.hp);
        }
        else
            System.out.println("Броня не пробита!");

        if(target.hp <= 0){
            drop(target);
        }
    }
    //Реализовать в интерфейсе юнит поле drop, которое определяет награду за победу над указанным персонажем
    public void drop(Unit target){
        inventory.add(target.weapon);
        inventory.add(target.armour);
        inventory.addAll(target.inventory);
        moneyCount += target.moneyCount;
        target.armour = null;
        target.weapon = null;
        target.inventory.clear();
        target.moneyCount = 0;
    }


    //Метод подсчитывающий общий вес инвентаря
    public int getInventoryWeight(ArrayList<Item> target){
        int totalInventoryWeight = 0;
        for (Item item : target) {
            int weight = item.itemWeight;
            totalInventoryWeight += weight;
        }
        return totalInventoryWeight;
    }

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

    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    public void executeStrategy(Unit unit){
        strategy.makeUnit(unit);

    }


}


