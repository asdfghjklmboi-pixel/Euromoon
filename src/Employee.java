import java.time.LocalDate;

public abstract class Employee extends Person {
    private String certificate;

    public Employee(String name, String lastName, LocalDate dateOfBirth, int registerNr){
        super(registerNr, name, lastName, dateOfBirth);
        this.certificate = certificate;
    }


}
