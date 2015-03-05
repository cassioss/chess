package exception;

/**
 * <strong>InGameException</strong> class - called whenever a piece is set or created after a view has already begun,
 * regardless of having a piece at the same square or not.
 */
public class InGameException extends RuntimeException {

    /**
     * Throws an InGameException and returns a message to the user.
     *
     * @param message an error message related to the exception clause.
     */
    public InGameException(String message) {
        super(message);
    }
}