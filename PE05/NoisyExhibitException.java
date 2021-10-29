/**
 * This file defines the NoisyExhibitException class.
 * @author Somtochukwu Nwagbata
 * @version 1.0
 */
public class NoisyExhibitException extends RuntimeException {
    /**
     * Constructs a NoisyExhibitException with detail message.
     */
    public NoisyExhibitException() {
        super("The animals are too noisy!");
    }
}