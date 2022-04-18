import abstractFabric.AbstractUnitFactory;
import abstractFabric.AllUnitFactory;
import characters.aliance.Human;
import characters.aliance.NightElf;
import characters.horde.Orc;
import characters.horde.Tauren;
import strategy.GetStrongCharacter;
import strategy.GetWeakCharacter;
import characters.Unit;


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

        //Cоздаем персонажей по шаблону абстрактной фабрики
        AbstractUnitFactory unitFactory = new AllUnitFactory();

        Human humanUnit = unitFactory.getHuman();
        NightElf nightElfUnit = unitFactory.getNightElf();
        Orc orcUnit = unitFactory.getOrc();
        Tauren taurenUnit = unitFactory.getTauren();


    }
}
