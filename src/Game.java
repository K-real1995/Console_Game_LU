import Strategy.GetStrongCharacter;
import Strategy.GetWeakCharacter;
import characters.Unit;

import java.io.IOException;


public class Game {
    public static void main(String[] args) {
        //Cоздаем пустого юнита и генерируем его через класс GetStrongUnit по принципу паттерна стратегия
        Unit strongUnit = new Unit();
        strongUnit.setStrategy(new GetStrongCharacter());
        strongUnit.executeStrategy(strongUnit);
        System.out.println(strongUnit);
        //Cоздаем пустого юнита и генерируем его через класс GetWeakUnit по принципу паттерна стратегия
        Unit weakUnit = new Unit();
        weakUnit.setStrategy(new GetWeakCharacter());
        weakUnit.executeStrategy(weakUnit);
        System.out.println(weakUnit);





    }
}
