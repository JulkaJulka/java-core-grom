package lesson9.user;

/**
 * Created by user on 26.05.2017.
 */
public class Test {
    public static void main(String[] args) {
        User user1 = new User(3, "Julia", "4567");
        User user2 = new User(5, "Nika","875");




        User user3 = new User(6, "Miha", "725");
        User[] ar = {user1, user2, user3, null, null, null, null, null, null,null};
        User[] ar1 = {null, user2, user3, null, null, null, null, null, null, null};
        UserRepository users = new UserRepository();

        User user4 = new User(5, "Oleg", "789");

//users.update(user4);
//users.delete(5);
       // users.save(user1);
       // users.save(user4);
        //System.out.println(ar[0]);
    //users.delete(3);
     //  System.out.println(ar[0]);//users.findById(3);
     //System.out.println(users.findById(3));
        //System.out.println(users);
    }
}
