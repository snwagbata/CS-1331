/**
 * This class represents the spoils gained from plundering a ship or fort.
 * @author Somtochukwu Nwagbata
 * @version 1.0
 */
public abstract class Loot {
    private double value;

    /**
     * Constructor for Loot.
     * @param value the value of the loot.
     */
    public Loot(double value) {
        if (value > 0) {
            this.value = value;
        }
    }

    /**
     * No-param constructor for loot.
     */
    public Loot() {
        this.value = 0;
    }

    /**
     * Getter for value.
     * @return the value of the loot.
     */
    public double getValue() {
        return value;
    }

    /**
     * Setter for value.
     * @param value the value of the loot.
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Equality checker for loot.
     * @param obj the object to be compared to.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Loot) {
            return ((Loot) obj).value == this.value;
        }
        return false;
    }

    /**
     * String representation of loot.
     * @return the string representation of the loot.
     */
    @Override
    public String toString() {
        return String.format("A piece of loot worth %.2f", value);
    }

}
