package characters;
import things.Inventory;
import things.Item;
import java.util.ArrayList;

interface UnitInterface {
    int getInventoryWeight(Inventory inventory);
    void attack(Unit target);
    void drop(Unit target);
}

