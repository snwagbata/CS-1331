/**
 * This file represents any Tournament that UEFA runs.
 * @author Somtochukwu Nwagbata
 * @version 1.0
 */
public abstract class Tournament {
    private String name, finalReferee;
    private int numTeams;
    private boolean knockout;
    protected int maxCapacity;
    private static final int FINAL_CAPACITY = 30000;

    /**
     * Constructor for objects of class Tournament.
     * @param name         The name of the tournament
     * @param finalReferee The name of the final referee
     * @param numTeams     The number of teams in the tournament
     * @param knockout     Whether the tournament is knockout or not
     * @param maxCapacity  The maximum capacity of the tournament
     */
    public Tournament(String name, int numTeams, boolean knockout, String finalReferee, int maxCapacity) {
        this.name = name;
        setNumTeams(numTeams);
        this.finalReferee = finalReferee;
        this.knockout = knockout;
        // Set knockout to truw if numTeams is greater than 64
        if (numTeams > 64 && !knockout) {
            this.knockout = true;
        }
        this.maxCapacity = maxCapacity;
    }

    /**
     * Private method to set the number of teams in the tournament and ensure it is
     * even.
     * @param numTeams The number of teams in the tournament
     */
    private void setNumTeams(int numTeams) {
        if (numTeams % 2 != 0) {
            this.numTeams = 16;
        } else {
            this.numTeams = numTeams;
        }
    }

    /**
     * Getter for the name of the tournament.
     * @return The name of the tournament
     */
    protected String getName() {
        return name;
    }

    /**
     * Getter for the number of teams in the tournament.
     * @return The number of teams in the tournament
     */
    protected int getNumTeams() {
        return numTeams;
    }

    /**
     * Getter for the final referee of the tournament.
     * @return The final referee of the tournament
     */
    protected String getFinalReferee() {
        return finalReferee;
    }

    /**
     * Getter for the knockout status of the tournament
     * @return The knockout status of the tournament
     */
    protected boolean isKnockout() {
        return knockout;
    }

    /**
     * Getter for the final capacity of the tournament.
     * @return The final capacity of the tournament
     */
    protected int getFinalCapacity() {
        return FINAL_CAPACITY;
    }

    /**
     * Setter for the final referee of the tournament.
     * @param finalReferee The final referee of the tournament
     */
    protected void setFinalReferee(String finalReferee) {
        this.finalReferee = finalReferee;
    }

    /**
     * Method for halfing the number of teams in the tournament
     * after each round.
     */
    protected void halfNumTeams() {
        this.numTeams /= 2;
    }

    /**
     * abstract method to be implemented by subclasses for hiring referees.
     * @param refereeName The referee to be hired
     */
    public abstract void refereeHire(String refereeName);

    /**
     * overridden toString method to print the tournament details.
     * @return The tournament details
     */
    public String toString() {
        return String.format(
                "Name: %s, Number of Teams: %d, KO: this" + (knockout ? "is" : "isn't")
                        + "a KO tournament, Final Referee: %s, Maximum Capacity: %d",
                name, numTeams, finalReferee, maxCapacity);
    }

    /**
     * overridden equals method to compare two tournaments.
     * @param obj The other tournament to compare to
     * @return Whether the two tournaments are equal or not
     */
    public boolean equals(Object obj) {
        if (obj instanceof Tournament) {
            Tournament other = (Tournament) obj;
            return name.equals(other.name) && numTeams == other.numTeams && knockout == other.knockout;
        } else {
            return false;
        }
    }
}