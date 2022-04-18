package characters.aliance;

import characters.Unit;
import things.armour.Armour;
import things.Item;
import things.weapons.Weapon;

import java.util.ArrayList;

public class NightElf extends AllianceUnit{

    public NightElf(String name, int hp, int attack, int defence, int moneyCount, Weapon weapon, Armour armour,
                    ArrayList<Item> inventory, int maxWeight){
        super(name, hp, attack, defence, moneyCount, weapon, armour, inventory, maxWeight);

    }
    @Override
    public void attack(Unit target){
        int damage;

        if (target.armour == null){
            System.out.println("Броня разбита и больше вас не защищает!");
            damage = (attack + weapon.getWeaponAttack()) - target.defence;
        }
        else if (weapon == null){
            System.out.println("Оружие сломано, атака снижена");
            damage = attack - (target.defence + target.armour.getItemStrength());
        }
        else damage = (attack + weapon.getWeaponAttack()) - (target.armour.getItemStrength() + target.defence);

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

    @Override
    public int getInventoryWeight(ArrayList<Item> target){
        int totalInventoryWeight = 0;
        for (Item item : target) {
            int weight = item.itemWeight;
            totalInventoryWeight += weight;
        }
        return totalInventoryWeight;
    }

    @Override
    public void drop(Unit target){
        target.inventory.addAll(inventory);
        inventory.add(target.weapon);
        inventory.add(target.armour);
        target.armour = null;
        target.weapon = null;
        target.inventory.clear();
        moneyCount += target.moneyCount;
        target.moneyCount = 0;

    }

}
