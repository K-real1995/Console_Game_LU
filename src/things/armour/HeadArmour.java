package things.armour;

import characters.Unit;

public class HeadArmour extends Armour{

    public HeadArmour(String itemName, int itemStrength, int itemWeight){
        super(itemName,itemStrength, itemWeight);
    }

    @Override
    public void equipWeapon(Unit target) {
        System.out.println("Вы не можете одеть броню в качестве оружия");
    }

    @Override
    public void equipArmour(Unit target){
        int totalUnitWeight = target.weapon.itemWeight + target.getInventoryWeight(target.inventory) +
                target.armour.itemWeight;
        if (totalUnitWeight < target.maxWeight){
            if (target.armour != null){
                target.defence += target.armour.itemStrength;
                System.out.println("Броня: " + target.armour.itemName + " экипировано" + "защита персонажа" + target.name +
                        " равна: " + target.defence);
            }
            else {
                System.out.println("У вашего персонажа нет брони");
            }

        }
        else {
            System.out.println("Слишком большой вес предметов, вы не можете столько нести");
        }

    }
}
