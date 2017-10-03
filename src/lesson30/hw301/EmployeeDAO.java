package lesson30.hw301;

import java.util.ArrayList;

/**
 * Created by user on 02.10.2017.
 */
public class EmployeeDAO {
    private ArrayList<Employee> employeeArrayList;

    public EmployeeDAO() {

    }

    public EmployeeDAO(ArrayList<Employee> employeeArrayList) {
        this.employeeArrayList = employeeArrayList;
    }

    public ArrayList<Employee> getEmployeeArrayList() {
        return employeeArrayList;
    }

    public void setEmployeeArrayList(ArrayList<Employee> employeeArrayList) {
        this.employeeArrayList = employeeArrayList;
    }
}
