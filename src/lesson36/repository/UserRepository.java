package lesson36.repository;

import lesson202.Exception.BadRequestException;
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
private String pathUserDB = "D:/Ubuntu_backup/dev/UserDB.txt";

    private Utils utils = new Utils();

    @Override
    public Entity addEntity(Entity entity) throws Exception {
        setPathDB(pathUserDB);
        User user = (User) entity;
        if (!(findUserByUserName(user) == null)) {
            throw new Exception("User with userName " + user.getUserName() +
                    " has registered already. Try another userName");
        }
        return super.addEntity(entity);
    }

    public User findUserByUserName(User user) throws Exception {
       setPathDB(pathUserDB);
        ArrayList<Entity> userArrayList = entityToArrayList();
        for (Entity ent : userArrayList) {
            User po = (User) ent;
            if (po.getUserName().equals(user.getUserName())) {
                return user;
            }
        }
        return null;
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

    @Override
    public Entity findEntityById(Long idFind) throws Exception {
        setPathDB(pathUserDB);
        return super.findEntityById(idFind);
    }

    @Override
    public ArrayList<Entity> entityToArrayList() throws Exception {
        setPathDB(pathUserDB);
        return super.entityToArrayList();
    }

    @Override
    public Entity formEntity(String[] str) throws Exception {
        if ( str.length != 5)
            throw new Exception("Error of reading: Incorrect data");
        setPathDB("D:/Ubuntu_backup/dev/UserDB.txt");
        User user = new User();
        user.setId(super.formEntity(str).getId());
        user.setUserName(str[1]);
        user.setPassword(str[2]);
        user.setCountry(str[3]);
        if (str[4].equals("USER")) {
            user.setUserType(UserType.USER);
        } else if(str[4].equals("ADMIN")){
            user.setUserType(UserType.ADMIN);
        } else{
            throw new BadRequestException("Error of reading: Incorrect data");
        }
        super.formEntity(str);

        return user;
    }

    @Override
    public boolean checkPresenceId(long id) throws Exception {
        setPathDB(pathUserDB);
        return super.checkPresenceId(id);
    }
}
