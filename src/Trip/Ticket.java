package Trip;

import basis.Person_hierarchy.Passenger;
import basis.constants.TravelClass;

public class Ticket {
    private final Passenger boughtBy;
    private final TravelClass travelClass;
    private final Trip trip;

    public Ticket(Passenger passenger, Trip trip, TravelClass travelClass){
        this.boughtBy = passenger;
        this.travelClass = travelClass;
        this.trip = trip;
    }

    public Passenger getBoughtBy() {
        return boughtBy;
    }

    public TravelClass getTravelClass() {

        return travelClass;
    }
    public Trip getTrip(){
        return trip;
    }
}
