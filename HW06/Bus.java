/**
 * This class describes a bus, and it is a concrete implementation of Transportation.
 * @author Somtochukwu Nwagbata
 * @version 1.0
 */
public class Bus extends Transportation {
    private int stops;

    /**
     * This is the constructor for the Bus class.
     * @param company The company that owns the bus.
     * @param id The id of the bus.
     * @param departDate The date the bus departs.
     * @param departTime The time the bus departs.
     * @param arrivalTime The time the bus arrives.
     * @param stops The number of stops the bus makes.
     */
    public Bus(String company, int id, String departDate, String departTime, String arrivalTime, int stops) {
        super(company, id, departDate, departTime, arrivalTime);
        if (stops < 0) {
            throw new IllegalArgumentException("Stops cannot be negative");
        } else {
            this.stops = stops;
        }
    }

    /**
     * Equals method for the Bus class.
     * @param obj The object to compare to.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Bus) {
            Bus other = (Bus) obj;
            return super.equals(other) && this.stops == other.stops;
        }
        return false;
    }

    /**
     * Returns a string representation of the bus.
     * @return A string representation of the bus.
     */
    @Override
    public String toString() {
        return String.format("Bus,%s,%d", super.toString(), this.stops);
    }
}