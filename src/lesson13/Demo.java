package lesson13;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        UserRepository userRepository = new UserRepository();
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        User user = new User(1001, "Ann","fgh4253");
        userRepository.save(user);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        userRepository.save(user);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        //сохранение юзера
        //сохранение существующего юзера
        //когда нет места в массиве
        //когда сохраняют null
        int n = 15;
        while(n > 0){
            User user1 = new User(n, "Ann","fgh4253");
            System.out.println(userRepository.save(user1));
            n--;
        }
        System.out.println(Arrays.deepToString(userRepository.getUsers()));
        userRepository.save(null);

        //test update
        user = new User(1001,"Ann","erteret");
        userRepository.update(user);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));
        //обновление юзера
        //когда нет юзера на обновление
        //когда обновление null
        user = new User(3001,"Ann","erteret");
        System.out.println(userRepository.update(user));
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        System.out.println(userRepository.update(null));
        System.out.println(Arrays.deepToString(userRepository.getUsers()));


    }
}
