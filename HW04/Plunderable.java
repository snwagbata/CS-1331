/**
 * Plunderable is an interface which is implemented when an object can be plundered.
 * @author Somtochukwu Nwagbata
 * @version 1.0
 */
public interface Plunderable {
    /**
     * Method to plunder an object.
     * @return an array of Loot objects that had been plundered.
     */
    Loot[] bePlundered();
}
