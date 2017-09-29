package lesson30;

import java.util.ArrayList;

/**
 * Created by user on 29.09.2017.
 */
public class Test {
    public static void main(String[] args) {
       // Employer employer1 = new Employer(1000, 21, "Yuliia", "2016", Department.PROGRAMMER,
       //         EmployerType.NonManagerEmpl, 3000);
        ArrayList<Project> projectsArrayList = new ArrayList<>();
        ArrayList<Employer> employerArrayList = new ArrayList<>();
        //Manager manager1 = new Manager(1000, 21, "Yuliia", "2016", Department.PROGRAMMER,
        //        EmployerType.ManagerEmpl, 3000, projectsArrayList);

        Project project4 = new Project(200, "Test1" , null);
       // Project project2 = new Project(201, "Test2" , manager1);

     //   employerArrayList.add(employer1);
      //  employerArrayList.add(manager1);



        //System.out.println(projectsArrayList.toString());

        ControllerDAO controllerDAO = new ControllerDAO();
        System.out.println(controllerDAO.toString());
        controllerDAO.listEmployeeOnProject(project4);


        //controllerDAO.listEmployeeOnProject(project1);

    }
}
