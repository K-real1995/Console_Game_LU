package characters.aliance;

import things.Inventory;
import things.armour.Armour;
import things.weapons.Weapon;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Человек")
public class Human extends AllianceUnit {


    public Human(String name, int hp, int attack, int defence, int moneyCount, Weapon weapon, Armour armour,
                 Inventory inventory, int maxWeight){
        super(name,hp,attack,defence,moneyCount, weapon, armour, inventory,maxWeight);
    }

    public Human() {
    }
}

