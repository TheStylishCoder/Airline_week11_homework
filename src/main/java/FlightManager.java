public class FlightManager {

    public int getBaggageAllowancePerPerson(Plane plane){
        int totalPlaneBaggageAllowance = plane.getTotalBaggageAllowanceForPlane();
        int planeCapacity = plane.getCapacityFromEnum();
        return totalPlaneBaggageAllowance / planeCapacity;
    }

    public int getTotalPassengerBagWeightBooked(Flight flight, Plane plane){
        return flight.getPassengerCount() * getBaggageAllowancePerPerson(plane);
    }

    public int getTotalPassengerBagWeightRemaining(Plane plane, Flight flight) {
        return plane.getTotalBaggageAllowanceForPlane() - getTotalPassengerBagWeightBooked(flight, plane);
    }
}
