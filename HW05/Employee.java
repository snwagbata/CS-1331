/**
 * This file represents an employee.
 * @author Somtochukwu Nwagbata
 * @version 1.0
 */
public class Employee implements Comparable<Employee> {
    private String name;
    private int height;

    /**
     * Constructor for objects of class Employee.
     * @param name The name of the employee.
     * @param height The height of the employee.
     */
    public Employee(String name, int height) {
        this.name = name;
        this.height = height;
    }

    /**
     * Implement the compareTo method to compare employees by height.
     * @param o the other employee
     * @return -1 if this employee is shorter, 1 if this employee is taller, 0 if
     *         they are the same height
     */
    @Override
    public int compareTo(Employee o) {
        if (this.height > o.height) {
            return 1;
        } else if (this.height < o.height) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * equals method to compare employees.
     * @param obj object to compare
     * @return true if the employees are the same, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Employee) {
            Employee e = (Employee) obj;
            return this.name.equals(e.name) && this.height == e.height;
        }
        return false;
    }

    /**
     * toString method to print the employee.
     * @return the employee's name and height
     */
    @Override
    public String toString() {
        return String.format("My name is %s and I am %d inches tall", name, height);
    }

}
