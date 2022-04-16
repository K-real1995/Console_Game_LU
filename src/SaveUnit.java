import characters.Unit;
import java.io.*;

public class SaveUnit {

    public static void saveUnit(Unit target) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("unit.txt"));
        out.writeObject(target);
    }

    public static Unit loadUnits() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("unit.txt"));
        return (Unit) in.readObject();
    }

}
