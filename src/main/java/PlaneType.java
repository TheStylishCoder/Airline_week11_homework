public enum PlaneType {
    BOEING747(10, 200),
    AIRBUSA380(100, 2000),
    GULFSTREAMG650(3, 60);

    private final int capacity;
    private final int totalWeight;

    PlaneType(int capacity, int totalWeight){
        this.capacity = capacity;
        this.totalWeight = totalWeight;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public int getTotalWeight(){
        return this.totalWeight;
    }

}
