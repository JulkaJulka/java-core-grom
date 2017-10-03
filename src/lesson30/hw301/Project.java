package lesson30.hw301;

/**
 * Created by user on 02.10.2017.
 */
public class Project {
    private String name;
    private Customer customer;

    public Project(String name, Customer customer) {
        this.name = name;
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", customer=" + customer +
                '}';
    }
}
