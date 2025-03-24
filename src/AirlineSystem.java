import java.util.ArrayList;
import java.util.Scanner;

public class AirlineSystem {
    private ArrayList<Flight> flights = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private AdminLogin adminAuth = new AdminLogin();
    private AdminManager adminManager = new AdminManager(flights, scanner);
    private ClientManager clientManager = new ClientManager(flights, scanner);

    public void start() {
        while (true) {
            System.out.println("\nWelcome to the Airline Management System");
            System.out.println("1. Admin Login");
            System.out.println("2. Client Mode");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Limpando o buffer

            switch (choice) {
                case 1:
                    adminMenu();
                    break;
                case 2:
                    clientMenu();
                    break;
                case 3:
                    System.out.println("Exiting system...");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
    private void clientMenu() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your passport number: ");
        String passportNumber = scanner.nextLine();
    
        Passenger passenger = new Passenger(name, passportNumber);
    
        while (true) {
            System.out.println("\nClient Menu");
            System.out.println("1. View Flights");
            System.out.println("2. Book Flight");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
    
            switch (choice) {
                case 1:
                    clientManager.viewFlights();
                    break;
                case 2:
                    clientManager.bookFlight(passenger);  // Pass the passenger object to bookFlight, this will book the flight and the seat.
                    break;
                case 3:
                    System.out.println("Returning to main menu...");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
    

    private void adminMenu() {
        System.out.print("Enter Admin Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        if (!adminAuth.authenticate(username, password)) {
            System.out.println("Invalid login. Returning to main menu.");
            return;
        }

        while (true) {
            System.out.println("\nAdmin Panel");
            System.out.println("1. Add Flight");
            System.out.println("2. View Flights");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    adminManager.addFlight();
                    break;
                case 2:
                    adminManager.viewFlights();
                    break;
                case 3:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    public static void main(String[] args) {
        AirlineSystem system = new AirlineSystem();
        system.start();
    }
}
