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


    //for each passenger in passenger list get seat number and compare
       //     we know to stop based on passengercount


//    public void bubbleSortArray(Flight flight){
//        int length = flight.getPassengerCount();
//        boolean sorted = false;
//
//        while (!sorted) {
//            sorted = true;
//            for (int i = 0; i < length-1; i++){
//                if(flight.passengers.get(i).getSeatNumber() > flight.passengers.get(i + 1).getSeatNumber()){
////                    int lower = flight.passengers.get(i + 1).getSeatNumber();
//                    Collections.swap(flight.passengers, i, i+1);
//
//                }
//            }
//        }
//    }

    public void bubbleSortArray(Flight flight){
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



//    public void bubbleSortArray(Flight flight) {
//        int n = flight.getPassengerCount();
//        boolean sorted = false;
//        for(i = 1:n){
//            boolean swapped = false;
//        while (!sorted) {
//            sorted = true;
//            for (int i = 0; i < n-1; i++) {
//                if (flight.seatNumbers.get(i).compareTo(flight.seatNumbers.get(i + 1)) > 0) {
//                    seat = flight.seatNumbers.get(i);
//                    flight.seatNumbers.set(i, flight.seatNumbers.get(i + 1));
//                    flight.seatNumbers.set(i + 1, seat);
//                    sorted = false;
//                }
//            }
//        }
//        System.out.println(flight.seatNumbers);
//    }




//    public void bubbleSortArrayList(Flight flight) {
//        Integer seat;
//        boolean sorted = false;
//
//        while (!sorted) {
//            sorted = true;
//            for (int i = 0; i < flight.passengers.size()-1; i++) {
//                if (flight.seatNumbers.get(i).compareTo(flight.seatNumbers.get(i + 1)) > 0) {
//                    seat = flight.seatNumbers.get(i);
//                    flight.seatNumbers.set(i, flight.seatNumbers.get(i + 1));
//                    flight.seatNumbers.set(i + 1, seat);
//                    sorted = false;
//                }
//            }
//        }
//        System.out.println(flight.seatNumbers);
//    }
}
