package lesson30.hw301;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by user on 02.10.2017.
 */
public class Firm {
    private Date dateFounded;
    private ArrayList<Department>  departments = new ArrayList<Department>();

    public Firm(Date dateFounded, ArrayList<Department> departments) {
        this.dateFounded = dateFounded;
        this.departments = departments;
    }

    public Date getDateFounded() {
        return dateFounded;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }
}
