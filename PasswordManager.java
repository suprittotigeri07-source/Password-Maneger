import java.util.HashMap;

public class PasswordManager {
    private HashMap<String, String> passwordMap;

    public PasswordManager() throws Exception {
        // Load existing passwords when object is created
        passwordMap = StorageUtil.readFromFile();
    }

    public void addPassword(String service, String password) throws Exception {
        String encryptedPassword = EncryptionUtil.encrypt(password);
        passwordMap.put(service, encryptedPassword);
        StorageUtil.saveToFile(passwordMap);
    }

    public void viewPasswords() throws Exception {
        if (passwordMap.isEmpty()) {
            System.out.println("No passwords stored yet.");
            return;
        }

        for (String service : passwordMap.keySet()) {
            String encryptedPassword = passwordMap.get(service);
            String decryptedPassword = EncryptionUtil.decrypt(encryptedPassword);
            System.out.println(service + " : " + decryptedPassword);
        }
    }
}
