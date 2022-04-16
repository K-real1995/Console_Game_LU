//Создать отдельный класс под оружие, добавив ему набор параметров и передавать его его нашим юнитам
package things.weapons;

import characters.Unit;
import things.Item;

public abstract class Weapon extends Item {
    public int weaponAttack;


    public Weapon(String itemName, int weaponAttack, int itemStrength, int itemWeight){
        super(itemName,itemStrength, itemWeight);
        this.weaponAttack = weaponAttack;
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

    public int getWeaponAttack(){
        return weaponAttack;
    }

}
