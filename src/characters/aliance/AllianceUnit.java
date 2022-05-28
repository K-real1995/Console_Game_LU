package characters.aliance;

import characters.Unit;
import things.Inventory;
import things.armour.Armour;
import things.Item;
import things.weapons.Weapon;

import javax.persistence.Entity;
import java.util.ArrayList;

public abstract class AllianceUnit extends Unit {

    public AllianceUnit(String name, int hp, int attack, int defence, int moneyCount, Weapon weapon, Armour armour,
                        Inventory inventory, int maxWeight) {
        super(name,hp,attack,defence,moneyCount,inventory, weapon, armour,maxWeight);
    }

    protected AllianceUnit() {
    }
}