package model;

import java.util.ArrayList;
import java.util.List;

// Represents a parcel being tracked
public class Parcel {
    private String parcelId;
    private String senderName;
    private String receiverName;
    private double weight;
    private ParcelStatus status;
    private String assignedAgentId;
    private List<StatusLog> history;

    public Parcel(String parcelId, String senderName, String receiverName, double weight) {
        this.parcelId = parcelId;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.weight = weight;
        this.status = ParcelStatus.BOOKED;
        this.assignedAgentId = null;
        this.history = new ArrayList<>();
        this.history.add(new StatusLog(ParcelStatus.BOOKED));
    }

    public String getParcelId() {
        return parcelId;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public double getWeight() {
        return weight;
    }

    public ParcelStatus getStatus() {
        return status;
    }

    public String getAssignedAgentId() {
        return assignedAgentId;
    }

    public List<StatusLog> getHistory() {
        return history;
    }

    public void updateStatus(ParcelStatus newStatus) {
        this.status = newStatus;
        this.history.add(new StatusLog(newStatus));
    }

    public void assignAgent(String agentId) {
        this.assignedAgentId = agentId;
    }
}
