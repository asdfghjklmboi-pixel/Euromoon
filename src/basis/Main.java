package basis;

import Trains.*;
import basis.Person_hierarchy.Employees.Driver;
import basis.Person_hierarchy.Employees.Steward;
import basis.Person_hierarchy.Passenger;
import basis.constants.Stations;
import basis.constants.TravelClass;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

/**
 * the menu ui
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Passenger> passengers = new ArrayList<>();
    private static final List<Trip> trips = new ArrayList<>();

    /**
     * starts the program/menu loop
     *
     * @param args not used
     */
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        boolean running = true;

        while (running) {
            System.out.println("1. Register Passenger");
            System.out.println("2. Create Trip");
            System.out.println("3. Assign Train to Trip");
            System.out.println("4. Sell Ticket");
            System.out.println("5. Print Boarding list");
            System.out.println("0. Exit");
            System.out.println("Enter choice: ");

            try {
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
                    case 0:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option");
                }
            } catch (NumberFormatException e) {
                System.out.println("invalid number");
            } catch (Exception e) {
                System.out.println("error: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }

    /**
     * prompts user with entering info regarding passenger
     */
    private static void registerPassenger() {
        System.out.println("First name passenger: ");
        String firstName = scanner.nextLine();
        System.out.println("Last name passenger: ");
        String lastName = scanner.nextLine();
        System.out.println("Register number passenger: ");
        String registerNr = scanner.nextLine();
        System.out.println("Birthdate passenger: ");

        LocalDate dob = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (dob == null) {
            System.out.println("Birthdate passenger (DD/MM/YYYY)");
            String input = scanner.nextLine();
            try {
                dob = LocalDate.parse(input, formatter);
            } catch (DateTimeException e) {
                System.out.println("Invalid format.");
            }
        }
        passengers.add(new Passenger(firstName, lastName, registerNr, dob));
        System.out.println("passenger registered.");
        scanner.nextLine();
    }

    /**
     * creates a new train trip
     * prompt stations and departure
     */
    private static Trip createTrip() {
        Stations startStation = selectStation("start");
        if (startStation == null) return null;
        Stations destination = selectStation("destination");
        if (destination == null) return null;

        LocalDateTime departure = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        while (departure == null) {
            System.out.println("departure: (DD/MM/YYYY HH:mm): ");
            String dateInput = scanner.nextLine();
            try {
                departure = LocalDateTime.parse(dateInput, formatter);
            } catch (DateTimeException e) {
                System.out.println("Invalid format.");
            }
        }

        Trip trip = new Trip(startStation, destination, departure);
        trips.add(trip);
        System.out.println("Trip created.");
        scanner.nextLine();
        return trip;
    }

    /**
     * Hulp functie om trip te selecteren
     *
     * @return {@code null} if trip is empty or a selected {@code Trip}
     */
    private static Trip selectTrip() {
        if (trips.isEmpty()) {
            System.out.println("No trips currently available!");
            System.out.println("Press Enter to continue");

            scanner.nextLine();

            return null;
        }
        /* itereer door lijst van trips
         */
        for (int i = 0; i < trips.size(); i++) {
            System.out.println((i + 1) + ". " + trips.get(i).getTripRoute());
        }

        System.out.print("Choose Trip: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        if (index < 0 || index >= trips.size()) {
            System.out.println("Press Enter to continue");
            scanner.nextLine();

            return null;
        }
        return trips.get(index);
    }

    private static Stations selectStation(String s) {
        Stations[] stations = Stations.values();

        System.out.println("choose " + s + " station");
        for (int i = 0; i < stations.length; i++) {
            System.out.println((i + 1) + ". " + stations[i]);
        }
        try {
           int index = Integer.parseInt(scanner.nextLine()) - 1;
        if (index < 0 || index >= stations.length) {
            System.out.println("Error.");
            scanner.nextLine();
            return null;
        }
        return stations[index];
        } catch (NumberFormatException e) {
            System.out.println("Error.");
            scanner.nextLine();
        }    return null;
    }


    /**
     * add train/locomotive to a selected trip
     */
    private static void assignTriptoTrain() {
        Trip trip = selectTrip();
        if (trip == null) return;


        System.out.println("Choose locomotive type");
        System.out.println("1. Class 373 (max 12 wagons)");
        System.out.println("2. Class 374 (max 14 wagons)");

        int locomotiveChoice = Integer.parseInt(Main.scanner.nextLine());

        Locomotive locomotive;
        if (locomotiveChoice == 1) {
            locomotive = new Class_373();
        } else {
            locomotive = new Class_374();
        }

        Train train = new Train(locomotive);


        trip.setTrain(train);
        System.out.println("Train has been assigned to the trip.");
        scanner.nextLine();
    }

    /**
     * all registered passengers
     * @return  selected {@code Passenger} or Null
     */
    private static Passenger selectPassenger() {
        if (passengers.isEmpty()) {
            System.out.println("No passengers");
            scanner.nextLine();
            return null;
        }

        for (int i = 0; i < passengers.size(); i++) {
            System.out.println((i + 1)  + ". " + passengers.get(i).getFirstName());
        }

        System.out.print("Choose passenger: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        if (index < 0 || index >= passengers.size()) {
            System.out.println("Error.");
            scanner.nextLine();
            return null;
        }
        return passengers.get(index);
    }
/**
    private static void assignStaffToTrip() {
        Trip trip = selectTrip();
        if (trip== null) return;

        Driver driver = new Driver("John", "Doe");
        List<Steward> stewards = new ArrayList<>();
        stewards.add(new Steward("Jane", "Doe"));
        stewards.add(new Steward("Amanda", "Shamanda"));
        stewards.add(new Steward("Nicki", "Minaj"));

    }
    **/
    private static void sellTicket() {

        Passenger passenger = selectPassenger();
        Trip trip = selectTrip();

        if (passenger == null || trip == null) return;

        System.out.println("Choose class.");
        System.out.println("1. FIRST");
        System.out.println("2. SECOND");

        int choice = Integer.parseInt(Main.scanner.nextLine());
        TravelClass travelClass = (choice == 1) ? TravelClass.FIRST : TravelClass.SECOND;

        if (!Trip.canSellTicket(travelClass)) {
            System.out.println("Invalid");
            return;
        }

        Ticket ticket = new Ticket(passenger, trip, travelClass);
        trip.sellTicket(ticket);
        passenger.buyTicket(ticket);

        System.out.println("Ticket sold!");

    }

    /**
     * prints a txt file containing all tickets sold for a trip and its correcsponding passenger
     */
    private static void printBoardingList() {
        Trip trip = selectTrip();
        if (trip == null) return;

        if (trip.getSoldTickets().isEmpty()) {
            System.out.println("no passengers");
            System.out.println("Press Enter to continue");
            scanner.nextLine();
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy'T'HH-mm");
        String fileName =
                       trip.getStartStation() + "_" +
                        trip.getDestination() + "_" +
                        trip.getDepartureTime().format(formatter) + ".txt";

        try (PrintWriter writer = new PrintWriter(fileName)) {
            for (Ticket ticket : trip.getSoldTickets()) {
                writer.println(
                        ticket.getPassenger().getFirstName() + " " +
                                ticket.getPassenger().getLastName() +
                                " riding class: " + ticket.getTravelClass());
            }
            System.out.println("printed " + fileName);
        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
            scanner.nextLine();

        }
    }
}