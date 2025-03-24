// Purpose: International flight class that extends the flight class.
class Internationalflight extends Flight {

    public Internationalflight(String flightNumber, String departureTime, String arrivalTime, String destination, String Origin, int capacity) {
        super(flightNumber, departureTime, arrivalTime, destination, Origin, capacity);
        
    }

    @Override
    public void printFlightDetails() {
        System.out.println("Flight " + getFlightNumber() + " to " + getDestination() + " departing from " + getOrigin() + " at " + getDepartureTime() + " and arriving at " + getArrivaltime() + ".");
            }
        
            

   
}
