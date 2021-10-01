/**
 * This file defines the Neighborhood object.
 * @author Somtochukwu Nwagbata
 * @version 1.0
 * @since 2021-09-26
 */
public class Neighborhood {
    private int numHouses;
    private House[] houses;

    /**
     * Constructor for objects of class Neighborhood.
     * @param houses the array of houses
     */
    public Neighborhood(House[] houses) {
        this.houses = houses;
        this.numHouses = validateHouseArray(houses);
    }

    /**
     * Constructor thats takes no parameters.
     */
    public Neighborhood() {
        this(new House[5]);
    }

    /**
     * Prints details about houses built after {@code year}.
     * @param year the year to start printing
     */
    public void displayNewHouses(int year) {
        for (int i = 0; i < numHouses; i++) {
            if (houses[i] != null && houses[i].getYearBuilt() >= year) {
                House cur = houses[i];
                System.out.printf(
                        "House located at %s was built in %d, has %.1f number of bathrooms, and "
                                + (cur.getIsRenovated() ? "has" : "has not") + " been renovated recently.\n",
                        cur.getAddress(), cur.getYearBuilt(), cur.getNumBaths());
            }

        }
    }

    /**
     * Adds a house to the neighborhood.
     * @param house the house to be added
     * @param index the index to add the house
     * @return previous house at index
     */
    public House addHouse(int index, House house) {

        if (index >= houses.length || index < 0) {
            return null;
        }
        House prev = new House();
        if (houses[index] instanceof House && house instanceof House) {
            prev = houses[index];
            houses[index] = house;
            return prev;
        }

        if (houses[index] == null) {
            houses[index] = house;
            numHouses++;
            return null;
        }

        return null;
    }

    /**
     * Removes a house from the neighborhood.
     * @param index index at which the house is to be removed
     * @return the house that was removed
     */
    public House removeHouse(int index) {
        if (index >= houses.length || index < 0) {
            return null;
        }
        House prev = new House();
        if (houses[index] instanceof House) {
            prev = houses[index];
            houses[index] = null;
            numHouses--;
            return prev;
        }
        return null;
    }

    /**
     * Checks if neighborhood is full.
     * @return true if the neighborhood is full/false otherwise.
     */
    public boolean isFull() {
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Counts number of @{code House} objects in the neighborhood.
     * @param houses the array of houses
     * @return number of houses in the neighborhood
     */
    private int validateHouseArray(House[] house) {
        int count = 0;
        for (int i = 0; i < house.length; i++) {
            if (house[i] instanceof House) {
                count++;
            }
        }
        return count;
    }
}
