import java.util.ArrayList;
import java.util.Scanner;

public class ClientManager {
    private ArrayList<Flight> flights;
    private Scanner scanner;

    public ClientManager(ArrayList<Flight> flights, Scanner scanner) {
        this.flights = flights;
        this.scanner = scanner;
    }

    public void viewFlights() {
        if (flights.isEmpty()) {
            System.out.println("No flights available.");
            return;
        }
        System.out.println("\nAvailable Flights:");
        for (int i = 0; i < flights.size(); i++) {
            System.out.println((i + 1) + ". " + flights.get(i).getFlightNumber() + " to " + flights.get(i).getDestination());
        }
    }

    public void bookFlight(Passenger passenger) {
        if (flights.isEmpty()) {
            System.out.println("No available flights to book.");
            return;
        }
    
        // Show available flights
        System.out.println("Available Flights:");
        for (int i = 0; i < flights.size(); i++) {
            System.out.println((i + 1) + ". Flight " + flights.get(i).getFlightNumber() + " to " + flights.get(i).getDestination());
        }
    
        // Let the user choose a flight
        System.out.print("Choose a flight by number: ");
        int flightChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        if (flightChoice < 1 || flightChoice > flights.size()) {
            System.out.println("Invalid flight choice.");
            return;
        }
    
        Flight selectedFlight = flights.get(flightChoice - 1);
    
        // Display available seats for the selected flight
        selectedFlight.displaySeats();
    
        // Ask the user to select a seat
        System.out.print("Enter seat number to reserve: ");
        int seatNum = scanner.nextInt();
    
        // Attempt to reserve the seat
        if (selectedFlight.reserveSeat(seatNum)) {
            // Seat reservation successful, booking flight
            System.out.println(passenger.getName() + " successfully booked Flight " + selectedFlight.getFlightNumber() + "from" + selectedFlight.getOrigin() + "to " + selectedFlight.getDestination() + " with seat number " + seatNum + ".");
        } else {
            System.out.println("Seat reservation failed. Please try again.");
        }
    }
    
}
