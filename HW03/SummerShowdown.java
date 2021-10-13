/**
 * This class describes one of UEFA’s new tournaments, Summer Showdown. This
 * class will inherit from the Tournament class
 * @author Somtochukwu Nwagbata
 * @version 1.0
 */
public class SummerShowdown extends Tournament {
    private String backupReferee;

    /**
     * Constructor for objects of class SummerShowdown.
     * @param numTeams      the number of teams in the tournament
     * @param finalReferee  the final referee for the tournament
     * @param knockout      the knockout stage of the tournament
     * @param maxCapacity   the maximum capacity of the tournament
     * @param backupReferee the backup referee for the tournament
     */
    public SummerShowdown(int numTeams, boolean knockout, String finalReferee, int maxCapacity, String backupReferee) {
        super("Summer Showdown", numTeams, knockout, finalReferee, maxCapacity);
        this.backupReferee = backupReferee;
    }

    /**
     * Constructor for objects of class SummerShowdown that only takes finalReferee
     * and backupReferee.
     * @param finalReferee  the final referee for the tournament
     * @param backupReferee the backup referee for the tournament
     */
    public SummerShowdown(String finalReferee, String backupReferee) {
        this(64, false, finalReferee, 20000, backupReferee);
    }

    /**
     * overrides refereeHire() from the Tournament class.
     * @param refereeName The referee to be hired.
     */
    public void refereeHire(String refereeName) {
        if (refereeName.equals(getFinalReferee())) {
            System.out.println("We need a new referee! " + backupReferee + " is already refereeing the final!");
            backupReferee = "Undecided";
        } else if (refereeName.equals(backupReferee)) {
            System.out.println("Be ready for some conflicts!");
            maxCapacity /= 2;
        } else {
            System.out.println("Ready to play!");
        }
    }

    /**
     * Overrides the equals() method from the Object class.
     * @param obj the object to be compared to
     * @return true if the objects are equal, false otherwise
     */
    public boolean equals(Object obj) {
        if (obj instanceof SummerShowdown) {
            SummerShowdown other = (SummerShowdown) obj;
            return getFinalReferee().equals(other.getFinalReferee()) && this.backupReferee.equals(other.backupReferee);
        }
        return false;
    }

    /**
     * Overrides the toString() method from the Tournament class.
     * @return a string representation of the Summer Showdown tournament
     */
    public String toString() {
        return String.format(
                "Name: %s, Number of Teams: %d, Final Referee: %s, Backup Referee: %s, Maximum Capacity: %d", getName(),
                getNumTeams(), getFinalReferee(), backupReferee, maxCapacity);
    }
}
