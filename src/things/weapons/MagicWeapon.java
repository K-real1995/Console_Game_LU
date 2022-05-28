package things.weapons;

import characters.Unit;

import javax.persistence.Entity;
import javax.persistence.Transient;
@Entity
public class MagicWeapon extends Weapon {
    @Transient
    public int weaponMana;

    public MagicWeapon(String itemName, int weaponAttack, int itemStrength, int itemWeight, int weaponMana) {
        super(itemName, weaponAttack, itemStrength, itemWeight);
        this.weaponMana = weaponMana;

    }
}
