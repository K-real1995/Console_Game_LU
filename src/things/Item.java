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

    public Item() {
    }

    @Override
    public void equipArmour(Unit target){

    }

    @Override
    public void equipWeapon(Unit target) {
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



