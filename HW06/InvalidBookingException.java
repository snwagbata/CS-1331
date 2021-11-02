/**
 * This class describes a checked exception.
 * @author Somtochukwu Nwagbata
 * @version 1.0
 */
public class InvalidBookingException extends Exception {
    /**
     * 1-arg constructor that takes a message.
     * @param message the message to be displayed.
     */
    public InvalidBookingException(String message) {
        super(message);
    }

    /**
     * No-arg constructor.
     */
    public InvalidBookingException() {
        super("Invalid booking type");
    }
}