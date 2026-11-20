package service;

import exceptions.ParcelNotFoundException;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import model.Parcel;

// Stores parcels in sorted order by ID using a TreeMap
public class ParcelService {
    private Map<String, Parcel> parcels = new TreeMap<>();

    public void addParcel(Parcel parcel) {
        parcels.put(parcel.getParcelId(), parcel);
    }

    public Parcel getParcel(String parcelId) throws ParcelNotFoundException {
        Parcel parcel = parcels.get(parcelId);
        if (parcel == null) {
            throw new ParcelNotFoundException("Parcel not found: " + parcelId);
        }
        return parcel;
    }

    public Collection<Parcel> listAllParcels() {
        return parcels.values();
    }
}
