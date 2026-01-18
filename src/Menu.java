import basis.Person_hierarchy.Passenger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    //passengers, trip
    private static Scanner scanner = new Scanner(System.in);
    private final List<Passenger> passengers = new ArrayList<>();
    private final List<Trip> trips = new ArrayList<>();

    public static void main(String[] args) {
        new Menu().start();
    }
        while (running) {
            System.out.println("1. Register Passenger");
            System.out.println("2. Create Trip");
            System.out.println("3. Assign Train to Trip");
            System.out.println("4. Sell Ticket");
            System.out.println("5. Print Boarding list");
            System.out.println("Enter choice: ");

            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    registerPassenger();
                    break;
                case 2:
                    createTrip();
                    break;
                case 3:
                    assignTriptoTrain();
                    break;
                case 4:
                    sellTicket();
                    break;
                case 5:
                    printBoardingList();
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

private static void registerPassenger() {
    System.out.print("First name passenger: ");
    String name = scanner.nextLine();
    System.out.print("Last name passenger: ");
    String lastName = scanner.nextLine();
    System.out.print("Rijksregister passenger: ");
    String registerNr = scanner.nextLine();
    System.out.print("Birthdate passenger: ");
    String dateOfBirth = scanner.nextLine();

    Passenger passenger = new Passenger(registerNr, name, lastName, dateOfBirth)
    passengers.add(passenger);

    System.out.println("passenger registered.");
}

private static void createTrip() {
    System.out.print("From: ");
    String startStation = scanner.nextLine();
    System.out.print("To: ");
    String destination = scanner.nextLine();

    Trip trip = new Trip(startStation, destination, LocalDateTime.now().plusHours(1));
    trips.add(trip);

    System.out.println("Trip created.");

}

//Hulp functie om trip te selecteren of anders gaat assign kei lang worden
private Trip selectTrip(){
    if(trips.isEmpty()){
        System.out.println("No trips currently available!");
        return null;
    }

    //itereer door lijst van trips
    for(int i = 0; i < trips.size(); i++){
        System.out.println(i + ". " + trips.get(i).getTripRoute());
    }

    System.out.print("Choose Trip: ");
    int index = Integer.parseInt(scanner.nextLine());

    if(index < 0 || index >= trips.size()){
        System.out.println("Error.");
        return null;
    }
    return trips.get(index);
}

private static void assignTriptoTrain() {
    Trip trip = selectTrip();
    if(trip == null) return;

    System.out.println("Choose locomotive type");
    System.out.println("1. Class 373 (max 12 wagons)");
    System.out.println("2. Class 374 (max 14 wagons)");

    int locomotiveChoice = integer.parseInt(scanner.nextLine());

    System.out.println("Choose class.");
    System.out.println("1. FIRST");
    System.out.println("2. SECOND");

    int classChoice = Integer.parseInt(scanner.nextLine());
    TravelClass travelClass = (classChoice == 1) ? TravelClass.FIRST : TravelClass.SECOND

    Locomotive locomotive;
    if(locomotiveChoice == 1){
        locomotive  = new Class373(travelClass);
    } else {
        locomotive = new Class374(travelClass)
    }

    Train train = new Train(locomotive);
    int wagonNr = 1;
    while(train.canAddWagon()){
        train.addWagon(new Wagon(wagonNr++));
    }

    trip.setTrain(train)
    System.out.println("Train has been assigned to the trip.");
}

private Passenger selectPassenger(){
    if (passenger.isEmpty()){
        System.out.println("No passengers");
        return null;
    }

    for(int i = 0; i < passengers.size(); i++){
        System.out.println(i + ". " + passengers.get(i).getName());
    }

    System.out.print("Choose passenger: ");
    int index = Integer.parseInt(scanner.nextLine());

    if(index < 0 || index >= passengers.size()) {
        System.out.println("Error.");
        return null;
    }
    return passengers.get(index);
}

private static void sellTicket() {

    Passenger passenger = selectPassenger();
    Trip trip = selectTrip();

    if (passenger == null || trip == null) return;

    System.out.println("Choose class.");
    System.out.println("1. FIRST");
    System.out.println("2. SECOND");

    int choice = Integer.parseInt(scanner.nextLine());
    TravelClass travelClass = (classChoice == 1) ? TravelClass.FIRST : TravelClass.SECOND

    if (!trip.canSellTicket(travelClass)){
        System.out.println("Invalid");
        return;
    }

    Ticket ticket = new Ticket(passenger, trip, travelClass);
    trip.sellTicket(ticket);
    passenger.addTicket(ticket);

    System.out.println("Ticket sold!");

}

private static void printBoardingList() {
    //txt aanmaken
}

}