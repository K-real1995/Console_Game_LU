package things;

import characters.Unit;
import things.armour.Armour;
import things.weapons.Weapon;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

//Класс инвентарь с настройками hibernate для взаимодействия с базой данных, таблицей inventory
@Entity
@Table(name = "inventory")
public class Inventory extends ArrayList<Item> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventory")
    private List<Weapon> weapons;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventory")
    private List<Armour> armours;
    @OneToOne(mappedBy = "inventory", cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    private Unit unit;


    public Inventory(String name){
        this.name = name;
    }

    public void addWeaponToInventory(Weapon weapon) {
        if (weapons == null) {
            weapons = new ArrayList<>();
         }
        weapons.add(weapon);
        weapon.setInventory(this);
    }

    public void addArmourToInventory(Armour armour) {
        if (armours == null) {
            armours = new ArrayList<>();
         }
        armours.add(armour);
        armour.setInventory(this);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
