import java.util.ArrayList;
import java.util.Date;

public class Flight {

    private ArrayList<Passenger> passengers;
    private Plane plane;
    String flightNumber;
    String destination;
    String departureAirport;
    Date departureTime;

    public Flight(Plane plane, String flightNumber, String destination, String departureAirport){
        this.passengers = new ArrayList<Passenger>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.departureTime = new Date();

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

    public void assignFlightToPassenger(Passenger passenger, Flight flight){
        passenger.setFlight(flight);
    }

    public void bookPassenger(Plane plane, Passenger passenger, Flight flight) {
        if(getAvailableSeatCount(plane) > 0){
            addPassengerToFlight(passenger);
            passenger.setFlight(flight);
        }
    }

    public void canGetDate(){
        System.out.println(this.departureTime);
    }

    public String getFlightNumber(){
        return this.flightNumber;
    }


}

