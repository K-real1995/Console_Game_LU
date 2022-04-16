package characters.aliance;

import characters.Unit;
import things.armour.Armour;
import things.Item;
import things.weapons.Weapon;

import java.util.ArrayList;

public abstract class AllianceUnit extends Unit {

    public AllianceUnit(String name, int hp, int attack, int defence, int moneyCount, Weapon weapon, Armour armour,
                        ArrayList<Item> inventory, int maxWeight){
        super(name, hp, attack, defence, moneyCount, weapon, armour, inventory, maxWeight);

    }

    @Override
    public void attack(Unit target){
    }

    @Override
    public int getInventoryWeight(ArrayList<Item> target){
        return 0;
    }
    public void drop(Unit target){
    }
}
