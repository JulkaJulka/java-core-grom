package lesson30.hw301;

import java.util.ArrayList;

/**
 * Created by user on 02.10.2017.
 */
public class Controller {
    private ArrayList<Employee> employeeArrayList;
    private ArrayList<Project> projectArrayList;
    private EmployeeDAO employeeDAO;
    private ProjectDAO projectDAO;
    private CustomerDAO customerDAO;

    public ArrayList<Employee> getEmployeeArrayList() {
        return employeeArrayList;
    }

    public void setEmployeeArrayList(ArrayList<Employee> employeeArrayList) {
        this.employeeArrayList = employeeArrayList;
    }

    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public EmployeeDAO getEmployeeDAO() {
        return employeeDAO;
    }

    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public ProjectDAO getProjectDAO() {
        return projectDAO;
    }

    public void setProjectDAO(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    public ArrayList<Project> getProjectArrayList() {
        return projectArrayList;
    }

    public void setProjectArrayList(ArrayList<Project> projectArrayList) {
        this.projectArrayList = projectArrayList;
    }

    public void employeesByProject(Project project){
        for (Employee empl: employeeDAO.getEmployeeArrayList()) {
            if(empl != null && empl.getProjects() != null && empl.getProjects().contains(project)){
                System.out.println(empl);
            }
        }
    }

    public void projectsByEmployee(Employee employee){
        for (Employee empl : employeeDAO.getEmployeeArrayList()) {
            if(empl != null && empl.equals(employee))
                System.out.println(empl.getProjects());
        }
    }

    public void employeesByDepartmentWithoutProject(Department department){
        for(Employee empl : employeeDAO.getEmployeeArrayList()){
            if(empl.getDepartment() == department && empl.getProjects() == null) {
                System.out.println(empl);
            }
        }
    }

    public void employeesWithoutProject(){
        for (Employee empl : employeeDAO.getEmployeeArrayList()){
            if(empl != null && empl.getProjects() == null)
                System.out.println(empl);
        }
    }

    public void employeesByTeamLead(Employee lead){


    }
    public void teamLeadsByEmployee(Employee employee){

    }
    public void employeesByProjectEmployee(Employee employee){
        ArrayList<Project> arrayList = new ArrayList<>();
        for (Employee empl : employeeDAO.getEmployeeArrayList()) {
            if(empl != null && empl.equals(employee))
                arrayList.equals(employee.getProjects());
        }
        ArrayList<Employee> employeesByProjectEmployee = new ArrayList<>();
        for (Employee empl : employeeDAO.getEmployeeArrayList())
            for (Project pr : arrayList){
            if(employeeDAO.getEmployeeArrayList().contains(pr)){

            }
            }


    }
    public void projectsByCustomer(Customer customer){
        for (Project pr : projectDAO.getProjectArrayList()){
            if(pr != null && pr.getCustomer().equals(customer))
                System.out.println(pr);
        }

    }
    public void employeesByCustomerProjects(Customer customer){


    }
}
