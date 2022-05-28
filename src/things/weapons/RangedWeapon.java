package things.weapons;

import characters.Unit;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class RangedWeapon extends Weapon {
    @Transient
    public int firingDistance;

    public RangedWeapon(String itemName, int weaponAttack, int itemStrength, int itemWeight, int firingDistance) {
        super(itemName, weaponAttack, itemStrength, itemWeight);
        this.firingDistance = firingDistance;
    }
}
