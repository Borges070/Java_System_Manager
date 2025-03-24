class DomesticFlight extends Flight {
    

    public DomesticFlight(String flightNumber, String departureTime, String arrivalTime, String destination, String origin, int capacity) {
        super(flightNumber, departureTime, arrivalTime, destination, origin, capacity);
        
    }

    @Override
    public void printFlightDetails() {
        System.out.println("Domestic Flight Details: ");
        System.out.println("Flight Number: " + getFlightNumber());
        System.out.println("Departure Time: " + getDepartureTime());
        System.out.println("Arrival Time: " + getArrivaltime());
        System.out.println("Origin: " + getOrigin());
        System.out.println("Destination: " + getDestination());
        System.out.println("Capacity: " + getCapacity());
    }
}