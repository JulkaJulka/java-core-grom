package lesson25.hw25;


import java.util.Arrays;

/**
 * Created by user on 20.08.2017.
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        GeneralDAO generalDAO = new GeneralDAO();
        int a = 10;
        int b = 5;
        String str = "FGHH";
        long c1 = 678;
        long c2 = 10;
        long c3 = 100;
        long c4 = 638;
        long c5 = 618;
        long c6 = 178;
        long c7 = 278;
        long c8 = 378;
        String[] mas = {null};
        System.out.println(generalDAO.save(a));
        System.out.println(generalDAO.save(str));
        System.out.println(generalDAO.save(mas));
        System.out.println(Arrays.deepToString(generalDAO.getAll()));

        System.out.println("---Test 5--- save the same object");
        try{
            System.out.println(generalDAO.save(a));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("---Test 6---full DB");
        System.out.println(generalDAO.save(c1));
        System.out.println(generalDAO.save(c2));
        System.out.println(generalDAO.save(c3));
        System.out.println(generalDAO.save(c4));
        System.out.println(generalDAO.save(c5));
        System.out.println(generalDAO.save(c6));
        System.out.println(generalDAO.save(c7));
        System.out.println(Arrays.deepToString(generalDAO.getAll()));
        try{
            System.out.println(generalDAO.save(c8));
        } catch (Exception e ){
            System.out.println(e.getMessage());
        }

    }
}
