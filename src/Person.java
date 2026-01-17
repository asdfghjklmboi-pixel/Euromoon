import javax.naming.Name;
import java.time.LocalDate;

public abstract class Person {
    private String name;
    private String lastName;
    private int registerNr;
    private LocalDate dateOfBirth;

    public Person(int registerNr, String name, String lastName, LocalDate dateOfBirth) {
        this.registerNr = registerNr;
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName(){
        return name;
    }
    public String getLastName(){
        return lastName;
    }
    public int getRegisterNr(){
        return registerNr;
    }
    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }
}
