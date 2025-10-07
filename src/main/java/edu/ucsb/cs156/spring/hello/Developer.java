package edu.ucsb.cs156.spring.hello;

/**
 * A class with static methods to provide information about the developer.
 */

public class Developer {

    // This class is not meant to be instantiated
    // so we make the constructor private

    private Developer() {}

    /**
     * Get the name of the developer
     */

    public static String getName() {
        return "Nataly G.";
    }

    /**
     * Get the github id of the developer
     * @return github id of the developer
     */

    public static String getGithubId() {
        return "n-ornelas";
    }

    /**
     * Get the developers team
     * @return developers team as a Java object
     */

    public static Team getTeam() {
        Team team = new Team("f25-13");
        team.addMember("Amy L.");
        team.addMember("Tim C.");
        team.addMember("Yulin Y.");
        team.addMember("Hao D.");
        team.addMember("Jackson C.");
        team.addMember("Nataly G.");
        return team;
    }
}
