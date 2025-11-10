import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class StorageUtil {
    private static final String FILE_NAME = "passwords.dat";

    public static void saveToFile(HashMap<String, String> passwordMap) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
        oos.writeObject(passwordMap);
        oos.close();
    }

    public static HashMap<String, String> readFromFile() throws IOException, ClassNotFoundException {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return new HashMap<>();
        }
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME));
        HashMap<String, String> passwordMap = (HashMap<String, String>) ois.readObject();
        ois.close();
        return passwordMap;
    }
}
