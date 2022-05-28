//Аналогично сделать с броней
package things.armour;

import characters.Unit;
import things.Inventory;
import things.Item;

import javax.persistence.*;
//Класс с настройками hibernate для взаимодействия с базой данных, таблицей armors
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "armors")
public abstract class Armour extends Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String itemName;
    @Column(name = "strength")
    private int itemStrength;
    @Column(name = "weight")
    private int itemWeight;
    @OneToOne(mappedBy = "armour", cascade = CascadeType.ALL)
    private Unit unit;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;
    public Armour(String itemName, int itemStrength, int itemWeight) {
        this.itemName = itemName;
        this.itemStrength = itemStrength;
        this.itemWeight = itemWeight;
    }

    @Override
    public void equipWeapon(Unit target) {
        System.out.println("Вы не можете одеть броню в качестве оружия");
    }

    //Метод для экипировки брони
    @Override
    public void equipArmour(Unit target) {
        int totalUnitWeight = target.getWeapon().getItemWeight() + target.getInventoryWeight(target.getInventory()) +
                target.getArmour().itemWeight;
        if (totalUnitWeight < target.getMaxWeight()) {
            if (target.getArmour() != null) {
                int defence = target.getDefence();
                 defence += target.getArmour().getItemStrength();
                System.out.println("Броня: " + target.getArmour().itemName + " экипировано" + "защита персонажа" + target.getName() +
                        " равна: " + defence);
            } else {
                System.out.println("У вашего персонажа нет брони");
            }

        } else {
            System.out.println("Слишком большой вес предметов, вы не можете столько нести");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemStrength(int itemStrength) {
        this.itemStrength = itemStrength;
    }

    public void setItemWeight(int itemWeight) {
        this.itemWeight = itemWeight;
    }

    public int getItemWeight() {
        return itemWeight;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getItemStrength() {
        return itemStrength;
    }

    public String getItemName() {
        return itemName;
    }
}
