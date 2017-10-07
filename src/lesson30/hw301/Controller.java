package lesson30.hw301;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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

    public void employeesByProject(Project project) {
        for (Employee empl : employeeDAO.getEmployeeArrayList()) {
            if (empl != null && empl.getProjects() != null && empl.getProjects().contains(project)) {
                System.out.println(empl);
            }
        }
    }

    public void projectsByEmployee(Employee employee) {
        for (Employee empl : employeeDAO.getEmployeeArrayList()) {
            if (empl != null && empl.equals(employee))
                System.out.println(empl.getProjects());
        }
    }

    public void employeesByDepartmentWithoutProject(Department department) {
        for (Employee empl : employeeDAO.getEmployeeArrayList()) {
            if (empl.getDepartment() == department && empl.getProjects() == null) {
                System.out.println(empl);
            }
        }
    }

    public void employeesWithoutProject() {
        for (Employee empl : employeeDAO.getEmployeeArrayList()) {
            if (empl != null && empl.getProjects() == null)
                System.out.println(empl);
        }
    }

    public void employeesByTeamLead(Employee lead) throws Exception {
        if (lead == null) {
            throw new Exception("Such lead doesn't exist in DB");
        }
        if (lead.getProjects() == null)
            throw new Exception("Lead hasn't any employees");
        Set<Employee> employeeSet = new HashSet<>();
        for (Employee empl : employeeDAO.getEmployeeArrayList()) {
            for (Project pr : lead.getProjects())
                if (empl != null && pr != null && !empl.getPosition().equals(Position.TEAM_LEAD)
                        && empl.getProjects() != null && empl.getProjects().contains(pr)) {
                    employeeSet.add(empl);
                }
        }
        System.out.println(employeeSet);


    }

    public void teamLeadsByEmployee(Employee employee) {
        Set<Employee> employeeSet = new HashSet<>();
        for (Employee empl : employeeDAO.getEmployeeArrayList()){
            for (Project pr : employee.getProjects()){
                if(empl != null && pr != null && employee.getProjects() != null
                        && empl.getPosition() != null && empl.getPosition().equals(Position.TEAM_LEAD)
                        && empl.getProjects() != null
                        && empl.getProjects().contains(pr) ){
                    employeeSet.add(empl);
                }
            }
        }
        System.out.println(employeeSet);

    }

    public void employeesByProjectEmployee(Employee employee) {

        Set<Employee> employeesByProjectEmployee = new HashSet<>();
        for (Employee empl : employeeDAO.getEmployeeArrayList()) {
            for (Project pr : employee.getProjects()) {
                if (empl != null && pr != null && !empl.equals(employee) && empl.getProjects() != null &&
                        empl.getProjects().contains(pr)) {
                    employeesByProjectEmployee.add(empl);
                }

            }
        }
        System.out.println(employeesByProjectEmployee.toString());

    }

    public void projectsByCustomer(Customer customer) {
        for (Project pr : projectDAO.getProjectArrayList()) {
            if (pr != null && pr.getCustomer().equals(customer))
                System.out.println(pr);
        }

    }

    public void employeesByCustomerProjects(Customer customer) {
        Set<Employee> employeeSet = new HashSet<>();
        for (Employee empl : employeeDAO.getEmployeeArrayList()) {
            for (Project pr : projectDAO.getProjectArrayList()) {
                if (empl != null && pr != null && pr.getCustomer().equals(customer)) {
                    employeeSet.add(empl);
                }
            }

        }
        System.out.println(employeeSet.toString());
    }


}
