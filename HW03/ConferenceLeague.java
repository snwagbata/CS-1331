/**
 * This class describes the second of UEFA’s new tournaments, Conference League.
 * This class will inherit from the Tournaments class.
 * @author Somtochukwu Nwagbata
 * @version 1.0
 */
public class ConferenceLeague extends Tournament {
    private int teamsPerLeague;
    private String currentHolder;

    /**
     * This is the constructor for the ConferenceLeague class.
     * @param finalReferee The referee for the tournament.
     * @param teamsPerLeague The number of teams in each league.
     * @param currentHolder The current holder of the trophy.
     */
    public ConferenceLeague(String finalReferee, int teamsPerLeague, String currentHolder) {
        super("Conference League", 32, true, finalReferee, 15000);
        this.teamsPerLeague = teamsPerLeague;
        this.currentHolder = currentHolder;
    }

    /**
     * overrides refereeHire() from the Tournament class.
     * @param refereeName The referee to be hired.
     */
    public void refereeHire(String refereeName) {
        if (getFinalReferee().equals(refereeName)) {
            System.out.println("We need a new referee!");
            setFinalReferee(refereeName);
        } else {
            System.out.println("We’re ready to go!");
            maxCapacity *= 2;
        }
    }

    /**
     * Called after each game to half the number of teams.
     * Also sets maxCapacity to FINAL_CAPACITY if the last match.
     */
    public void nextRound() {
        if (isKnockout()) {
            if (getNumTeams() > 2) {
                halfNumTeams();
            } else {
                System.out.println("We have reached the final!");
                if (maxCapacity > getFinalCapacity()) {
                    maxCapacity = getFinalCapacity();
                }
            }
        }
    }

    /**
     * overridden equals method to compare two ConferenceLeague objects.
     * @param obj The object to be compared.
     * @return true if the objects are equal, false otherwise.
     */
    public boolean equals(Object obj) {
        if (obj instanceof ConferenceLeague) {
            ConferenceLeague other = (ConferenceLeague) obj;
            return getFinalReferee().equals(other.getFinalReferee()) && currentHolder.equals(other.currentHolder);
        }
        return false;
    }

    /**
     * overridden toString method to print out the ConferenceLeague object.
     * @return The string representation of the ConferenceLeague object.
     */
    public String toString() {
        return String.format(
                "Name: %s, Number of Teams: %d, Final Referee: %s, Teams per League: %d, Current Holder: %s", getName(),
                getNumTeams(), getFinalReferee(), teamsPerLeague, currentHolder);
    }

}
