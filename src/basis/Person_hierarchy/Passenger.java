package basis.Person_hierarchy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Passenger extends Person {
private List<Ticket> tickets = new ArrayList<>();

    public Passenger(String registerNr,
                     String name,
                     String lastName,
                     LocalDate dateOfBirth){
        super(registerNr, name, lastName, dateOfBirth);
    }

public void buyTicket(Ticket ticket){
        tickets.add(ticket);
}
public List<Ticket> getTicket(){
        return tickets;
}
}
