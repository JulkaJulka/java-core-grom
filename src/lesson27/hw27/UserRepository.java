package lesson27.hw27;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class UserRepository {
    private User[] users = new User[10];
    private ArrayList<User> userArrayList = new ArrayList<>();

    public ArrayList<User> getUsers() {
        return userArrayList;
    }

   public User getFindById(long id){
      return findById(id);
    }

 public User findById(long id) {
     int index = 0;

     for (User user: userArrayList) {
         if(user.getId() == id){
             return user;
         }
         index++;
     }

       /* for (int i = 0; i < userArrayList.size(); i++) {
            if (userArrayList.get(i).getId() == id) {
                return userArrayList.get(i);
            }
        }*/
        return null;
    }

    public User save(User user) {

        if (user == null)
            return null;

        User userSave = findById(user.getId());
        if(userSave != null){
            return null;
        } else{
        userArrayList.add(user);
            return user;
        }

    }

   public User update(User user) {
        if(user == null)
            return null;

        if(findById(user.getId()) == null)
            return null;

        User userFound = findById(user.getId());
       int indexFoundUser = userArrayList.indexOf(userFound);
       userArrayList.set(indexFoundUser, user);
       return user;
    }

    public void delete(User user) {

        User removeUser = findById(user.getId());
        if(user == null)
            return; //What does it mean;
        userArrayList.remove(removeUser);
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "userArrayList=" + userArrayList +
                '}';
    }
}
