import java.util.ArrayList;
/**
 * Class describes Dwight, an employee in the office.
 * @author Somtochukwu Nwagbata
 * @version 1.0
 */
public class Dwight extends Employee {

    /**
     * Constructor for Dwight.
     */
    public Dwight() {
        super("Dwight Schrute", 74);
    }

    /**
     * Dwight's methods for checking if >50% of the department's have a fire
     * extinguisher.
     * @param o the office to be checked
     * @return true if >50% of the department's have a fire extinguisher
     */
    public boolean checkOffice(Office o) {
        int count = 0;
        for (int i = 0; i < o.getDepartments().size(); i++) {
            if (o.getDepartments().get(i).hasFireExtinguisher()) {
                count++;
            }
        }
        return ((double) count / (double) o.getDepartments().size()) >= 0.5;
    }

    /**
     * Dwight's method checking whether an employee is in the list of employees.
     * @param e the employee to be checked
     * @param employees the list of employees
     * @return true if the employee is in the list of employees
     */
    public boolean findEmployee(Employee e, ArrayList<Employee> employees) {
        // employees is assumed to be sorted so no need to use Collections to sort
        // Implement binary search for Employee e in ArrayList<Employee> employees
        int min = 0;
        int max = employees.size() - 1;
        while (min <= max) {

            int mid = min + ((max - min) / 2);

            if (employees.get(mid).compareTo(e) == 0) {
                return true;
            }

            // e is to the left of middle
            if (employees.get(mid).compareTo(e) < 0) {
                max = mid - 1;
            }

            // e is to the right of middle
            if (employees.get(mid).compareTo(e) > 0) {
                min = mid + 1;
            }

        }
        return false;
    }

    /**
     * Dwight's method for checking employees in a list are in the same office.
     * @param employees the list of employees
     * @param o the office to be checked
     * @return the list of employees not in the office
     */
    public ArrayList<Employee> doRecount(ArrayList<Employee> employees, Office o) {
        // put employees that are in office's arraylist but not employees into a new
        // arraylist
        ArrayList<Employee> newEmployees = o.getEmployees();

        for (int i = 0; i < employees.size(); i++) {
            if (findEmployee(employees.get(i), newEmployees)) {
                newEmployees.remove(employees.get(i));
            }
        }

        return newEmployees;
    }

    /**
     * toString method for Dwight.
     * @return Dwight's name and job
     */
    @Override
    public String toString() {
        return "My name is Dwight and I am the fire marshal";
    }

}