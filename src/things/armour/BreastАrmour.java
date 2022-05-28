package things.armour;

import characters.Unit;

import javax.persistence.Entity;
import javax.persistence.Transient;
@Entity
public class BreastАrmour extends Armour {
    @Transient
    public int dexterity;

    public BreastАrmour(String itemName, int itemStrength, int itemWeight, int dexterity){
        super(itemName,itemStrength, itemWeight);
        this.dexterity = dexterity;
    }
}
