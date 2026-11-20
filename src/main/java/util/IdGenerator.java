package util;

// Generates unique IDs for parcels and agents
public class IdGenerator {
    private static int parcelCount = 0;
    private static int agentCount = 0;

    private IdGenerator() {
    }

    public static String generateParcelId() {
        parcelCount++;
        return "PCL" + parcelCount;
    }

    public static String generateAgentId() {
        agentCount++;
        return "AGT" + agentCount;
    }
}
