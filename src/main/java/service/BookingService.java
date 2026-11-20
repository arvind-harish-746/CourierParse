package service;

import exceptions.AgentUnavailableException;
import exceptions.IllegalStatusTransitionException;
import exceptions.ParcelNotFoundException;
import model.Agent;
import model.Parcel;
import model.ParcelStatus;
import util.IdGenerator;

// Handles booking new parcels and cancelling them before pickup
public class BookingService {
    private ParcelService parcelService;
    private AgentService agentService;

    public BookingService(ParcelService parcelService, AgentService agentService) {
        this.parcelService = parcelService;
        this.agentService = agentService;
    }

    public Parcel bookParcel(String sender, String receiver, double weight) throws AgentUnavailableException {
        String parcelId = IdGenerator.generateParcelId();
        Parcel parcel = new Parcel(parcelId, sender, receiver, weight);
        Agent agent = agentService.getNextAvailableAgent();
        parcel.assignAgent(agent.getAgentId());
        parcelService.addParcel(parcel);
        return parcel;
    }

    public void cancelParcel(String parcelId) throws ParcelNotFoundException, IllegalStatusTransitionException {
        Parcel parcel = parcelService.getParcel(parcelId);
        if (parcel.getStatus() != ParcelStatus.BOOKED) {
            throw new IllegalStatusTransitionException("Only parcels in BOOKED status can be cancelled");
        }
        agentService.releaseAgent(parcel.getAssignedAgentId());
        System.out.println("Parcel " + parcelId + " has been cancelled");
    }
}
