package lesson30.hw301;

import java.util.ArrayList;

/**
 * Created by user on 02.10.2017.
 */
public class CustomerDAO {
    private ArrayList<Customer> customerArrayList;

    public ArrayList<Customer> getCustomerArrayList() {
        return customerArrayList;
    }

    public void setCustomerArrayList(ArrayList<Customer> customerArrayList) {
        this.customerArrayList = customerArrayList;
    }
}
