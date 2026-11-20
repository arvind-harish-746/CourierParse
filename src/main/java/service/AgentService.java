package service;

import datastructures.CircularAgentQueue;
import exceptions.AgentUnavailableException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import model.Agent;
import util.IdGenerator;

// Manages agent registration and assignment using the circular queue
public class AgentService {
    private Map<String, Agent> agents = new HashMap<>();
    private CircularAgentQueue availableQueue = new CircularAgentQueue(50);

    public Agent registerAgent(String name, String phone) {
        String agentId = IdGenerator.generateAgentId();
        Agent agent = new Agent(name, phone, agentId);
        agents.put(agentId, agent);
        availableQueue.enqueue(agentId);
        return agent;
    }

    public Agent getNextAvailableAgent() throws AgentUnavailableException {
        String agentId = availableQueue.dequeue();
        if (agentId == null) {
            throw new AgentUnavailableException("No delivery agent available right now");
        }
        Agent agent = agents.get(agentId);
        if (agent != null) {
            agent.setAvailable(false);
        }
        return agent;
    }

    public void releaseAgent(String agentId) {
        if (agentId == null) {
            return;
        }
        Agent agent = agents.get(agentId);
        if (agent == null) {
            return;
        }
        agent.setAvailable(true);
        availableQueue.enqueue(agentId);
    }

    public Collection<Agent> listAgents() {
        return agents.values();
    }
}
