package characters;
import things.Item;
import java.util.ArrayList;

interface UnitInterface {
    int getInventoryWeight(ArrayList<Item> target);
    void attack(Unit target);
    void drop(Unit target);
}

