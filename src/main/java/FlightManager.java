import java.util.ArrayList;
import java.util.Collections;

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




    public void sortPassengersBySeatNumber(Flight flight){
        int length = flight.getPassengerCount();
        for(int i = 0; i < length; i++) {
            boolean swapped = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (flight.passengers.get(j).getSeatNumber() > flight.passengers.get(j + 1).getSeatNumber()) {
                    Collections.swap(flight.passengers, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped)
                break;

        }
        for(Passenger passenger : flight.passengers){
            System.out.println(passenger.getSeatNumber());
        }
    }

    public boolean findPassengerBySeatNumber(Flight flight, int seatNumber){
        sortPassengersBySeatNumber(flight);
        int length = flight.getPassengerCount();

        int l = 0, r = length - 1;
        while (l <=r){
            int m = l + (r-1) / 2;
            if(flight.passengers.get(m).getSeatNumber() == seatNumber) {
                Passenger foundPassenger = flight.passengers.get(m);
                System.out.println(foundPassenger.getSeatNumber());
                return true;
            }
            if(flight.passengers.get(m).getSeatNumber() < seatNumber){
                l = m + 1;
            } else {
                r = m - 1;
            }


        }
        l = length;
        return false;

    }








}
