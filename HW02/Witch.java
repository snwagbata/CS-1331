/**
 * This file defines the {@code Witch} object.
 * @author Somtochukwu Nwagbata
 * @version 1.0
 */
public class Witch extends TrickOrTreater {
    private String signatureSpell;
    private BlackCat companion;

    /**
     * Constructor for the {@code Witch} object.
     * @param name           The name of the {@code Witch} object.
     * @param neighborhood   The neighborhood of the {@code Witch} object.
     * @param numCandy       The number of candies the {@code Witch} object has.
     * @param signatureSpell The signature spell of the {@code Witch} object.
     * @param companion      The {@code BlackCat} object that the {@code Witch}
     *                       object is partnered with.
     */
    public Witch(String name, String neighborhood, int numCandy, String signatureSpell, BlackCat companion) {
        super(name, neighborhood, numCandy);
        this.signatureSpell = signatureSpell;
        this.companion = companion;
    }

    /**
     * Constructor for the {@code Witch} object.
     * @param name           The name of the {@code Witch} object.
     * @param signatureSpell The signature spell of the {@code Witch} object.
     * @param companion      The {@code BlackCat} object that the {@code Witch}
     *                       object is partnered with.
     */
    public Witch(String name, String signatureSpell, BlackCat companion) {
        this(name, "Godric's Hollow", 13, signatureSpell, companion);
    }

    /**
     * Constructor for the {@code Witch} object that creates a copy of the witch.
     * @param other The {@code Witch} object to be copied.
     */
    public Witch(Witch other) {
        this(other.name, other.neighborhood, other.numCandy, other.signatureSpell,
                new BlackCat(other.companion.getName(), other.companion.getFamiliar()));
    }

    /**
     * This method returns the signature spell of the {@code Witch} object.
     * @return The signature spell of the {@code Witch} object.
     */
    public String getSignatureSpell() {
        return signatureSpell;
    }

    /**
     * This method sets the signature spell of the {@code Witch} object.
     * @param signatureSpell The signature spell of the {@code Witch} object.
     */
    public void setSignatureSpell(String signatureSpell) {
        this.signatureSpell = signatureSpell;
    }

    /**
     * This method returns the {@code BlackCat} object that the {@code Witch} is
     * partnered with.
     * @return companion The {@code BlackCat} object that the {@code Witch} is
     *         partnered with.
     */
    public BlackCat getCompanion() {
        return companion;
    }

    /**
     * This method sets the {@code BlackCat} object that the {@code Witch} is
     * partnered with.
     * @param companion The {@code BlackCat} object that the {@code Witch} is
     *                  partnered with.
     */
    public void setCompanion(BlackCat companion) {
        this.companion = companion;
    }

    /**
     * This methods casts the signature spell of the {@code Witch} object. Also it
     * doeubles the witch's candies.
     */
    public void castSpell() {
        System.out.println(super.getName() + " casts " + signatureSpell + "!");
        //important the total candy is set before numCandy is doubled
        //this is due to the fact that the wrong numCandy will be set
        //their positions were switched
        super.setTotalCandy(numCandy);
        super.setNumCandy(numCandy);
    }
}
