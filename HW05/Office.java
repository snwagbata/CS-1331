import java.util.ArrayList;
/**
 * This class represents an office.
 * @author Somtochukwu Nwagbata
 * @version 1.0
 */
public class Office {
    private String name;
    private ArrayList<Department> departments;
    private ArrayList<Employee> employees;

    /**
     * Constructor for objects of class Office.
     * @param name The name of the office
     */
    public Office(String name) {
        this.name = name;
        departments = new ArrayList<Department>();
        employees = new ArrayList<Employee>();
    }

    /**
     * Adds a department to the office.
     * @param department The department to be added
     */
    public void addDepartment(Department department) {
        departments.add(department);
    }

    /**
     * Adds an employee to the office.
     * @param employee The employee to be added
     */
    public void addEmployee(Employee employee) {
        // Note that the employee list should always be sorted
        // by descending height and that no two employees are the same height.
        if (employees.size() == 0) {
            employees.add(employee);
            return;
        }

        if (employees.size() == 1) {
            if (employees.get(0).compareTo(employee) < 0) {
                employees.add(0, employee);
                return;
            } else {
                employees.add(1, employee);
                return;
            }
        }

        for (int i = 1; i < employees.size(); i++) {
            if (employees.get(i - 1).compareTo(employee) > 0 && employees.get(i).compareTo(employee) < 0) {
                employees.add(i, employee);
                return;
            } else if (employees.get(i - 1).compareTo(employee) < 0 && employees.get(i).compareTo(employee) < 0) {
                employees.add(i - 1, employee);
                return;
            } else if (employees.get(i).compareTo(employee) > 0 && (i == employees.size() - 1)) {
                employees.add(employee);
                return;
            }
        }
    }

    /**
     * Removes an employee from the office.
     * @param employee The employee to be removed
     * @return removed employee
     */
    public Employee removeEmployee(Employee employee) {
        // ArrayList.contains() method uses employee's equals() method to check if the
        // employee is in the list
        if (employees.contains(employee)) {
            Employee removedEmployee = employee;
            employees.remove(employee);
            return removedEmployee;
        }
        return null;
    }

    /**
     * Get the office's departments.
     * @return The office's departments
     */
    public ArrayList<Department> getDepartments() {
        return departments;
    }

    /**
     * Get the office's employees.
     * @return The office's employees
     */
    public ArrayList<Employee> getEmployees() {
        return employees;
    }
}
