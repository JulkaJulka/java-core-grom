package lesson30.hw301;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by user on 02.10.2017.
 */
public class Demo {
    public static void main(String[] args) throws Exception {

        ArrayList<Employee> employeeArrayList = new ArrayList<>();

        Employee employee1 = new Employee("Yuliia", "Petrova", new Date(), Position.DEVELOPER, null,null );
        Employee employee2 = new Employee("Oleg", "Petrova", new Date(), Position.TEAM_LEAD, null,null );
        employeeArrayList.add(employee1);
        employeeArrayList.add(employee2);

        ArrayList<Customer> customerArrayList = new ArrayList<>();

        Customer customer1 = new Customer("GoUp" , "Ukraine", 3000);
        Customer customer2 = new Customer("Nakame", "Ukraine", 4000);
        customerArrayList.add(customer1);
        customerArrayList.add(customer2);

        ArrayList<Project> projectArrayList = new ArrayList<>();
        ArrayList<Project> projectArrayList2 = new ArrayList<>();
        ArrayList<Project> projectArrayList3 = new ArrayList<>();

        Project project1 = new Project("Project1", customer1);
        Project project2 = new Project("Project2", customer2);
        Project project3 = new Project("Project3", customer1);
        projectArrayList.add(project1);
        projectArrayList.add(project2);
        projectArrayList.add(project3);

        projectArrayList2.add(project3);
        projectArrayList2.add(project2);
        projectArrayList3.add(project3);
       // Department department1 = new Department(DepartmentType.DEVELOPER, null, );
       // Employee employee1 = new Employee("Yuliia", "Petrova", new Date(), Position.DEVELOPER, null,null );


        EmployeeDAO employeeDAO1 = new EmployeeDAO();
        ProjectDAO projectDAO1 = new ProjectDAO();
        CustomerDAO customerDAO1 = new CustomerDAO();

        employeeDAO1.setEmployeeArrayList(employeeArrayList);
        projectDAO1.setProjectArrayList(projectArrayList);
        customerDAO1.setCustomerArrayList(customerArrayList);


        Controller controller = new Controller();

        controller.setCustomerDAO(customerDAO1);
        controller.setEmployeeDAO(employeeDAO1);
        controller.setProjectDAO(projectDAO1);



        Employee employee3 = new Employee("Oleg3", "Petrova", new Date(), Position.TEAM_LEAD, null, projectArrayList );
        employeeArrayList.add(employee3);

        Employee employee6 = new Employee("Oleg6", "Petrova", new Date(), Position.TEAM_LEAD, null, projectArrayList2 );
        employeeArrayList.add(employee6);

        Employee employee7 = new Employee("Oleg7", "Petrova", new Date(), Position.DEVELOPER, null, projectArrayList2 );
        employeeArrayList.add(employee7);

        Employee employee8 = new Employee("Oleg8", "Petrova", new Date(), Position.DEVELOPER, null, projectArrayList3 );
        employeeArrayList.add(employee8);


        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee3);
        Department department1 = new Department(DepartmentType.DEVELOPER, employees);

        System.out.println("---Test1_employeeByProject");
        controller.employeesByProject(project1);
        System.out.println();

        System.out.println("---Test2_projectsByEmployee");
        controller.projectsByEmployee(employee3);
        System.out.println();

        System.out.println("---Test3_employeesByDepartmentWithoutProject()");
        Employee employee4 = new Employee("Oleg4", "Petrova", new Date(), Position.DEVELOPER, department1, projectArrayList );
        Employee employee5 = new Employee("Oleg5", "Petrova", new Date(), Position.DEVELOPER, department1, null );
        employeeArrayList.add(employee4);
        employeeArrayList.add(employee5);
        controller.employeesByDepartmentWithoutProject(department1);
        System.out.println();

        System.out.println("Test4_employeesWithoutProject");
        controller.employeesWithoutProject();
        System.out.println();

        System.out.println("Test5_projectsByCustomer");
        controller.projectsByCustomer(customer1);
        System.out.println();

                           System.out.println("---Test6_employeesByProjectEmployee");
        System.out.println("empl7 " + employee7.toString());
        controller.employeesByProjectEmployee(employee7);
        System.out.println();

        System.out.println("---Test6_employeesByCustomerProjects");
controller.employeesByCustomerProjects(customer1);
        System.out.println();

        System.out.println("---Test8_employeesByTeamLead");
        controller.employeesByTeamLead(employee6);
        System.out.println();

        System.out.println("---Test9_teamLeadsByEmployee");
        controller.teamLeadsByEmployee(employee7);
    }
}
