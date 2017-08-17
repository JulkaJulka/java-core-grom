package lesson22.repository;

/**
 * Created by user on 17.08.2017.
 */
public class UserRepository {
    private static User[] users = new User[10];

    public static  User[] getUsers() {
        return users;
    }

    public static User getFindByID(long id){
        return findById(id);
    }

    private static User findById(long id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getId() == id) {
                return users[i];
            }
        }
        return null;
    }

    public static User save(User user) {
        int countNull = 0;
        for (int i = 0; i <users.length ; i++) {
            if(users[i] == null){
                countNull = countNull + 1;
            }
        }
        if(countNull == 0)
            return null;

        if (user == null)
            return null;

        User userSave = findById(user.getId());
        if(userSave != null)
            return null;

        for (int i = 0; i <users.length ; i++) {
            if(users[i] == null){
                users[i] = user;
                break;
            }
        }return user;

    }

    public static User update(User user) {
        if(user == null)
            return null;

        if(findById(user.getId()) == null)
            return null;

        User userFound = findById(user.getId());
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getId()== userFound.getId()) {
                users[i] = user;
                break;
            }

        }return user;
    }

    public static void delete(long id) {

        User user = findById(id);
        if(user == null)
            return; //What does it mean;
        for (int i = 0; i < users.length; i++) {
            if(users[i].getId() == user.getId()){
                users[i] = null;
                break;
            }
        }
    }

}
