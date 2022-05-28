package things.weapons;

import characters.Unit;

import javax.persistence.Entity;
import javax.persistence.Transient;
@Entity
public class MeeleWeapon extends Weapon {
    @Transient
    public int speed;

    public MeeleWeapon(String itemName, int weaponAttack, int itemStrength, int itemWeight, int speed) {
        super(itemName, weaponAttack, itemStrength, itemWeight);
        this.speed = speed;
    }
}
