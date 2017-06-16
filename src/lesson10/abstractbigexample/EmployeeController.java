package lesson10.abstractbigexample;

/**
 * Created by user on 08.06.2017.
 */
public class EmployeeController {
    private Employee[] employees = new Employee[100];

    void paySalaryToEmployes(){
        for (Employee employe: employees) {
            employe.paySalary();
            System.out.println("Salary was paid successfully to " + employe.getName() + "employee");
        }
    }
}
