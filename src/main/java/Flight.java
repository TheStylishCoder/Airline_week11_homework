import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Flight {

    ArrayList<Passenger> passengers;
    private Plane plane;
    private String flightNumber;
    private String destination;
    private String departureAirport;
    ArrayList<Integer> seatNumbers;
    private Date departureTime;


    public Flight(Plane plane, String flightNumber, String destination, String departureAirport){
        this.passengers = new ArrayList<Passenger>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.seatNumbers = new ArrayList<Integer>();
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

    public ArrayList<Integer> getSeatNumbers() {
        return seatNumbers;
    }

    public void populateSeatNumberList(Plane plane){
        int totalSeats = plane.getCapacityFromEnum();
        for(int currentSeatNumber = 1 ; currentSeatNumber  <= totalSeats; currentSeatNumber ++) {
            seatNumbers.add(currentSeatNumber);
        }
        System.out.println(seatNumbers);

    }

    public int getSeatNumberCount(){
        return this.seatNumbers.size();
    }


    public void shuffleSeatNumberList(){
        Collections.shuffle(seatNumbers);
        System.out.println(seatNumbers);
    }

    public Integer removeSeatFromSeatNumbersList(){
        return this.seatNumbers.remove(0);
    }

    public void assignRandomSeatToPassenger(Passenger passenger){
        int seat = removeSeatFromSeatNumbersList();
        passenger.setSeatNumber(seat);
    }

    public void bookPassengerOntoFlight(Plane plane, Passenger passenger, Flight flight) {
        if(getAvailableSeatCount(plane) > 0){
            addPassengerToFlight(passenger);
            passenger.setFlight(flight);
            assignRandomSeatToPassenger(passenger);
        }
    }







}

