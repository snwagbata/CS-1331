/**
 * This class describes a flight, and it is a concrete implementation of Transportation.
 * @author Somtochukwu Nwagbata
 * @version 1.0
 */
public class Flight extends Transportation {
    private int connectors;

    /**
     * Constructor for objects of class Flight.
     * @param company The company that is providing the flight.
     * @param id The id of the flight.
     * @param departDate The date of departure.
     * @param departTime The time of departure.
     * @param arrivalTime The time of arrival.
     * @param connectors The number of connectors.
     * @throws IllegalArgumentException if the connectors is less than 0.
     */
    public Flight(String company, int id, String departDate, String departTime, String arrivalTime, int connectors) {
        super(company, id, departDate, departTime, arrivalTime);

        if (connectors < 0) {
            throw new IllegalArgumentException("Connectors must be greater than 0");
        } else {
            this.connectors = connectors;
        }
    }

    /**
     * Equals method for Flight objects.
     * @param obj The other Flight object to compare to.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Flight) {
            Flight other = (Flight) obj;
            return super.equals(other) && connectors == other.connectors;
        }
        return false;
    }

    /**
     * Returns a string representation of the Flight object.
     * @return A string representation of the Flight object.
     */
    @Override
    public String toString() {
        return String.format("Flight,%s,%d", super.toString(), connectors);
    }
}