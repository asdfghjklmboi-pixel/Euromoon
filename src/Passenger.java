import java.time.LocalDate;

public class Passenger extends Person {
private Ticket buyTicket;

    public Passenger(String name, String lastName, int registerNr, LocalDate dateOfBirth){
        super(registerNr, name, lastName, dateOfBirth);
    }

public void buyTicket(Ticket ticket){
this.buyTicket = ticket;
}
public Ticket getTicket(){
return buyTicket;
}
}
