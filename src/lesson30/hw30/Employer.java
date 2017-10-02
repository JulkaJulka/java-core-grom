package lesson30.hw30;

import java.util.ArrayList;

/**
 * Created by user on 28.09.2017.
 */
public class Employer {
    private long id;
    private long tabulNumber;
    private String name;
    private String yearOfBirth;
    private Department department;
    private EmployerType employerType;
    private long salary;
    private ArrayList<Project> projects;

    public Employer(long id, long tabulNumber, String name, String yearOfBirth,
                    Department department, EmployerType employerType,
                    long salary, ArrayList<Project> projects) {
        this.id = id;
        this.tabulNumber = tabulNumber;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.department = department;
        this.employerType = employerType;
        this.salary = salary;
        this.projects = projects;
    }

    public long getId() {
        return id;
    }

    public long getTabulNumber() {
        return tabulNumber;
    }

    public String getName() {
        return name;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public Department getDepartment() {
        return department;
    }

    public EmployerType getEmployerType() {
        return employerType;
    }

    public long getSalary() {
        return salary;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }


    @Override
    public String toString() {
        return "Employer{" +
                "id=" + id +
                ", tabulNumber=" + tabulNumber +
                ", name='" + name + '\'' +
                ", yearOfBirth='" + yearOfBirth + '\'' +
                ", department=" + department +
                ", employerType=" + employerType +
                ", salary=" + salary +
                ", projects=" + projects +
                '}';
    }
}
