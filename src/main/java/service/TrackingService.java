package service;

import exceptions.IllegalStatusTransitionException;
import exceptions.ParcelNotFoundException;
import java.util.List;
import model.Parcel;
import model.ParcelStatus;
import model.StatusLog;

// Handles moving a parcel through its delivery stages and viewing its history
public class TrackingService {
    private ParcelService parcelService;
    private AgentService agentService;

    public TrackingService(ParcelService parcelService, AgentService agentService) {
        this.parcelService = parcelService;
        this.agentService = agentService;
    }

    public void updateStatus(String parcelId, ParcelStatus newStatus)
            throws ParcelNotFoundException, IllegalStatusTransitionException {
        Parcel parcel = parcelService.getParcel(parcelId);
        if (!parcel.getStatus().canTransitionTo(newStatus)) {
            throw new IllegalStatusTransitionException(
                    "Cannot move parcel from " + parcel.getStatus() + " to " + newStatus);
        }
        parcel.updateStatus(newStatus);
        if (newStatus == ParcelStatus.DELIVERED) {
            agentService.releaseAgent(parcel.getAssignedAgentId());
        }
    }

    public List<StatusLog> viewHistory(String parcelId) throws ParcelNotFoundException {
        Parcel parcel = parcelService.getParcel(parcelId);
        return parcel.getHistory();
    }
}
