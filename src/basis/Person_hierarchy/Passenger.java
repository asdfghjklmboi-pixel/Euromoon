package basis.Person_hierarchy;

import basis.Ticket;
/*A passenger who can book trips
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Passenger extends Person {
    public Passenger(String registerNr,
                     String firstName,
                     String lastName,
                     LocalDate dateOfBirth){
        super(registerNr, firstName, lastName, dateOfBirth);
    }

    private List<Ticket> tickets = new ArrayList<>();
    public void buyTicket(Ticket ticket){
        tickets.add(ticket);
    }

    public List<Ticket> getTicket(){
        return tickets;
    }

    @Override
    public String toString() {
        return "Passenger name: " + firstName + " " + lastName + ", National Register: '" + registerNr + "'";
    }
}
