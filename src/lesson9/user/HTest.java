package lesson9.user;

/**
 * Created by user on 26.05.2017.
 */
public class HTest {
    public static void main(String[] args) {
        HUser huser1 = new HUser(3, "Julia", "4567");
        HUser huser2 = new HUser(5, "Nika", "875");

        HUser huser6 = new HUser(3, "Julia", "4567");
        HUser huser7 = new HUser(5, "Nika", "875");
        HUser huser8 = new HUser(3, "Julia", "4567");
        HUser huser9 = new HUser(5, "Nika", "875");
        HUser huser10 = new HUser(5, "Nika", "875");
        HUser huser11 = new HUser(5, "Nika", "875");

        HUser huser3 = new HUser(6, "Miha", "725");
        //HUser[] ar = {huser1, huser2, huser3, null, null, null, null, null, null,null};
        HUser[] ar = {huser1, huser2, huser3, huser6, huser7, huser8, huser9, huser10, huser11,null};
        HUser[] ar1 = {null, huser2, huser3, null, null, null, null, null, null, null};
        HUserRepositary husers = new HUserRepositary(ar);

        HUser user4 = new HUser(5, "Oleg", "789");
        HUser user5 = new HUser(7, "Oleg", "789");
        HUser user20 = new HUser(7, "Oleg","456");
        HUser user21 = new HUser(31, "Oleg","456");

        HUser user100 = new HUser(6, "Tanya", "600");


        //husers.delete(3);
        husers.showUsers(ar);
        //husers.save(user4);
       // System.out.println("Save user:");
       // husers.delete(3);
       // husers.showUsers(ar);
      System.out.println(husers.save(user5));
        husers.showUsers(ar);
        //System.out.println(husers.save(user100));

       // husers.showUsers(ar);
       // husers.save(user5);
      //  System.out.println("Save user:");
      // System.out.println(husers.save(user5));
      //  husers.showUsers(ar);

       // System.out.println(husers.save(user5));
     //   System.out.println("----");
      // System.out.println(husers.findById(5));
       // husers.delete(3);
      // husers.showUsers(ar);


      // System.out.println("Update user:");
      // System.out.println(husers.update(user100));
      //  husers.showUsers(ar);
         //husers.delete(40);
      // husers.showUsers(ar);
       // husers.showUsers(ar);

    }
}
