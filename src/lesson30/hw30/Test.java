package lesson30.hw30;

import java.util.ArrayList;

/**
 * Created by user on 29.09.2017.
 */
public class Test {
    public static void main(String[] args) {

        ArrayList<Project> projectsArrayList = new ArrayList<>();
        ArrayList<Employer> employerArrayList = new ArrayList<>();
        //Manager manager1 = new Manager(1000, 21, "Yuliia", "2016", Department.PROGRAMMER,
        //        EmployerType.ManagerEmpl, 3000, projectsArrayList);

       // Project project4 = new Project(200, "Test1",null);
       // Project project2 = new Project(201, "Test2" , manager1);

     //   employerArrayList.add(employer1);
      //  employerArrayList.add(manager1);

        Manager manager1 = new Manager(1000, 21, "Yuliia", "2016", Department.PROGRAMMER,
                EmployerType.ManagerEmpl, 3000, null);
        Customer customer1 = new Customer(3001,"Google", null);



        Project project1 = new Project(200, "Test1" , customer1, employerArrayList );
        Project project2 = new Project(201, "Test2", null, employerArrayList);
        projectsArrayList.add(project1);
        projectsArrayList.add(project2);



        Employer employer1 = new Employer(1000, 21, "Yuliia", "2016", Department.PROGRAMMER,
                EmployerType.NonManagerEmpl, 3000, projectsArrayList);
        employerArrayList.add(employer1);
        employerArrayList.add(manager1);

        System.out.println("project : " + projectsArrayList.toString());


        ArrayList<Project> projectsArrayList1 = new ArrayList<>();
        ArrayList<Employer> employerOfProjectArrayList1 = new ArrayList<>();
        Employer employer2 = new Employer(1001, 21, "Yuliia", "2016", Department.PROGRAMMER,
                EmployerType.NonManagerEmpl, 3000, projectsArrayList);
        Employer employer3 = new Employer(1002, 21, "Yuliia", "2016", Department.FINANCE,
                EmployerType.NonManagerEmpl, 3000, null);
        employerArrayList.add(employer2);
        employerArrayList.add(employer3);






        //System.out.println(projectsArrayList.toString());

        ControllerDAO controllerDAO = new ControllerDAO();
        controllerDAO.setProjects(projectsArrayList);
        controllerDAO.setEmployerArrayList(employerArrayList);



        System.out.println("---Test1_ListEmployeeOnProject");
        controllerDAO.listEmployeeOnProject(project1);
        System.out.println();

        System.out.println("---Test2_ListProjectsOfEmployer");
        controllerDAO.listProjetsOfEmployer(employer1);
        System.out.println();

        System.out.println("--Test3_ListUninvolvedEmployeeOfDepartments");
        controllerDAO.listUninvolvedEmployersOfDepartment(Department.FINANCE);
        System.out.println();

        System.out.println("Test4_listUninvolvedEmployersOnProjects");
        controllerDAO.listUninvolvedEmployersOnProjects();
        System.out.println();

        System.out.println("---Test5_listProjectsByCustomer");
        controllerDAO.listProjectsByCustomer(customer1);


        //controllerDAO.listEmployeeOnProject(project1);

    }
}
