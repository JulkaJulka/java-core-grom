package lesson15.hw15.userRepository;

/**
 * Created by user on 25.05.2017.
 */
public class UserRepository {
    private User[] users = new User[10];
    public User[] getUsers() {
        return users;
    }

    public User getFindByID(long id){
        return findById(id);
    }

 private User findById(long id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getId() == id) {
                return users[i];
            }
        }
        return null;
    }

    public User save(User user) {
        int countNull = 0;
        for (int i = 0; i <users.length ; i++) {
            if(users[i].equals(null)){
                countNull = countNull + 1;
            }
        }
        if(countNull == 0)
            return null;

        if (user.equals(null))
            return null;

        User userSave = findById(user.getId());
        if(!userSave.equals(null))
            return null;

        for (int i = 0; i <users.length ; i++) {
            if(users[i].equals(null)){
                users[i] = user;
                break;
            }
        }return user;

    }

    public User update(User user) {
        if(user == null)
            return null;

        if(findById(user.getId()) == null)
            return null;

        User userFound = findById(user.getId());
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].equals(userFound)&& users[i].hashCode() == userFound.hashCode()) {
                users[i] = user;
                break;
            }

        }return user;
    }

    public void delete(long id) {

        User user = findById(id);
        if(user == null)
            return; //What does it mean;
        for (int i = 0; i < users.length; i++) {
            if(users[i].equals(user) && users[i].hashCode() == user.hashCode()){
                users[i] = null;
                break;
            }
        }
    }

}
