package lesson30;

import java.util.ArrayList;

/**
 * Created by user on 28.09.2017.
 */
public class Project {
    private long idProject;
    private String nameProject;
    private Manager manager;
    private ArrayList<Employer> employers;

    public Project(long idProject, String nameProject, Manager manager) {
        this.idProject = idProject;
        this.nameProject = nameProject;
        this.manager = manager;
    }

    public long getIdProject() {
        return idProject;
    }

    public String getNameProject() {
        return nameProject;
    }

    public Manager getManager() {
        return manager;
    }

    public ArrayList<Employer> getEmployers() {
        return employers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (idProject != project.idProject) return false;
        if (!nameProject.equals(project.nameProject)) return false;
        return manager.equals(project.manager);

    }

    @Override
    public int hashCode() {
        int result = (int) (idProject ^ (idProject >>> 32));
        result = 31 * result + nameProject.hashCode();
        result = 31 * result + manager.hashCode();
        return result;
    }
}
