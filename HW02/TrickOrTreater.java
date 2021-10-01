/**
 * This file defines the {@code TrickOrTreater} object.
 * @author Somtochukwu Nwagbata
 * @version 1.0
 */
public class TrickOrTreater {
    protected String name, neighborhood;
    protected int numCandy;
    protected int totalCandy; // TODO what reserved word for this?

    /**
     * Constructs the {@code TrickOrTreater} object.
     * @param name the name of the {@code TrickOrTreater}
     * @param neighborhood the neighborhood of the {@code TrickOrTreater}
     * @param numCandy the number of candies the {@code TrickOrTreater} has
     */
    public TrickOrTreater(String name, String neighborhood, int numCandy) {
        this.name = name;
        this.neighborhood = neighborhood;
        this.numCandy = numCandy;
    }

    /**
     * Constructs the {@code TrickOrTreater} object with no params.
     */
    public TrickOrTreater() {
        this("Agnes", "Halloweentown.", 0);
    }

    /**
     * Increases candy based on luck.
     * @param luck the luck of the {@code TrickOrTreater}
     */
    public void seekCandy(int luck) {
        luck *= 3;
        numCandy += luck;
        totalCandy += luck;
    }

    /**
     * Returns the name of the {@code TrickOrTreater} object.
     * @return the name of the {@code TrickOrTreater} object
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the neighborhood of the {@code TrickOrTreater} object.
     * @return the neighborhood
     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**
     * Returns the number of candy the {@code TrickOrTreater} object has.
     * @return the number of candy
     */
    public int getNumCandy() {
        return numCandy;
    }

    /**
     * Returns the total number of candy the {@code TrickOrTreater} object has.
     * @return the total number of candy
     */
    public int getTotalCandy() {
        return totalCandy;
    }

    /**
     * sets the name of the {@code TrickOrTreater} object.
     * @param name the name of the {@code TrickOrTreater} object
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * sets the neighborhood of the {@code TrickOrTreater} object.
     * @param neighborhood the neighborhood of the {@code TrickOrTreater} object
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    /**
     * sets the number of candy the {@code TrickOrTreater} object has.
     * @param numCandy the number of candy the {@code TrickOrTreater} object has
     */
    public void setNumCandy(int numCandy) {
        if (numCandy > 0) {
            this.numCandy += numCandy;
            this.totalCandy += numCandy;
        }
    }

    /**
     * sets the total number of candy the {@code TrickOrTreater} object has.
     * @param totalCandy the total number of candy the {@code TrickOrTreater} object has
     */
    public void setTotalCandy(int totalCandy) {
        this.totalCandy = totalCandy;
    }

}