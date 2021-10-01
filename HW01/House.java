/**
 * This file defines the House object.
 * @author Somtochukwu Nwagbata
 * @version 1.0
 * @since 2021-09-26
 */
public class House {
    private String address;
    private int yearBuilt;
    private double numBaths;
    private boolean isRenovated;

    /**
     * Main constructor for House object.
     * @param address    the address of the house
     * @param yearBuilt  the year the house was built
     * @param numBaths   the number of bathrooms in the house
     * @param isRenovated  whether the house has been renovated
     */
    public House(String address, int yearBuilt, double numBaths, boolean isRenovated) {
        this.address = address;
        this.yearBuilt = yearBuilt;
        this.numBaths = numBaths;
        this.isRenovated = isRenovated;
    }

    /**
     * Constructor for House object that only takes in the {@code address} and {@code numBaths}.
     * @param address the address of the house
     * @param numBaths the number of bathrooms in the house
     */
    public House(String address, double numBaths) {
        this(address, 1984, numBaths, false);
    }

    /**
     * Constructor for the House object that takes no params.
     */
    public House() {
        this("North Ave NW, Atlanta, GA 30332", 1984, 1.0, false);
    }

    /**
     * Getter for the {@code address} field.
     * @return the address of the house
     */
    public String getAddress() {
        return address;
    }

    /**
     * Getter for the {@code yearBuilt} field.
     * @return the year the house was built
     */
    public int getYearBuilt() {
        return yearBuilt;
    }

    /**
     * Getter for the {@code numBaths} field.
     * @return the number of bathrooms in the house
     */
    public double getNumBaths() {
        return numBaths;
    }

    /**
     * Getter for the {@code isRenovated} field.
     * @return whether the house has been renovated
     */
    public boolean getIsRenovated() {
        return isRenovated;
    }

    /**
     * Setter for the {@code address} field.
     * @param address the address of the house
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Setter for the {@code yearBuilt} field.
     * @param yearBuilt the year the house was built
     */
    public void setYearBuilt(int yearBuilt) {
        if (yearBuilt >= 0) {
            this.yearBuilt = yearBuilt;
        }
    }

    /**
     * Setter for the {@code numBaths} field.
     * @param numBaths the number of bathrooms in the house
     */
    public void setNumBaths(double numBaths) {
        if (numBaths / 0.5 == 0.0 && numBaths >= 0) {
            this.numBaths = numBaths;
        }
    }

    /**
     * Setter for the {@code isRenovated} field.
     * @param isRenovated whether the house has been renovated
     */
    public void setIsRenovated(boolean isRenovated) {
        this.isRenovated = isRenovated;
    }
}
