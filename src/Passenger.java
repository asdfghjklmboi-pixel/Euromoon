import java.time.LocalDate;
import java.util.List;

public class Passenger extends Person {
private Ticket buyTicket;

    public Passenger(String registerNr,
                     String name,
                     String lastName,
                     LocalDate dateOfBirth){
        super(registerNr, name, lastName, dateOfBirth);
    }

public void buyTicket(Ticket ticket){
this.buyTicket = ticket;
}
public List<Ticket> getTicket(){
        return buyTicket;
}
}
