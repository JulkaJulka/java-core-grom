package lesson30;

import java.util.ArrayList;

/**
 * Created by user on 28.09.2017.
 */
public class ControllerDAO {
    private ArrayList<Project> projects;
    private ArrayList<Employer> employerArrayList;

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public ArrayList<Employer> getEmployerArrayList() {
        return employerArrayList;
    }

    public void setProjects(ArrayList<Project> projects) {
        Manager manager1 = new Manager(1000, 21, "Yuliia", "2016", Department.PROGRAMMER,
                EmployerType.ManagerEmpl, 3000, null);
        Project project1 = new Project(200, "Test1" , manager1);
        Project project2 = new Project(201, "Test2", manager1);
        projects.add(project1);
        projects.add(project2);
        this.projects = projects;
    }

    public void setEmployerArrayList(ArrayList<Employer> employerArrayList) {

        Employer employer1 = new Employer(1000, 21, "Yuliia", "2016", Department.PROGRAMMER,
                EmployerType.NonManagerEmpl, 3000,projects);
        Manager manager1 = new Manager(1000, 21, "Yuliia", "2016", Department.PROGRAMMER,
                EmployerType.ManagerEmpl, 3000, projects);
        employerArrayList.add(employer1);
        employerArrayList.add(manager1);
        this.employerArrayList = employerArrayList;
    }

    public void listEmployeeOnProject(Project projectGiven){
        setEmployerArrayList(employerArrayList);


        if(projectGiven == null)
            System.out.println("0");
        for (Employer empl: getEmployerArrayList()) {
            if(getEmployerArrayList() != null && empl.getProjects().equals(projectGiven)){
                System.out.println(empl);
            }
        }
    }

    @Override
    public String toString() {
        return "ControllerDAO{" +
                "projects=" + projects +
                ", employerArrayList=" + employerArrayList +
                '}';
    }
}
