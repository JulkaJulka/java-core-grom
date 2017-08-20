package lesson25.hw25;



/**
 * Created by user on 20.08.2017.
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        GeneralDAO generalDAO = new GeneralDAO();
        int a = 10;
        int b = 5;
        String str = "FGHH";
        System.out.println(generalDAO.save(a));
        System.out.println(generalDAO.save(str));
        System.out.println(generalDAO.getAll());
    }
}
