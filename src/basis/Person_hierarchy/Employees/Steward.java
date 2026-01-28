package basis.Person_hierarchy.Employees;
import basis.Person_hierarchy.Employee;
import basis.constants.Certificates;

import java.time.LocalDate;

/**
 * Steward is an employee with qualification {@link Certificates#TOURISM}
 * the initial certificate held at creation
 */
public class Steward extends Employee {
    /**
     * constructs steward with personal info + initial certificate
     * @param firstName first name of steward
     * @param lastName last name of steward
     * @param registerNr register number of steward
     * @param dateOfBirth date of birth of steward
     * @param initialCert initIal certificate of steward
     * @throws IllegalArgumentException if {@code initialCert} is null
     * @throws IllegalStateException if steward does not hold Tourism certificate
     */
    public Steward(String firstName,
                  String lastName,
                  String registerNr,
                  LocalDate dateOfBirth,
                  Certificates initialCert){
        super(firstName, lastName, registerNr, dateOfBirth, initialCert);
    }

    /**
     * qualification
     * @return {@link Certificates#DRIVING_B1}
     */
    @Override
    protected Certificates getQualification() {
        return Certificates.TOURISM;
    }


}
