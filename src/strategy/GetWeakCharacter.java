package strategy;

import characters.Unit;
import things.Inventory;
import things.armour.BreastАrmour;
import things.weapons.MeeleWeapon;
import java.util.Random;

import static things.ItemFabric.getRandomBreastArmour;
import static things.ItemFabric.getRandomMeleeWeapon;


public class GetWeakCharacter implements Strategy {
    //Метод создающий слабого юнита
    @Override
    public void makeUnit(Unit unit){
        String[] name = {"Джоачин", "Корзур", "Ороказ", "Лео", "Азур", "Гогуар", "Тегдрохар", "Чорногерс", "Дхиелтаетх",
                "Иакушимару", "Цекук", "Алис", "Мирнеросс", "Корин", "Бригдег", "Васцуикс", "Канбаиаши", "Эббет"};

        Random num1 = new Random();
        int result = num1.nextInt(0, name.length);
        String unitName = name[result];
        Random num2 = new Random();
        int randomHp = num2.nextInt(1, 51);
        Random num3 = new Random();
        int randomAttack = num3.nextInt(1, 151);
        Random num4 = new Random();
        int randomDefence = num4.nextInt(1, 101);
        Random num5 = new Random();
        int randomMoneyCount = num5.nextInt(1, 501);
        Random num6 = new Random();
        MeeleWeapon weapon = getRandomMeleeWeapon();
        BreastАrmour armor = getRandomBreastArmour();
        int randomMaxWeight = num6.nextInt(1, 1501);

        String[] inventoryNames = {"Рюкзачок", "Сумка", "Багаж", "Cаквояж"};
        Inventory inventory = new Inventory(inventoryNames[new Random().nextInt(inventoryNames.length)]);

        unit.setName(unitName);
        unit.setHp(randomHp);
        unit.setAttack(randomAttack);
        unit.setDefence(randomDefence);
        unit.setMoneyCount(randomMoneyCount);
        unit.setInventory(inventory);
        unit.setWeapon(weapon);
        unit.setArmour(armor);
        unit.setMaxWeight(randomMaxWeight);


    }
}
