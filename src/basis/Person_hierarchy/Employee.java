package basis.Person_hierarchy;
import basis.constants.Certificates;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

/**
 * all employees possess at least a single certificate,
 * and holds a qualification defined by each subclass using enum {@link Certificates}.
 */
public abstract class Employee extends Person {
    /** set of certificates held by the employee*/
    private final EnumSet<Certificates> certificates;
    /**
     * create employee
     * @param registerNr register number of employee
     * @param firstName first name of employee
     * @param lastName last name of employee
     * @param dateOfBirth date of birth of employee
     * @param initialCert first certificate employee, cannot be null
     * @throws IllegalArgumentException if {@code initialCert} is null
     * @throws IllegalStateException if employee does not hold required certificate
     */
    public Employee(String firstName,
                    String lastName,
                    String registerNr,
                    LocalDate dateOfBirth,
                    Certificates initialCert) {

        super(registerNr, firstName, lastName, dateOfBirth);

        //check for certificate
        if (initialCert == null) {
            throw new IllegalArgumentException("must have a certificate");
        }

        this.certificates = EnumSet.noneOf(Certificates.class);
        this.certificates.add(initialCert);

        isQualified();
    }

    /**
     * Subclasses define required certification
     * @return certificate to be qualified for position
     */
    protected abstract Certificates getQualification();
    /**
     * checks eif employee has the right certificate
     * @throws IllegalArgumentException if the certificate is missing
     */
    private void isQualified() {
        Certificates qualification = getQualification();
        if (!certificates.contains(qualification)) {
            throw new IllegalStateException("missing certificate: " + qualification);
        }
    }

    /**
     * adds certificate to list of certificates
     * @param certificates the certificates
     */
    public void addCertificate(Certificates certificates){
      this.certificates.add(certificates);
}
    /**
     * @return unmodifiable set of certificates from the employee
     */
    public List<Certificates> getCertificates(){
        return new ArrayList<>(certificates);

    }
}
