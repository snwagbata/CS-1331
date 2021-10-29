/**
 * This file defines the AnimalNotAllowedException class.
 * @author Somtochukwu Nwagbata
 * @version 1.0
 */
public class AnimalNotAllowedException extends Exception {
    /**
     * Constructor for the AnimalNotAllowedException class.
     * @param message The message to be displayed.
     */
    public AnimalNotAllowedException(String message) {
        super(message);
    }
}