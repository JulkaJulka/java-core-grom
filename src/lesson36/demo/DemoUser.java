package lesson36.demo;

import lesson36.controller.UserController;
import lesson36.model.User;
import lesson36.model.UserType;
import lesson36.repository.UserRepository;
import lesson36.service.UserService;

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
        User user1 = new User("Julia","qwerty", "Ukraine", UserType.ADMIN);
      /*  User user2 = new User(1001,"Test","qwerty", "Ukraine", UserType.ADMIN);
        User user3 = new User(1001,"Test2","qwerty", "Ukraine", UserType.USER);
        User user4 = new User(1001,"Test3","qwerty", "Ukraine", UserType.USER);
        User user5 = new User(234252452,"Test4","qwerty", "Ukraine", UserType.USER);*/
        User user6 = new User("Krut&&o","qwerty", "Ukraine", UserType.ADMIN);
        User user7 = new User("SuperJulka","qwerty", "Ukraine", UserType.USER);
        UserService userService = new UserService();
        userService.registerUser(user1);
       // System.out.println(userRepository.findUserByUserName(user1));
     // System.out.println(userRepository.addEntity(user6));
       // userRepository.deleteEntity(1380109899602796529l);
       // System.out.println(userRepository.checkPresenceIdUser(user6));
       // System.out.println(userRepository.findUserlById(1001l));
    // System.out.println( userRepository.entityToArrayList());
       // System.out.println(userRepository.findUserById(1001l));
       // GeneralRepository<User> generalRepository = new GeneralRepository<>();
        String[] str =  {"2222","Bob1","qwerty", "Ukraine", "ADMIN"};
       // UserController userController = new UserController();
       // System.out.println(userController.registerUser(user7));
       // String[] str1 =  {null,null,null,null,null};
    //    System.out.println(userRepository.formEntity(str));
     // System.out.println(userRepository.addEntity(user7));
       // System.out.println(userRepository.findUserByUserName(user1));
     //  userRepository.addEntity(user7);
      // System.out.println(generalRepository.addEntity(user6));
       // System.out.println(userRepository.entityToArrayList());
       // userRepository.deleteEntity(6576656697215478650l,user6);
     /*   System.out.println(userRepository.entityToArrayList());
        UserService userService = new UserService();
        System.out.println(userService.registerUser(user6));*/
       // System.out.println( userRepository.entityToArrayList());
      //  System.out.println(userRepository.entityToArrayList());
    }
}
