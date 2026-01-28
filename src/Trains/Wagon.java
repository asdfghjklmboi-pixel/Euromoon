package Trains;

import basis.constants.TravelClass;

/**
 * train wagon with a set capacity and travel class
 */
public class Wagon {
    private final int capacity;
    private final TravelClass travelClass;

    /**
     *
     * @param capacity capacity of the wagon
     * @param travelClass first or second class wagon
     */
    public Wagon(int capacity, TravelClass travelClass){
        this.capacity = capacity;
        this.travelClass = travelClass;
    }

    public int getCapacity() {
        return capacity;
    }
    public TravelClass getTravelClass() {
        return travelClass;
    }
    @Override
    public String toString() {
        return travelClass + " class wagon with " + capacity + " seats";
    }
}
