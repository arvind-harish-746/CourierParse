package model;

// Represents a delivery agent
public class Agent extends Person {
    private String agentId;
    private boolean available = true;

    public Agent(String name, String phone, String agentId) {
        super(name, phone);
        this.agentId = agentId;
        this.available = true;
    }

    public String getAgentId() {
        return agentId;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String getRole() {
        return "Agent";
    }
}
