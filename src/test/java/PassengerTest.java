import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    private Passenger passenger;
    private Plane plane;
    private Flight flight;


    @Before
    public void before(){
        passenger = new Passenger("Jim Halpert", 1);
        plane = new Plane(PlaneType.GULFSTREAMG650);
        flight = new Flight(plane, "IT756", "FCO", "GLA");
    }

    @Test
    public void passengerHasName(){
        assertEquals("Jim Halpert", passenger.getName());
    }

    @Test
    public void canGetPassengerBagCount(){
        assertEquals(1, passenger.getNumberOfBags());
    }

    @Test
    public void canGetFlight(){
        flight.assignFlightToPassenger(passenger, flight);
        assertEquals(flight, passenger.getFlight());

    }
}

