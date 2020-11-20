package lesson9_additional.user;

import java.util.Arrays;
import java.util.logging.Logger;

public class UserRepository {
    private User[] users;

    public User[] getUsers() {
        return users;
    }

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User getFindByID(long id) {
        return findById(id);
    }

    public String[] getUserNames() {
        String[] names = new String[this.users.length];
        int index = 0;
        while (index < 10) {
            for (User u : this.users) {

                for (String n : names) {
                    if (u == null) {
                        names[index] = null;
                        break;
                    } else {
                        names[index] = u.getName();
                        break;
                    }
                }
                index++;
            }
        }
        return names;
    }

    public long[] getUserIds() {
        long[] ids= new long[this.users.length];
        int index = 0;
        while (index < 10) {
            for (User u : this.users) {

                for (long n : ids) {
                    if (u == null) {
                        ids[index] = 0;
                        break;
                    } else {
                        ids[index] = u.getId();
                        break;
                    }
                }
                index++;
            }
        }
        return ids;
    }

    private User findById(long id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getId() == id) {
                return users[i];
            }
        }
        return null;
    }

    public  String getUserNameById(long id){
        User user = findById(id);
        return user == null ?  null : user.getName();
    }

    public User save(User user) {
        int countNull = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                countNull = countNull + 1;
            }
        }
        if (countNull == 0)
            return null;

        if (user == null)
            return null;

        User userSave = findById(user.getId());
        if (userSave != null)
            return null;

        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                break;
            }
        }
        return user;

    }

    public User update(User user) {
        if (user == null)
            return null;

        if (findById(user.getId()) == null)
            return null;

        User userFound = findById(user.getId());
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getId() == userFound.getId()) {
                users[i] = user;
                break;
            }

        }
        return user;
    }

    public void delete(long id) {

        User user = findById(id);
        if (user == null)
            return; //What does it mean;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId() == user.getId()) {
                users[i] = null;
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "users=" + Arrays.toString(users) +
                '}';
    }
}
