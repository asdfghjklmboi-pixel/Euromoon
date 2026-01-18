import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(system.in);

    scanner.nextLine();
    switch(option) {
        case 1: registerPassenger();
        break;
        case 2: createTrip();
        break;
        case 3: assignTriptoTrain();
        break;
        case 4: sellTicket();
        break;
        case 5: printBoardingList();
        break;
        default: System.out.println("Invalid option");
    }
}
