package characters.horde;

import characters.Unit;
import things.Inventory;
import things.armour.Armour;
import things.weapons.Weapon;

import javax.persistence.Entity;


public abstract class HordeUnit extends Unit {

    public HordeUnit(String name, int hp, int attack, int defence, int moneyCount, Inventory inventory, Armour armour, Weapon weapon, int maxWeight){
        super(name,hp,attack,defence,moneyCount,inventory, weapon, armour,maxWeight);

    }

    protected HordeUnit() {
    }

    @Override
    public void attack(Unit target){
    }

    @Override
    public int getInventoryWeight(Inventory inventory){
        return 0;
    }

    public void drop(Unit target){
    }
}
