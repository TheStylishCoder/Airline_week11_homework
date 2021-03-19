public class Passenger {

    private String name;
    private int numberOfBags;
    private Flight flight;


    public Passenger(String name, int numberOfBags) {
        this.name = name;
        this.numberOfBags = numberOfBags;
        this.flight = new Flight(null, "", "", "");
    }

    public String getName() {
        return this.name;
    }

    public int getNumberOfBags() {
        return numberOfBags;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Flight getFlight() {
        return flight;
    }
}
