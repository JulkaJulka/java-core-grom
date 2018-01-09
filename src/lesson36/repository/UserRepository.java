package lesson36.repository;

import lesson36.exception.BadRequestException;
import lesson36.Utils;
import lesson36.model.Entity;
import lesson36.model.User;
import lesson36.model.UserType;

import java.util.ArrayList;

/**
 * Created by user on 30.11.2017.
 */
public class UserRepository extends GeneralRepository {
//UserService userService = new UserService();

    //считывание данных - считывание файлов
    //обработка данных - маппинг данных

    private Utils utils = new Utils();
    static {
        setPathDB("D:/Ubuntu_backup/dev/UserDB.txt");
    }

    @Override
    public Entity addEntity(Entity entity) throws Exception {
        User user = (User) entity;
        validateInputData(user);
        if (!(findUserByUserName(user) == null)) {
            throw new Exception("User with userName " + user.getUserName() +
                    " has registered already. Try another userName");
        }
        return super.addEntity(user);
    }

    public User findUserByUserName(User user) throws Exception {
        ArrayList<Entity> userArrayList = entityToArrayList();
        for (Entity ent : userArrayList) {
            User po = (User) ent;
            if (po.getUserName().equals(user.getUserName())) {
                return user;
            }
        }
        return null;
    }

    @Override
    public   User formEntity(String[] str) throws Exception {
        if (str.length != 5 || str.length == 0 || str == null)
            throw new Exception("Error of reading: Incorrect data");
        User user = new User();
        user.setId(Long.parseLong(str[0]));
        user.setUserName(str[1]);
        user.setPassword(str[2]);
        user.setCountry(str[3]);
        if (str[4].equals("USER")) {
            user.setUserType(UserType.USER);
        } else if (str[4].equals("ADMIN")) {
            user.setUserType(UserType.ADMIN);
        } else {
            throw new BadRequestException("Error of reading: Incorrect data");
        }

        return user;

    }

    private boolean validateInputData(User user) throws Exception {
        if (user == null || user.getUserName().isEmpty() || user.getPassword().isEmpty() ||
                user.getCountry().isEmpty()) {
            throw new Exception("You input wrong data. Try again, please");
        }
        if (!(utils.checkWordOnLetAndDigts(user.getUserName())))
            throw new Exception("UserName " + user.getUserName() + " is wrong");
        if (!(utils.checkWordOnLetAndDigts(user.getPassword())))
            throw new Exception("Password must have only letters and digits");
        if (!(utils.checkWordOnLetters(user.getCountry()))) {
            throw new Exception("Country " + user.getCountry() + " must have only letters");
        }
        return true;
    }

}
