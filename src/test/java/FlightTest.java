import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class FlightTest {

    private Flight flight;
    private Plane plane;
    private Plane plane2;
    private Passenger passenger;
    private Passenger passenger2;
    private Passenger passenger3;
    private Passenger passenger4;

    @Before
    public void before(){
        plane = new Plane(PlaneType.GULFSTREAMG650);
        plane2 = new Plane(PlaneType.BOEING747);
        flight = new Flight(plane, "IT756", "FCO", "GLA");
        passenger = new Passenger("Jim Halpert", 1);
        passenger2 = new Passenger("Pam Halpert", 1);
        passenger3 = new Passenger("Michael Scott", 1);
        passenger4 = new Passenger("Holly Flax", 1);
    }

    @Test
    public void checkPassengersListStartsEmpty(){
        assertEquals(0, flight.getPassengerCount());
    }

    @Test
    public void canAddPassengerToFlight(){
        flight.addPassengerToFlight(passenger);
        assertEquals(1, flight.getPassengerCount());
    }

    @Test
    public void canGetAvailableSeatCount(){
        flight.addPassengerToFlight(passenger);
        assertEquals(2, flight.getAvailableSeatCount(plane));
    }

    @Test
    public void canBookPassengerAsThereIsSpaceOnFlight(){
        flight.bookPassenger(plane, passenger, flight);
        assertEquals(1, flight.getPassengerCount());
        assertEquals(flight, passenger.getFlight());
    }

    @Test
    public void cannotBookFourthPassengerAsNoSpaceOnFlight(){
        flight.bookPassenger(plane, passenger, flight);
        flight.bookPassenger(plane, passenger2, flight);
        flight.bookPassenger(plane, passenger3, flight);
        flight.bookPassenger(plane, passenger4, flight);
        assertEquals(3, flight.getPassengerCount());
        assertEquals(flight, passenger.getFlight());
        assertEquals(flight, passenger2.getFlight());
        assertEquals(flight, passenger3.getFlight());

    }

    @Test
    public void date(){
        flight.canGetDate();
    }

    @Test
    public void canGetFlightNumber(){
        assertEquals("IT756", flight.getFlightNumber());
    }

    @Test
    public void canPopulateSetNumbersCorrectly(){
        flight.populateSeatNumberList(plane2);
        assertEquals(10, flight.getSeatNumberCount());
    }

    @Test
    public void canSelectRandomSeatNumber(){
        flight.populateSeatNumberList(plane2);
        flight.shuffleSeatNumberList();
        flight.assignRandomSeatToPassenger(passenger);
        assertEquals(9, flight.getSeatNumberCount());
    }

    @Test
    public void canAssignRandomSeatToPassenger(){
        flight.populateSeatNumberList(plane2);
        flight.assignRandomSeatToPassenger(passenger);
        assertEquals(9, flight.getSeatNumberCount());
    }

    @Test
    public void canAssignRandomSeatsToMultiplePassengers(){
        flight.populateSeatNumberList(plane2);
        flight.shuffleSeatNumberList();
        flight.assignRandomSeatToPassenger(passenger);
        System.out.println(passenger.getSeatNumber());
        flight.assignRandomSeatToPassenger(passenger2);
        System.out.println(passenger2.getSeatNumber());
        flight.assignRandomSeatToPassenger(passenger3);
        System.out.println(passenger3.getSeatNumber());
        flight.assignRandomSeatToPassenger(passenger4);
        System.out.println(passenger4.getSeatNumber());
        System.out.println(flight.seatNumbers);
        assertEquals(6, flight.getSeatNumberCount());
    }

}
