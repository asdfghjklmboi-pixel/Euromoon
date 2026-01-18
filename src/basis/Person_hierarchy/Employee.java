package basis.Person_hierarchy;
import basis.constants.Certificates;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public abstract class Employee extends Person {
    private final Set<Certificates> certificates = new HashSet<>();

    public Employee(String registerNr,
                    String name,
                    String lastName,
                    LocalDate dateOfBirth) {
        super(registerNr, name, lastName, dateOfBirth);
    }
public void addCertificate(Certificates certificates){
      certificates.add(certificates)
}
public Set<Certificates> getCertificate();{
    return Set.copyOf(certificates);
    }
    //check for certificate
}
