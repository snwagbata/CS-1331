/**
 * This class represents the valuable cash crop of sugaras loot, a frequently pirated commodity.
 * @author Somtochukwu Nwagbata
 * @version 1.0
 */
public class Sugar extends Loot {
    private double amount, sweetness;

    /**
     * Constructor for objects of class Sugar.
     * @param amount the amount of sugar in the loot
     * @param sweetness the sweetness of the sugar
     */
    public Sugar(double amount, double sweetness) {
        this.amount = amount;
        if (sweetness >= 0 && sweetness <= 100) {
            this.sweetness = sweetness;
        } else {
            this.sweetness = 0;
        }
        setValue(amount * sweetness);
    }

    /**
     * Equality checker for two Sugar objects.
     * @param obj the other object to compare to
     * @return true if the two objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Sugar) {
            Sugar sugar = (Sugar) obj;
            return super.equals(sugar) && this.amount == sugar.amount && this.sweetness == sugar.sweetness;
        }
        return false;
    }

    /**
     * A string representation of the Sugar object.
     * @return a string representation of the Sugar object
     */
    @Override
    public String toString() {
        return String.format("A pile of sugar of size %.1f and sweetness %.1f.", amount, sweetness);
    }
}
