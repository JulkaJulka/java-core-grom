package lesson9.user;

/**
 * Created by user on 26.05.2017.
 */
public class UtilUserRepositary {

    public  void showUsers(HUser[] hUsers) {
        for (int i = 0; i < hUsers.length; i++) {
            System.out.print(hUsers[i] + " ");
        }
        System.out.println();
    }

}
