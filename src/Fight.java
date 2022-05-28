import characters.aliance.AllianceUnit;
import characters.horde.HordeUnit;

import java.util.LinkedList;
import java.util.Random;

public class Fight {

    //Метод для организации боя между двумя армиями
    public static String Fight(LinkedList<HordeUnit> arg1, LinkedList<AllianceUnit> arg2) {
        do {
            HordeUnit randomHordeFighter = arg1.get(new Random().nextInt(0, arg1.size()));
            AllianceUnit randomAllianceFighter = arg2.get(new Random().nextInt(0, arg2.size()));
            randomHordeFighter.attack(randomAllianceFighter);
            if (randomAllianceFighter.getHp() <= 0) {
                System.out.println(randomAllianceFighter.getName() + " Мертв");
                arg2.remove(randomAllianceFighter);
            }
            randomAllianceFighter.attack(randomHordeFighter);
            if (randomHordeFighter.getHp() <= 0) {
                System.out.println(randomHordeFighter.getName() + " Мертв");
                arg1.remove(randomHordeFighter);
            }
        }
        while (arg1.size() >= 1 & arg2.size() >= 1);
        if (arg1.size() > arg2.size()) {
            return "Победила Орда";
        } else if (arg2.size() > arg1.size()) {
            return "Победил Альянс";
        }
        else return "Ничья";
    }
}

