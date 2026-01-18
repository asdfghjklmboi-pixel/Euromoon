public class Ticket {
    private Passenger boughtBy;
    //private Trip
   // private seatClass

    public Ticket(Passenger passenger){
        this.boughtBy = passenger;
        passenger.buyTicket(this);
    }
}
