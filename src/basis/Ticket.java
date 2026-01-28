package basis;

import basis.Person_hierarchy.Passenger;
import basis.constants.TravelClass;

public class Ticket {
    private final Passenger passenger;
    private final TravelClass travelClass;
    private final Trip trip;

    public Ticket(Passenger passenger, Trip trip, TravelClass travelClass){
        this.passenger = passenger;
        this.travelClass = travelClass;
        this.trip = trip;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public TravelClass getTravelClass() {

        return travelClass;
    }
@Override
public String toString(){
        return travelClass + " Class Ticket: " + passenger.getFirstName();
}}
