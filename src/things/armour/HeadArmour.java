package things.armour;

import characters.Unit;

import javax.persistence.Entity;

@Entity
public class HeadArmour extends Armour{

    public HeadArmour(String itemName, int itemStrength, int itemWeight){
        super(itemName,itemStrength, itemWeight);
    }
}
