package model;

// Represents the parcel's delivery stage
public enum ParcelStatus {
    BOOKED,
    PICKED_UP,
    IN_TRANSIT,
    OUT_FOR_DELIVERY,
    DELIVERED;

    // Enforces the strict order of delivery stages
    public boolean canTransitionTo(ParcelStatus next) {
        switch (this) {
            case BOOKED:
                return next == PICKED_UP;
            case PICKED_UP:
                return next == IN_TRANSIT;
            case IN_TRANSIT:
                return next == OUT_FOR_DELIVERY;
            case OUT_FOR_DELIVERY:
                return next == DELIVERED;
            case DELIVERED:
            default:
                return false;
        }
    }
}
