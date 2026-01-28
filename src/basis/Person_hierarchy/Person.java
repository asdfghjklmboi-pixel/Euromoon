package basis.Person_hierarchy;

import java.time.LocalDate;
/**
 * abstract class representing person in the system that all share attributes
 * serves as base for all people in hierarchy, passengers and employees
 * stores personal information like first and last name, register number, date of birth
 *
 */
    public abstract class Person {
    protected String firstName;
    protected String lastName;
    protected String registerNr;
    protected LocalDate dateOfBirth;

    /**
     * @param registerNr national register number
     * @param firstName first name person
     * @param lastName last name person
     * @param dateOfBirth DoB person
     * @throws IllegalArgumentException if the parameter is left empty
     */
    public Person(String registerNr,
                  String firstName,
                  String lastName,
                  LocalDate dateOfBirth) {
        helperNotEmpty(registerNr, "registerNr");
        helperNotEmpty(firstName, "firstName");
        helperNotEmpty(lastName, "lastName");

        this.registerNr = registerNr;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }
    /**
     * helper method to check empty values
     * @param value the value to check
     * @param name name of parameter
     * @throws IllegalArgumentException if value is empty or null
     */
    protected static void helperNotEmpty(String value, String name) {
        if (value == null || value.isEmpty())
            throw new IllegalArgumentException(name + " cannot be empty");
    }
    /**
     *
     * @return parameters first name, last name, register number, date of birth
     */
    public String getFirstName(){
        return firstName;
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
