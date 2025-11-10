import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // Master Password Check
        System.out.print("Enter Master Password: ");
        String input = sc.nextLine();
        if (!input.equals("yourMasterPassword")) {
            System.out.println("Access Denied.");
            return;
        }

        PasswordManager manager = new PasswordManager();

        while (true) {
            System.out.println("\n1. Add New Password\n2. View Passwords\n3. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // consume leftover

            if (choice == 1) {
                System.out.print("Enter Service Name: ");
                String service = sc.nextLine();
                System.out.print("Enter Password: ");
                String password = sc.nextLine();
                manager.addPassword(service, password);
            } else if (choice == 2) {
                manager.viewPasswords();
            } else {
                break;
            }
        }
    }
}
