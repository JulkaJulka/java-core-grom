package lesson30.hw301;

import java.util.ArrayList;

/**
 * Created by user on 02.10.2017.
 */
public class Department {
   private DepartmentType type;
   private ArrayList<Employee> employees;

    public Department(DepartmentType type, ArrayList<Employee> employees) {
        this.type = type;
        this.employees = employees;
    }

    public DepartmentType getType() {
        return type;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "type=" + type +
                ", employees=" + employees +
                '}';
    }
}
