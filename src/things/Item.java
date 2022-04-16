package things;
import characters.Unit;
import java.io.Serializable;

public abstract class Item implements ItemInterface, Serializable {
    public String itemName;
    public int itemStrength;
    public int itemWeight;


    public Item(String itemName, int itemStrength, int itemWeight){
        this.itemName = itemName;
        this.itemStrength = itemStrength;
        this.itemWeight = itemWeight;
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

    public String getItemName(){
        return itemName;
    }

    public int getItemStrength(){
        return itemStrength;
    }

    public int getItemWeight(){
        return itemWeight;
    }
}



