package lesson35.demo;

import lesson35.model.User;
import lesson35.model.UserType;
import lesson35.repository.UserRepository;
import lesson35.service.UserService;

/**
 * Created by user on 30.11.2017.
 */
public class DemoUser {
    public static void main(String[] args) throws Exception{
       // UserService userService = new UserService();
       // UserRepository userRepository = new UserRepository();
       // System.out.println(userService.readerData("D:/Ubuntu_backup/dev/UserDB.txt"));
       // String[] strs = {"1001","Julia","qwerty","Ukraine","ADMIN"};
        //System.out.println(userRepository.formUser(new String[]{"1001","Julia","qwerty","Ukraine","ADMIN"}));
       // System.out.println(userR);
        UserRepository userRepository = new UserRepository();
        User user1 = new User(1001,"Julia","qwerty", "Ukraine", UserType.ADMIN);
      /*  User user2 = new User(1001,"Test","qwerty", "Ukraine", UserType.ADMIN);
        User user3 = new User(1001,"Test2","qwerty", "Ukraine", UserType.USER);
        User user4 = new User(1001,"Test3","qwerty", "Ukraine", UserType.USER);
        User user5 = new User(234252452,"Test4","qwerty", "Ukraine", UserType.USER);*/
        User user6 = new User(1001,"Katy1","qwerty", "Ukra ine", UserType.ADMIN);
       // System.out.println(userRepository.findUserByUserName(user2));
        System.out.println(userRepository.registerUser(user6));
       // System.out.println(userRepository.checkPresenceIdUser(user6));
    }
}
