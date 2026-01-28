package basis.Person_hierarchy.Employees;
import basis.Person_hierarchy.Employee;
import basis.constants.Certificates;

import java.time.LocalDate;

/**
 * Steward is an employee with qualification {@link Certificates#TOURISM}
 * the initial certificate held at creation
 */
public class LuggageStaff extends Employee {
    /**
     * constructs staff with personal info + initial certificate
     * @param firstName first name of staff
     * @param lastName last name of staff
     * @param registerNr register number of staff
     * @param dateOfBirth date of birth of staff
     * @param initialCert initIal certificate of staff
     * @throws IllegalArgumentException if {@code initialCert} is null
     * @throws IllegalStateException if steward does not hold Tourism certificate
     */
    public LuggageStaff(String firstName,
                   String lastName,
                   String registerNr,
                   LocalDate dateOfBirth,
                   Certificates initialCert){
        super(firstName, lastName, registerNr, dateOfBirth, initialCert);
    }

    /**
     * qualification
     * @return {@link Certificates#SAFETY}
     */
    @Override
    protected Certificates getQualification() {
        return Certificates.SAFETY;
    }


}
