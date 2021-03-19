import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    Flight flight;
    Plane plane;
    Passenger passenger;
    Passenger passenger2;
    Passenger passenger3;
    Passenger passenger4;

    @Before
    public void before(){
        plane = new Plane(PlaneType.GULFSTREAMG650);
        flight = new Flight(plane, "IT756", "FCO", "GLA", "09.30");
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
        flight.bookPassenger(plane, passenger);
        assertEquals(1, flight.getPassengerCount());
    }

    @Test
    public void cannotBookFourthPassengerAsNoSpaceOnFlight(){
        flight.bookPassenger(plane, passenger);
        flight.bookPassenger(plane, passenger2);
        flight.bookPassenger(plane, passenger3);
        flight.bookPassenger(plane, passenger4);
        assertEquals(3, flight.getPassengerCount());
    }
}
