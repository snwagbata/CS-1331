/**
 * This class represents a piece of loot in the form of a coin.
 * @author Somtochukwu Nwagbata
 * @version 1.0
 */
public class Coin extends Loot {
    private boolean heads;
    private int yearMade;
    private String material;

    /**
     * Constructor for objects of class Coin.
     * @param value The value of the coin.
     * @param heads The face of the coin.
     * @param yearMade The year the coin was made.
     * @param material The material the coin is made of.
     */
    public Coin(double value, boolean heads, int yearMade, String material) {
        super(value);
        this.heads = heads;
        this.material = material;
        if (yearMade < 0 || yearMade > 1700) {
            this.yearMade = 1700;
        } else {
            this.yearMade = yearMade;
        }
    }

    /**
     * 2-param constructor for the Coin.
     * @param heads The face of the coin.
     * @param yearMade The year the coin was made.
     */
    public Coin(boolean heads, int yearMade) {
        this(((3000.0 - yearMade) / 100.0), heads, yearMade, "Gold");
    }

    /**
     * Equality checker for the coin.
     * @param obj The object to be compared to.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Coin) {
            Coin other = (Coin) obj;
            return super.equals(other) && this.yearMade == other.yearMade && this.material.equals(other.material);
        }
        return false;
    }

    /**
     * String representation of the coin.
     * @return The string representation of the coin.
     */
    @Override
    public String toString() {
        return String.format("A %s coin made in %d. Heads side is up: %b", material, yearMade, heads);
    }
}
