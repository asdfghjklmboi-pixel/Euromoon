package Trains;
import basis.constants.TravelClass;
import java.util.ArrayList;
import java.util.List;

/**
 * locomotive + wagons
 */
public class Train {
    private final Locomotive locomotive;
    private final List<Wagon> wagons;

public Train (Locomotive locomotive){
    this.locomotive = locomotive;
    this.wagons = new ArrayList<>();
}

    /**
     *
     * @param wagon adding
     * wagon adds wagons if limiot has not been reached
     */
    public void addWagon(Wagon wagon){
    if (wagons.size() >= locomotive.getMaxWagons()){
        throw new IllegalStateException("no more wagons possible");
    }
    wagons.add(wagon);
}
    /**
     * caclulating the capacity for locomotice + wagon seats
     * @param travelClass seats first and second class
     * @return seat capacity specific class
     */
    public int getTotalCapacity(TravelClass travelClass){
    int capacity = locomotive.getLocomotiveCapacity(travelClass);
    for (Wagon wagons : wagons ){
        if (wagons.getTravelClass() == travelClass) {
            capacity += wagons.getCapacity();
        }
    }
    return capacity;
}
public Locomotive getLocomotive() {
    return locomotive;
}
@Override
    public String toString() {
    return "Train model: " + locomotive.getModel() + "with " + wagons.size() + "wagons";
}
}
