import java.util.ArrayList;

public class Flight {

    private ArrayList<Passenger> passengers;
    private Plane plane;
    String flightNumber;
    String destination;
    String departureAirport;
    String departureTime;

    public Flight(Plane plane, String flightNumber, String destination, String departureAirport, String departureTime){
        this.passengers = new ArrayList<Passenger>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;

    }

    public int getPassengerCount() {
        return this.passengers.size();
    }

    public void addPassengerToFlight(Passenger passenger) {
        passengers.add(passenger);
    }

    public int getAvailableSeatCount(Plane plane) {
        int totalSeats = plane.getCapacityFromEnum();
        int bookedSeats = getPassengerCount();
        return totalSeats - bookedSeats;
    }

    public void bookPassenger(Plane plane, Passenger passenger) {
        if(getAvailableSeatCount(plane) > 0){
            addPassengerToFlight(passenger);
        }
    }
}

