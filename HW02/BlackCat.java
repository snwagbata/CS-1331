/**
 * This file defines the BlackCat object.
 * @author Somtochukwu Nwagbata
 * @version 1.0
 */
public class BlackCat {
    private String name;
    private boolean familiar;

    /**
     * Constructor for objects of class BlackCat.
     * @param name the name of the cat
     * @param familiar whether the cat is familiar
     */
    public BlackCat(String name, boolean familiar) {
        this.name = name;
        this.familiar = familiar;
    }

    /**
     * Returns the name of the cat.
     * @return the name of the cat
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of the cat.
     * @param name the name of the cat
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns whether the cat is familiar.
     * @return whether the cat is familiar
     */
    public boolean isFamiliar() {
        return familiar;
    }

    /**
     * Sets whether the cat is familiar.
     * @param familiar whether the cat is familiar
     */
    public void setFamiliar(boolean familiar) {
        this.familiar = familiar;
    }

    /**
     * Prints whether the cat is familiar.
     */
    public void meow() {
        System.out.println(name + (familiar ? " is a familiar" : "  is not a familiar"));
    }

}
