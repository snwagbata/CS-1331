/**
 * class for departments in the office.
 * @author Somtochukwu Nwagbata
 * @version 1.0
 */
public class Department {
    private String name;
    private boolean hasFireExtinguisher;

    /**
     * constructor for the department.
     * @param name name of the department
     * @param hasFireExtinguisher true if the department has a fire extinguisher
     */
    public Department(String name, boolean hasFireExtinguisher) {
        this.name = name;
        this.hasFireExtinguisher = hasFireExtinguisher;
    }

    /**
     * getter for if the department has a fire extinguisher.
     * @return true if the department has a fire extinguisher
     */
    public boolean hasFireExtinguisher() {
        return hasFireExtinguisher;
    }

}