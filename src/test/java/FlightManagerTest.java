import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FlightManagerTest {

    private FlightManager flightManager;
    private Plane plane;
    private Plane plane2;
    private Flight flight;
    private Passenger passenger;
    private Passenger passenger2;
    private Passenger passenger3;
    private Passenger passenger4;

    @Before
    public void before (){
        flightManager = new FlightManager();
        plane = new Plane(PlaneType.GULFSTREAMG650);
        plane2 = new Plane(PlaneType.BOEING747);
        flight = new Flight(plane, "IT756", "FCO", "GLA");
        passenger = new Passenger("Jim Halpert", 1);
        passenger2 = new Passenger("Pam Halpert", 1);
        passenger3 = new Passenger("Michael Scott", 1);
        passenger4 = new Passenger("Holly Flax", 1);
    }

    @Test
    public void canGetBaggageAllowancePerPerson(){
        assertEquals(10, flightManager.getBaggageAllowancePerPerson(plane));
    }

    @Test
    public void totalPassengerBagWeightStartsAt0(){
        assertEquals(0, flightManager.getTotalPassengerBagWeightBooked(flight, plane));
    }

    @Test
    public void canGetTotalPassengerBagWeightBooked(){
        flight.bookPassenger(plane, passenger, flight);
        flight.bookPassenger(plane, passenger2, flight);
        assertEquals(20, flightManager.getTotalPassengerBagWeightBooked(flight, plane));
    }

    @Test
    public void canGetTotalPassengerBagWeightRemaining(){
        flight.bookPassenger(plane, passenger, flight);
        assertEquals(20, flightManager.getTotalPassengerBagWeightRemaining(plane, flight));
    }

    @Test
    public void canSortPassengersBySeatNumber(){
        flight.populateSeatNumberList(plane2);
        flight.shuffleSeatNumberList();
        flight.bookPassengerOntoFlight(plane2, passenger, flight);
        System.out.println(passenger.getSeatNumber());
        flight.bookPassengerOntoFlight(plane2, passenger2, flight);
        System.out.println(passenger2.getSeatNumber());
        flight.bookPassengerOntoFlight(plane2, passenger3, flight);
        System.out.println(passenger3.getSeatNumber());
        flight.bookPassengerOntoFlight(plane2, passenger4, flight);
        System.out.println(passenger4.getSeatNumber());
        flightManager.sortPassengersBySeatNumber(flight);
        assertEquals(4, flight.getPassengerCount());
        assertTrue(flight.passengers.get(0).getSeatNumber() < flight.passengers.get(1).getSeatNumber() && flight.passengers.get(1).getSeatNumber() < flight.passengers.get(2).getSeatNumber());
    }

    @Test
    public void canFindPassengerBySeatNumber(){
        flight.populateSeatNumberList(plane);
        flight.shuffleSeatNumberList();
        flight.bookPassengerOntoFlight(plane, passenger, flight);
        flight.bookPassengerOntoFlight(plane, passenger2, flight);
        flight.bookPassengerOntoFlight(plane, passenger3, flight);
        assertEquals(true, flightManager.findPassengerBySeatNumber(flight, 1));
    }

    @Test
    public void cannotFindPassengerBySeatNumberBecauseSeatNumberDoesNotExist(){
        flight.populateSeatNumberList(plane);
        flight.shuffleSeatNumberList();
        flight.bookPassengerOntoFlight(plane, passenger, flight);
        flight.bookPassengerOntoFlight(plane, passenger2, flight);
        flight.bookPassengerOntoFlight(plane, passenger3, flight);
        assertEquals(false, flightManager.findPassengerBySeatNumber(flight, 4));
    }


}
