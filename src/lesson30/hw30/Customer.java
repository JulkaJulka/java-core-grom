package lesson30.hw30;

import java.util.ArrayList;

/**
 * Created by user on 28.09.2017.
 */
public class Customer {
    private long idCustomer;
    private String nameCustomer;
    private ArrayList<Project> projectsOfCustomer;

    public Customer(long customerId, String nameCustomer, ArrayList<Project> projectsOfCustomer) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.projectsOfCustomer = projectsOfCustomer;
    }

    public long getIdCustomer() {
        return idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public ArrayList<Project> getProjectsOfCustomer() {
        return projectsOfCustomer;
    }
}
