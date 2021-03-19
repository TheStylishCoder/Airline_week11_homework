import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    private Passenger passenger;

    @Before
    public void before(){
        passenger = new Passenger("Jim Halpert", 1);
    }

    @Test
    public void passengerHasName(){
        assertEquals("Jim Halpert", passenger.getName());
    }

    @Test
    public void canGetPassengerBagCount(){
        assertEquals(1, passenger.getNumberOfBags());
    }
}

