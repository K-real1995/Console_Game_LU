//Создать отдельный класс под оружие, добавив ему набор параметров и передавать его его нашим юнитам
package things.weapons;

import characters.Unit;
import things.Inventory;
import things.Item;

import javax.persistence.*;
//Класс оружия с настройками hibernate для взаимодействия с базой данных, таблицей weapon
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "weapons")
public abstract class Weapon extends Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "attack")
    private int weaponAttack;

    @Column(name = "name")
    private String itemName;

    @Column(name = "strength")
    private int itemStrength;

    @Column(name = "weight")
    private int itemWeight;


    @OneToOne(mappedBy = "weapon", cascade = CascadeType.ALL)
    private Unit unit;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;


    public Weapon(String itemName, int weaponAttack, int itemStrength, int itemWeight){
        this.itemName = itemName;
        this.itemStrength = itemStrength;
        this.itemWeight = itemWeight;
        this.weaponAttack = weaponAttack;
    }

    @Override
    public void equipArmour(Unit target){
        System.out.println("Вы не можете одеть оружие в качестве брони");
    }

    @Override
    public void equipWeapon(Unit target) {
        int totalUnitWeight = target.getWeapon().itemWeight + target.getInventoryWeight(target.getInventory()) +
                target.getArmour().getItemWeight();
        if (totalUnitWeight < target.getMaxWeight()) {
            if (target.getWeapon() != null) {
                int attack = target.getAttack();
                attack += target.getWeapon().weaponAttack;
                System.out.println("Оружие: " + target.getWeapon().itemName + " экипировано " + "атака персонажа " + target.getName() +
                        " равна: " + attack);
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

    public int getItemStrength() {
        return itemStrength;
    }

    public String getItemName() {
        return itemName;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getItemWeight() {
        return itemWeight;
    }
}
