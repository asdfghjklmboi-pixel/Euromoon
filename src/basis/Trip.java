package basis;

import Trains.Train;
import basis.Person_hierarchy.Employee;
import basis.constants.Certificates;
import basis.constants.TravelClass;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * represents a scheduled trip
 * contains assigned train and the people boarding
 */

public class Trip {
    private String startStation;
    private String destination;
    private LocalDateTime departureTime;
    private Train train;
    private List<Employee> staff;
    private List<Ticket> soldTickets;

    public Trip(String startStation, String destination, LocalDateTime departureTime) {
        this.startStation = startStation;
        this.destination = destination;
        this.departureTime = departureTime;
        this.staff = new ArrayList<>();
        this.soldTickets = new ArrayList<>();
    }

    public static boolean canSellTicket(TravelClass travelClass) {
        return false;
    }

    public void setTrain(Train train) {
    }

    /**
     *
     * @return description of the route
     */
    public String getTripRoute() {
        return startStation + " to " + destination + " at " + departureTime;
    }

    /**
     *
     * @param employee added to staff list, needs toi hold atleast one certificate
     */
    public void addStaff(Employee employee) {
        if (employee.getCertificates() == null || employee.getCertificates().isEmpty()){
            throw new IllegalArgumentException("Employee does not hold required Driving License");
        }
        this.staff.add(employee);
    }

    /**
     *
     * @return goes through employees to find atleast one driver and three stewards to board train
     */
    public boolean hasRequiredStaff() {
        int driverCount = 0;
        int stewardCount = 0;

        for (Employee e : staff) {
            List<Certificates> certs = e.getCertificates();
            if (certs != null){
                if (certs.contains(Certificates.DRIVING_B1)){
                    driverCount++;
                }
                if (certs.contains(Certificates.TOURISM)){
                    stewardCount++;
                }
            }
        }
        return driverCount >= 1 && stewardCount >= 3;
    }
    /**
     * calculating remaining seats for each class
     * @param travelClass first/second class
     * @return remaining seats
     */
    public int getAvailableSeats(TravelClass travelClass){
        if (train == null) return 0;
        int totalCapacity = train.getTotalCapacity(travelClass);
        long soldCount = soldTickets.stream()
                .filter(ticket -> ticket.getTravelClass() == travelClass)
                .count();

        return totalCapacity - (int) soldCount;
    }
    public void sellTicket(Ticket ticket) {
        if (train == null) {
            throw new IllegalArgumentException("no train assigned to trip yet");
        }
        if (getAvailableSeats(ticket.getTravelClass())<= 0) {
            throw new IllegalStateException("no seats available in " + ticket.getTravelClass());
        }
        soldTickets.add(ticket);
    }

    /**
     *
     * @return getters for printing boarding list
     */
    public List<Ticket> getSoldTickets(){
        return new ArrayList<>(soldTickets);
    }
    public String getDestination() {
        return destination;
    }
    public String getStartStation() {
        return startStation;
    }
    public LocalDateTime getDepartureTime() {
        return departureTime;
    }
    public Train getTrain() {
        return train;
    }
}
