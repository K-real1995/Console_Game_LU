package things.weapons;

import characters.Unit;

public class MagicWeapon extends Weapon {
    public int weaponMana;

    public MagicWeapon(String itemName, int weaponAttack, int itemStrength, int weaponMana, int itemWeight) {
        super(itemName, weaponAttack, itemStrength, itemWeight);
        this.weaponMana = weaponMana;

    }


    @Override
    public void equipArmour(Unit target){
        System.out.println("Вы не можете одеть оружие в качестве брони");
    }

    @Override
    public void equipWeapon(Unit target) {
        int totalUnitWeight = target.weapon.itemWeight + target.getInventoryWeight(target.inventory) +
                target.armour.itemWeight;
        if (totalUnitWeight < target.maxWeight) {
            if (target.weapon != null) {
                target.attack += target.weapon.weaponAttack;
                System.out.println("Оружие: " + target.weapon.itemName + " экипировано " + "атака персонажа " + target.name +
                        " равна: " + target.attack);
            } else {
                System.out.println("У вашего персонажа нет оружия");
            }
        }
        else {
            System.out.println("Слишком большой вес предметов, вы не можете столько нести");
        }
    }
}
