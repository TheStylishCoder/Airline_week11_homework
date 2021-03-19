import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    private  FlightManager flightManager;
    private Plane plane;
    private Flight flight;
    private Passenger passenger;
    private Passenger passenger2;

    @Before
    public void before (){
        flightManager = new FlightManager();
        plane = new Plane(PlaneType.GULFSTREAMG650);
        flight = new Flight(plane, "IT756", "FCO", "GLA", "09.30");
        passenger = new Passenger("Jim Halpert", 1);
        passenger2 = new Passenger("Pam Halpert", 1);
    }

    @Test
    public void canGetBaggageAllowancePerPerson(){
        assertEquals(10, flightManager.getBaggageAllowancePerPerson(plane));
    }


}
