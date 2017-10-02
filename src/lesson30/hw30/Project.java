package lesson30.hw30;

import java.util.ArrayList;

/**
 * Created by user on 28.09.2017.
 */
public class Project {
    private long idProject;
    private String nameProject;
    private Customer customer;
  //  private Manager manager;
    private ArrayList<Employer> employers;

    public Project(long idProject, String nameProject, Customer customer, ArrayList<Employer> employers) {
        this.idProject = idProject;
        this.nameProject = nameProject;
        this.customer = customer;
        this.employers = employers;
    }

    public long getIdProject() {
        return idProject;
    }

    public String getNameProject() {
        return nameProject;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<Employer> getEmployers() {
        return employers;


    }

    public void setEmployers(ArrayList<Employer> employers) {
        this.employers = employers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        return idProject == project.idProject;

    }

    @Override
    public int hashCode() {
        return (int) (idProject ^ (idProject >>> 32));
    }

    @Override
    public String toString() {
        return "Project{" +
                "idProject=" + idProject +
                '}';
    }
}
