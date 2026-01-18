import java.time.LocalDate;
import java.util.Set;

public class Driver extends Employee {
    private Train drivesTrain;

    public Driver(String registerNr,
                  String name,
                  String lastName,
                  LocalDate dateOfBirth,
                  String certificates){
        super(name, lastName, dateOfBirth, registerNr);
    }

    public void assignTrain(Train train) {
        if(!getCertificates().contains(Certificates.DRIVING_B1)) {
            throw new IllegalStateException("Person doesn't meet the requirements for being driver");
        }
        this.drivesTrain = train;
    }

    public Train getDrivesTrain() {
        return drivesTrain;
    }

   public void addCertificates(Certificates certificates){
        //certificates
   }

   public Set<Certificates> getCertificates(){
        return Set.copyOf(certificates)
   }
}
