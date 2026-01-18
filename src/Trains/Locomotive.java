package Trains;

import basis.constants.TravelClass;

public abstract class Locomotive {
    private final int maxPassengers = 80;
    private final int maxWagons;
    private final TravelClass travelClass;

    public Locomotive(int maxWagons, TravelClass travelClass){
        this.maxWagons = maxWagons;
        this.travelClass = travelClass;
    }

    public int getMaxWagons(){
        return maxWagons;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public TravelClass getTravelClass(){
        return travelClass;

    }
}
