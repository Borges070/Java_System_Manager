import java.util.ArrayList;
import java.util.Scanner;

public class AdminManager {
    private ArrayList<Flight> flights;
    private Scanner scanner;

    public AdminManager(ArrayList<Flight> flights, Scanner scanner) {
        this.flights = flights;
        this.scanner = scanner;
    }

    public void addFlight() {
        System.out.print("Enter Flight Number: ");
        String flightNumber = scanner.nextLine();
        System.out.print("Enter Departure Time: ");
        String departureTime = scanner.nextLine();
        System.out.print("Enter Arrival Time: ");
        String arrivalTime = scanner.nextLine();
        System.out.print("Enter Destination: ");
        String destination = scanner.nextLine();
        System.out.print("Enter Origin: ");
        String origin = scanner.nextLine();
        System.out.print("Enter Capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine(); // Buffer cleaned

        flights.add(new DomesticFlight(flightNumber, departureTime, arrivalTime, destination, origin, capacity));
        System.out.println("Flight added successfully!");
    }

    public void viewFlights() {
        if (flights.isEmpty()) {
            System.out.println("No flights available.");
            return;
        }
        for (Flight flight : flights) {
            flight.printFlightDetails();
        }
    }
}
