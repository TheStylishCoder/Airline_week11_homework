public enum PlaneType {
    BOEING747(10, 60),
    AIRBUSA380(100, 700),
    GULFSTREAMG650(3, 30);

    private final int capacity;
    private final int totalWeight;

    PlaneType(int capacity, int totalWeight){
        this.capacity = capacity;
        this.totalWeight = totalWeight;
    }

}
