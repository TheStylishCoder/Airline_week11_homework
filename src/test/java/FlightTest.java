import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    Flight flight;
    Plane plane;
    Passenger passenger;

    @Before
    public void before(){
        plane = new Plane(PlaneType.GULFSTREAMG650);
        flight = new Flight(plane, "IT756", "FCO", "GLA", "09.30");
        passenger = new Passenger("Jim Halpert", 1);
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
}
