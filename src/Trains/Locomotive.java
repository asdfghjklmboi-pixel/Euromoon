package Trains;

import basis.constants.TravelClass;

/**
 * abstract base class for all locomotives handling models and seats capacity
 */
public abstract class Locomotive {
    private final String model;
    private final int maxWagons;

    private static final int FIRST_CLASS_SEATS = 20;
    private static final int SECOND_CLASS_SEATS = 60;

    public Locomotive(String model, int maxWagons){
        this.model = model;
        this.maxWagons = maxWagons;
    }

    public int getMaxWagons(){
        return maxWagons;
    }
    public String getModel() {
        return model;
    }

    /**
     *
     * @param travelClass check capacity of the locomotive itself
     * @return number of seats
     */
    public int getLocomotiveCapacity(TravelClass travelClass) {
        if (travelClass == TravelClass.FIRST) return FIRST_CLASS_SEATS;
        return SECOND_CLASS_SEATS;
    }
}
