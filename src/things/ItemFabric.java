package things;

import things.armour.BreastАrmour;
import things.weapons.MagicWeapon;
import things.weapons.MeeleWeapon;
import things.weapons.RangedWeapon;

import java.util.Random;

public class ItemFabric{


    public static BreastАrmour getRandomBreastArmour(){
        return new BreastАrmour(getRandomBreastAmrourName(), getRandomItemStrength(),
                getRandomDexterity(), getRandomItemWeight());
    }

    public static RangedWeapon getRandomRangedWeapon(){
        return new RangedWeapon(getRandomRangedWeaponName(), getRandomWeaponAttack(), getRandomItemStrength(),
                getRandomFiringDistance(), getRandomItemWeight());
    }

    public static MeeleWeapon getRandomMeleeWeapon(){
        return new MeeleWeapon(getRandomMeleeWeaponName(), getRandomWeaponAttack(), getRandomItemStrength(),
                getRandomWeaponSpeed(), getRandomItemWeight());
    }


    public static MagicWeapon getRandomMagicWeapon(){
        return new MagicWeapon(getRandomMagicWeaponName(), getRandomWeaponAttack(), getRandomItemStrength(),
                getRandomWeaponMana(), getRandomItemWeight());
    }

    public static String getRandomMeleeWeaponName(){
        String[] names = {"Меч", "Cабля", "Нож", "Дубина", "Топор", "Булава","Кистень","Молот", "Пика", "Алебарда"};

        return names[new Random().nextInt(names.length)];
    }

    public static String getRandomMagicWeaponName(){
        String[] names = {"Посох", "Жезл", "Cкипетр", "Призма", "Волшебная палочка", "Арфа", "Cфера"};

        return names[new Random().nextInt(names.length)];
    }

    public static String getRandomRangedWeaponName(){
        String[] names = {"Лук", "Арбалет", "Копьё", "Бумеранг", "Болас", "Томагавк", "Мушкет","Метательный нож"};

        return names[new Random().nextInt(names.length)];
    }

    public static String getRandomBreastAmrourName(){
        String[] names = {"Кольчуга", "Чешуя", "Бригантина", "Ламелляр", "Латы"};

        return names[new Random().nextInt(names.length)];
    }

    public static int getRandomItemStrength(){
        return new Random().nextInt(1,51);
    }

    public static int getRandomItemWeight(){
        return new Random().nextInt(1,201);
    }

    public static int getRandomWeaponSpeed(){
        return new Random().nextInt(1,101);
    }

    public static int getRandomWeaponAttack(){
        return new Random().nextInt(1,151);
    }

    public static int getRandomWeaponMana(){
        return new Random().nextInt(1,51);
    }

    public static int getRandomFiringDistance(){
        return new Random().nextInt(1,1000);
    }

    public static int getRandomDexterity(){
        return new Random().nextInt(1,201);
    }


}
