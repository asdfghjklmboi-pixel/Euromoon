import java.time.LocalDate;

public class Driver extends Employee {
    private Train drivesTrain;

    public Driver(String name, String lastName, LocalDate dateOfBirth, int registerNr){
        super(name, lastName, dateOfBirth, registerNr);
    }
    public void setTrain(Train train) {
        this.drivesTrain = train;
    }
    public Train getDrivesTrain() {
        return drivesTrain;
    }
}
