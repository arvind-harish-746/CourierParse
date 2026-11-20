package exceptions;

// Thrown when a parcel's status is changed in an invalid order
public class IllegalStatusTransitionException extends Exception {
    public IllegalStatusTransitionException(String message) {
        super(message);
    }
}
