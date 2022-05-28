package characters.horde;

import things.Inventory;
import things.armour.Armour;
import things.weapons.Weapon;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Таурен")
public class Tauren extends HordeUnit {



    public Tauren(String name, int hp, int attack, int defence, int moneyCount, Weapon weapon, Armour armour,
                  Inventory inventory, int maxWeight){
        super(name,hp,attack,defence,moneyCount,inventory, armour, weapon,maxWeight);

    }

    public Tauren(){
    }
}
