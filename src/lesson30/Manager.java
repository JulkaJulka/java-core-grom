package lesson30;

import java.util.ArrayList;

/**
 * Created by user on 28.09.2017.
 */
public class Manager extends Employer{
    private ArrayList<Project> projects;

    public Manager(long id, long tabulNumber, String name, String yearOfBirth, Department department,
                   EmployerType employerType, long salary, ArrayList<Project> projects) {
        super(id, tabulNumber, name, yearOfBirth, department, employerType, salary, projects);
    }
}
