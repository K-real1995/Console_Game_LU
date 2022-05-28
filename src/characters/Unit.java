package characters;

import strategy.Strategy;
import characters.aliance.AllianceUnit;
import characters.horde.HordeUnit;
import things.Inventory;
import things.Item;
import things.armour.Armour;
import things.weapons.Weapon;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;

import static characters.UnitFabric.*;


@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@Table(name = "units")
@DiscriminatorColumn(name = "race", discriminatorType = DiscriminatorType.STRING)
public abstract class Unit implements UnitInterface, Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "hp")
    private int hp;
    @Column(name = "attack")
    private int attack;
    @Column(name = "defence")
    private int defence;
    @Column(name = "money_count")
    private int moneyCount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "weapon_id")
    private Weapon weapon;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "armour_id")
    private Armour armour;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    @Column(name = "max_weight")
    private int maxWeight;

    @Transient
    Strategy strategy;




    public Unit(String name, int hp, int attack, int defence, int moneyCount, Inventory inventory, Weapon weapon,
                Armour armour, int maxWeight){

        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.defence = defence;
        this.moneyCount = moneyCount;
        this.inventory = inventory;
        this.weapon = weapon;
        this.armour = armour;
        this.maxWeight = maxWeight;
    }

    public Unit() {
    }


//    Для двух полей выше разработать механизм прочности, когда при битвах прочность оружия и брони уменьшается.
//    В случае, когда прочность достигнет 0 эффекты которые дают предметы должны перестать работать
    public void attack(Unit target){
        int damage;

        if (weapon.getWeaponAttack() > target.armour.getItemStrength()) {
            System.out.println(target.armour.getItemName() + ": данный предмет разбит и больше вас не защищает!");
            target.defence -= target.armour.getItemStrength();
            damage = attack - target.defence;
        }

        else if (weapon.getItemStrength() < target.armour.getItemStrength()) {
            System.out.println("Ваше оружие " + weapon.getItemName() + " :cломано, атака снижена!");
            attack -= weapon.getWeaponAttack();
            damage = attack - target.defence;
        }

        else {
            damage = attack - target.defence;
        }

        if (damage > 0) {
            target.hp -= damage;
            System.out.println(name + " наносит " + damage + " урона!");
            System.out.println("Здоровье " + target.name + ": " + target.hp);
        }
        else
            System.out.println("Броня не пробита!");

        if(target.hp <= 0){
            drop(target);
        }
    }
    //Реализовать в интерфейсе юнит поле drop, которое определяет награду за победу над указанным персонажем
    public void drop(Unit target){
        inventory.add(target.weapon);
        inventory.add(target.armour);
        inventory.addAll(target.inventory);
        moneyCount += target.moneyCount;
        target.armour = null;
        target.weapon = null;
        target.inventory.clear();
        target.moneyCount = 0;
    }


    //Метод подсчитывающий общий вес инвентаря
    @Override
    public int getInventoryWeight(Inventory inventory){
        int totalInventoryWeight = 0;
        for (Item item : inventory) {
            int weight = item.itemWeight;
            totalInventoryWeight += weight;
        }
        return totalInventoryWeight;
    }


    public static LinkedList<HordeUnit> getRandomHordeArmy () {
        LinkedList<HordeUnit> hordeArmy = new LinkedList<>();
        while (hordeArmy.size() < 10) {
            hordeArmy.add((HordeUnit) getRandomOrc());
            hordeArmy.add((HordeUnit) getRandomTauren());
        }
        return hordeArmy;
    }

    public static LinkedList<AllianceUnit> getRandomAllianeceArmy () {
        LinkedList<AllianceUnit> allianceArmy = new LinkedList<>();
        while (allianceArmy.size() < 10) {
            allianceArmy.add((AllianceUnit) getRandomHuman());
            allianceArmy.add((AllianceUnit) getRandomElf());
        }
        return allianceArmy;
    }

    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    public void executeStrategy(Unit unit){
        strategy.makeUnit(unit);

    }

    @Override
    public String toString() {
        return "Unit{" +
                "id=" + id +
                ", inventory=" + inventory +
                ", name='" + name + '\'' +
                ", hp=" + hp +
                ", attack=" + attack +
                ", defence=" + defence +
                ", moneyCount=" + moneyCount +
                ", weapon=" + weapon +
                ", armour=" + armour +
                ", maxWeight=" + maxWeight +
                ", strategy=" + strategy +
                '}';
    }

    public Inventory getInventory() {
        return inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getMoneyCount() {
        return moneyCount;
    }

    public void setMoneyCount(int moneyCount) {
        this.moneyCount = moneyCount;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armour getArmour() {
        return armour;
    }
    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Strategy getStrategy() {
        return strategy;
    }
    public int getId() {
    return id;
}

    public void setId(int id) {
        this.id = id;
    }

    public void setArmour(Armour armour) {
        this.armour = armour;
    }
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
