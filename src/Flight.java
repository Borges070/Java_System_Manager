// Purpose: Abstract class for Flight objects
abstract class Flight {
    private String flightNumber;
    private String departureTime;
    private String arrivalTime;
    private String origin;
    private String destination;
    private int capacity;
    private boolean[] seats; // Seat availability array

    public Flight(String flightNumber, String departureTime, String arrivalTime, String destination, String origin, int capacity) {
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.origin = origin;
        this.destination = destination;
        this.capacity = capacity;
        this.seats = new boolean[capacity]; // All seats start as available (false)

    }

    public abstract void printFlightDetails();
    //Getters (Check permissions on each case)
    public String getDestination() {
        return destination;
    }
    public String getOrigin() {
        return origin;
    }
    public String getDepartureTime() {
        return departureTime;
    }
    public String getArrivaltime() {
        return arrivalTime;
    }
    public String getFlightNumber() {
        return flightNumber;
    }
    public int getCapacity() {
        return capacity;
    }
    
    //Setters (for admins use)

    public void setDestination(String destination) {
        this.destination = destination;
    }
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
    public void setArrivaltime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
     // Method to reserve a seat (CLIENT VIEW)
     public boolean reserveSeat(int seatNum) {
        if (seatNum < 1 || seatNum > capacity) {
            System.out.println("Invalid seat number.");
            return false;
        }
        if (!seats[seatNum - 1]) {
            seats[seatNum - 1] = true;
            System.out.println("Seat " + seatNum + " reserved successfully.");
            return true;
        } else {
            System.out.println("Sorry, seat " + seatNum + " is already taken.");
            return false;
        }
    }

    // Display available seats (CLIENT VIEW)
    public void displaySeats() {
        System.out.println("Seat Availability for Flight " + flightNumber + ":");
        for (int i = 0; i < seats.length; i++) {
            System.out.println("Seat " + (i + 1) + ": " + (seats[i] ? "Reserved" : "Available"));
        }
    }

}
