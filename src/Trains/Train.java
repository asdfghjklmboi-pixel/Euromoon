package Trains;

import Trip.Ticket;
import basis.constants.TravelClass;

import java.util.ArrayList;
import java.util.List;

public class Train {
    private final Locomotive locomotive;
    private final List<Wagons> wagons = new ArrayList<>();
    private final List<Ticket> tickets = new ArrayList<>();

public Train (Locomotive locomotive){
    this.locomotive = locomotive;
}
public boolean canAddWagon(){
    return wagons.size() < locomotive.getMaxWagons();
}
public void addWagon(Wagon wagon){
    if (!canAddWagon()){
        throw new IllegalStateException("no more wagons possible")
    }
    wagons.add(wagon);
}
public boolean canSell(TravelClass travelClass){
    if (travelClass != locomotive.getTravelClass()){
        return false
    }
    return tickets.size() < locomotive.getMaxPassengers();
}

public void addTicket(Ticket ticket){
    if(!canSell((ticket.getTravelClass())){
        throw new IllegalStateException("Train is full or wrong class")
    }
    ticket.add(ticket)
}
public int soldTickets(){
    return tickets.size();
}
public int getCapacity(){
    return locomotive.getMaxPassengers();
}
public List<Ticket> getTickets(){
    return tickets
}
}

