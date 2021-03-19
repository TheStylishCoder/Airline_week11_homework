import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    private Plane plane;

    @Before
    public void before(){
        plane = new Plane(PlaneType.GULFSTREAMG650);
    }

    @Test
    public void canGetPlaneType(){
        assertEquals(PlaneType.GULFSTREAMG650, plane.getType());
    }

    @Test
    public void canGetCapacity(){
        assertEquals(3, plane.getCapacityFromEnum());
    }

    @Test
    public void canGetTotalWeightAllowanceOfPlane(){
        assertEquals(30, plane.getTotalWeightFromEnum());
    }

    @Test
    public void canGetTotalBaggageAllowanceOfPlane(){
        assertEquals(15, plane.getTotalBaggageAllowanceForPlane());
    }

}
