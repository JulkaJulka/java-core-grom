package lesson30.hw301;

import java.util.ArrayList;

/**
 * Created by user on 02.10.2017.
 */
public class ProjectDAO {
    private ArrayList<Project> projectArrayList;

    public ArrayList<Project> getProjectArrayList() {
        return projectArrayList;
    }

    public void setProjectArrayList(ArrayList<Project> projectArrayList) {
        this.projectArrayList = projectArrayList;
    }

    @Override
    public String toString() {
        return "ProjectDAO{" +
                "projectArrayList=" + projectArrayList +
                '}';
    }
}
