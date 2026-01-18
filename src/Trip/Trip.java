package Trip;

import Trains.Train;
import basis.Person_hierarchy.Employee;
import basis.constants.TravelClass;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Trip {
    private String startStation;
    private String destination;
    private LocalDateTime departure;
    private Train train;

   // private List<Employee> staff = new ArrayList<>();
   // private List<Ticket> tickets = new ArrayList<>();

    public Trip(String startStation, String destination, LocalDateTime departure){
        this.startStation = startStation;
        this.destination = destination;
        this.departure = departure;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
    public boolean hasTrain(){
        return train != null;
    }
    public Train getTrain(){
        return train;
    }
    public String getTripRoute(){
        return "From" + startStation + "to" + destination;
    }
    public LocalDateTime getDeparture(){
        return departure
    }
    public boolean canSellTicket(TravelClass travelClass){
        return train != null && train.canSellTicket(travelClass);
    }
    public void sellTicket(Ticket ticket){
        if (train == null){
            throw new IllegalStateException("There is no train connected to this trip");
        }
        train
    }
}
