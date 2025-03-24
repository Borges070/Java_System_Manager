
import java.util.HashMap;

public class AdminLogin {
    private HashMap<String, String> adminAccounts;

    public AdminLogin() {
        adminAccounts = new HashMap<>();
        adminAccounts.put("Borges", "password0070"); // Add admin accounts
    }

    public boolean authenticate(String username, String password) {
        return adminAccounts.containsKey(username) && adminAccounts.get(username).equals(password);
    }
}


