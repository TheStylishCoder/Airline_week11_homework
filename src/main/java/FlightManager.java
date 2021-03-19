public class FlightManager {

    public int getBaggageAllowancePerPerson(Plane plane){
        int totalPlaneBaggageAllowance = plane.getTotalBaggageAllowanceForPlane();
        int planeCapacity = plane.getCapacityFromEnum();
        return totalPlaneBaggageAllowance / planeCapacity;
    }
}
