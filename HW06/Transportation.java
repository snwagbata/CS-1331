/**
 * This class represents a mode of Transportation,  and it is an abstract class.
 * @author Somtochukwu Nwagbata
 * @version 1.0
 */
public abstract class Transportation {
    protected String company, departDate, departTime, arrivalTime;
    protected int id;

    /**
     * This is the constructor for the Transportation class.
     * @param company The company that is providing the transportation.
     * @param id The id of the transportation.
     * @param departDate The date of departure.
     * @param departTime The time of departure.
     * @param arrivalTime The time of arrival.
     * @throws IllegalArgumentException If the id is negative and is not 5 digits.
     */
    public Transportation(String company, int id, String departDate, String departTime, String arrivalTime) {
        this.company = company;
        this.departDate = departDate;
        this.departTime = departTime;
        this.arrivalTime = arrivalTime;

        if (id < 0 || Integer.toString(id).length() != 5) {
            throw new IllegalArgumentException("Invalid ID");
        } else {
            this.id = id;
        }
    }

    /**
     * Equals method for the Transportation class.
     * @param obj The object to be compared.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Transportation) {
            Transportation other = (Transportation) obj;
            return this.id == other.id && this.company.equals(other.company) && this.departDate.equals(other.departDate)
                    && this.departTime.equals(other.departTime) && this.arrivalTime.equals(other.arrivalTime);
        }
        return false;
    }

    /**
     * String representation of the Transportation class.
     * @return The string representation of the Transportation class.
     */
    @Override
    public String toString() {
        return String.format("%s,%d,%s,%s,%s", company, id, departDate, departTime, arrivalTime);
    }
}