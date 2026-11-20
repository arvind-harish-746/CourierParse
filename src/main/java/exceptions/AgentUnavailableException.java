package exceptions;

// Thrown when no delivery agent is free
public class AgentUnavailableException extends Exception {
    public AgentUnavailableException(String message) {
        super(message);
    }
}
