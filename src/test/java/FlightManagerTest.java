import org.junit.Before;

public class FlightManagerTest {

    private Plane plane;
    private Flight flight;
    private Passenger passenger;
    private Passenger passenger2;

    @Before
    public void before (){
        plane = new Plane(PlaneType.GULFSTREAMG650);
        flight = new Flight(plane, "IT756", "FCO", "GLA", "09.30");
        passenger = new Passenger("Jim Halpert", 1);
        passenger2 = new Passenger("Pam Halpert", 1);
    }


}
