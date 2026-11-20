package exceptions;

// Thrown when a parcel ID doesn't exist
public class ParcelNotFoundException extends Exception {
    public ParcelNotFoundException(String message) {
        super(message);
    }
}
