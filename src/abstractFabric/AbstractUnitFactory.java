package abstractFabric;

import characters.aliance.Human;
import characters.aliance.NightElf;
import characters.horde.Orc;
import characters.horde.Tauren;

public interface AbstractUnitFactory {
    Human getHuman();
    Orc getOrc();
    NightElf getNightElf();
    Tauren getTauren();


}
