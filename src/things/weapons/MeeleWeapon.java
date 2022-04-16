package things.weapons;

import characters.Unit;

public class MeeleWeapon extends Weapon {
    public int speed;

    public MeeleWeapon(String itemName, int weaponAttack, int itemStrength, int speed, int itemWeight) {
        super(itemName, weaponAttack, itemStrength, itemWeight);
        this.speed = speed;

    }


    @Override
    public void equipArmour(Unit target){
        System.out.println("Вы не можете одеть оружие в качестве брони");
    }

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
