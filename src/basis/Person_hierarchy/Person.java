package basis.Person_hierarchy;

import java.time.LocalDate;
/**
* elk persoon aan boord deelt deze attributes
 * naam, achternaam, rijksregisternummer, geboortedatum
*
 */
    public abstract class Person {
    private final String name;
    private final String lastName;
    private final String registerNr;
    private final LocalDate dateOfBirth;

    public Person(String registerNr,
                  String name,
                  String lastName,
                  LocalDate dateOfBirth) {
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
    public String getRegisterNr(){

        return registerNr;
    }
    public LocalDate getDateOfBirth(){

        return dateOfBirth;
    }
}
