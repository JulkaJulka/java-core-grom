package lesson22.repository;

import java.util.Arrays;

/**
 * Created by user on 17.08.2017.
 */
public class Demo {
    public static void main(String[] args) {
     //   UserRepository userRepository = new UserRepository();
User user1 = new User(1001, "Daniil", "32434234sdsfuuuuo" );
        UserRepository.save(user1);
        System.out.println(Arrays.deepToString(UserRepository.getUsers()));

        User user2 = new User(1002, "Andrey", "ewrewrwer4343wef" );
        UserRepository.save(user2);

        System.out.println(Arrays.deepToString(UserRepository.getUsers()));

        User user3 = new User(1001, "Test", "32434234sdsfuuuuo" );
        UserRepository.update(user3);

        System.out.println(Arrays.deepToString(UserRepository.getUsers()));

        System.out.println(Arrays.deepToString(UserRepository.getUsers()));

    }
}
