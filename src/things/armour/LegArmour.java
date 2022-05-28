package things.armour;

import characters.Unit;

import javax.persistence.Entity;
import javax.persistence.Transient;
@Entity
public class LegArmour extends Armour {
    @Transient
    public int speed;

    public LegArmour(String itemName, int itemStrength, int speed, int itemWeight) {
        super(itemName, itemStrength, itemWeight);
        this.speed = speed;
    }
}
