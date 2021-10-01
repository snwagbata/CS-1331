/**
 * This file defines the {@code Ghost} object.
 * @author Somtochukwu Nwagbata
 * @version 1.0
 */
public class Ghost extends TrickOrTreater {
    private int transparency;

    /**
     * Constructs a {@code Ghost} object.
     * @param name the name of the {@code Ghost}
     * @param neighborhood the neighborhood of the {@code Ghost}
     * @param numCandy the number of candies the {@code Ghost} has
     * @param transparency the transparency of the {@code Ghost}
     */
    public Ghost(String name, String neighborhood, int numCandy, int transparency) {
        super(name, neighborhood, numCandy);
        this.transparency = transparency;
    }

    /**
     * Constructs a {@code Ghost} object using {@code TrickOrTreats}'s default constructor.
     * @param transparency the transparency of the {@code Ghost}
     */
    public Ghost(int transparency) {
        super();
        this.transparency = transparency;
    }

    /**
     * Constructs a {@code Ghost} object using another {@code Ghost}.
     * @param other the {@code Ghost} to copy
     */
    public Ghost(Ghost other) {
        super(other.name, other.neighborhood, other.numCandy);
        this.transparency = other.transparency;
    }

    /**
     * Prints based on the transparency of the {@code Ghost}.
     */
    public void spook() {
        if (transparency >= 10) {
            System.out.println("Very spooky");
        } else if (transparency >= 3 && transparency <= 9) {
            System.out.println("Boo!");
        } else if (transparency <= 2) {
            System.out.println("Not very spooky");
        }
    }

    /**
     * Returns the transparency of the {@code Ghost}.
     * @return the transparency of the {@code Ghost}
     */
    public int getTransparency() {
        return transparency;
    }

    /**
     * Sets the transparency of the {@code Ghost}.
     * @param transparency the transparency of the {@code Ghost}
     */
    public void setTransparency(int transparency) {
        this.transparency = transparency;
    }

}
