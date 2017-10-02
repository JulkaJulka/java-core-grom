package lesson30.hw30;

import java.util.ArrayList;
import java.util.HashSet;

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
        this.projects = projects;
    }

    public void setEmployerArrayList(ArrayList<Employer> employerArrayList) {
        this.employerArrayList = employerArrayList;
    }

    public void listEmployeeOnProject(Project projectGiven){
        for (Employer empl: getEmployerArrayList()) {
            if(empl.getProjects() != null && empl.getProjects().contains(projectGiven)){
                System.out.println(empl);
            }
        }
    }

    public void listProjetsOfEmployer(Employer employer){
        for (Project pr: getProjects()) {
            if(pr.getEmployers() != null && pr.getEmployers().contains(employer))
            System.out.println(pr);
        }
    }

    public void listUninvolvedEmployersOfDepartment(Department department){

        for(Employer empl : getEmployerArrayList()){
            if(empl.getDepartment() == department && empl.getProjects() == null) {
                System.out.println(empl);
            }
        }
    }

    public void listUninvolvedEmployersOnProjects() {
        for (Employer empl : getEmployerArrayList()) {
            if (empl.getProjects() == null)
                System.out.println(empl);
        }
    }
    public void listProjectsByCustomer(Customer customer){
        for (Project pr: getProjects()){
            if(pr.getCustomer() != null && pr.getCustomer().equals(customer))
                System.out.println(pr);
        }
    }

    public void listEmployeeOfProjectsByCustomer(Customer customer){
        ArrayList<Project> projectArrayListbyCustomer = new ArrayList<>();
        for (Project pr: getProjects()){
            if(pr.getCustomer() != null && pr.getCustomer().equals(customer))
                projectArrayListbyCustomer.add(pr);
        }
        HashSet<Employer> employerHashSet = new HashSet<>();
        for (Project pr : projectArrayListbyCustomer){
            //employerHashSet.add(pr.getEmployers())
            System.out.println(pr.getEmployers());
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
