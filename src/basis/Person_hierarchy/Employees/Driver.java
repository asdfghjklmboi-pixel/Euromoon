package basis.Person_hierarchy.Employees;
import basis.Person_hierarchy.Employee;
import basis.constants.Certificates;

import java.time.LocalDate;

/**
 * Driver is an employee with qualification {@link Certificates#DRIVING_B1}
 * the initial certificate held at creation
 */
public class Driver extends Employee {
    /**
     * constructs driver with personal info + initial certificate
     * @param firstName first name of driver
     * @param lastName last name of driver
     * @param registerNr register number of driver
     * @param dateOfBirth date of birth of driver
     * @param initialCert inital certificate of driver
     * @throws IllegalArgumentException if {@code initialCert} is null
     * @throws IllegalStateException if driver does not hold B1 License
     */
    public Driver(String firstName,
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
        return Certificates.DRIVING_B1;
    }


}
