package lesson27.hw27;

/**
 * Created by user on 18.09.2017.
 */
public class Test {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        User user1 = new User(3, "Julia", "4567");
        User user2 = new User(3, "Nika","875");
        User user3 = new User(6, "Miha", "725");
        User user4 = new User(6, "Kolya", "1000");
        System.out.println(userRepository.save(user1));
        System.out.println(userRepository.save(user2));
        System.out.println(userRepository.save(user3));

        System.out.println(userRepository.getUsers().indexOf(user1));
        System.out.println(userRepository.getUsers().indexOf(user3));
        System.out.println(userRepository.getUsers().indexOf(user2));
        System.out.println("---");
        System.out.println( userRepository.findById(10));
        System.out.println(userRepository.toString());
        System.out.println(userRepository.update(user4));
        System.out.println(userRepository.toString());
        userRepository.delete(user1);
        System.out.println(userRepository.toString());

    }
}
