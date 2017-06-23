package lesson9.user;

/**
 * Created by user on 26.05.2017.
 */
public class HUserRepositary {
    public HUser[] husers = new HUser[10];

    public HUserRepositary() {

    }
     public HUserRepositary(HUser[] husers) {
        this.husers = husers;
    }

    //must private
    public HUser findById(long id) {
        for (int i = 0; i < husers.length; i++) {
            if (husers[i] != null && husers[i].getId() == id) {
                return husers[i];
            }
        }
        return null;
    }

    public void showUsers(HUser[] husers) {
        for (int i = 0; i < husers.length; i++) {

            System.out.print(husers[i] + " ");
        }
        System.out.println();
    }

    public HUser save(HUser huser) {

        int countNull = 0;
        for (int i = 0; i <husers.length ; i++) {
            if(husers[i] == null){
                countNull = countNull + 1;
            }
        }
        if(countNull == 0)
            return null;

        if (huser == null)
            return null;

        HUser huserSave = findById(huser.getId());
        if(huserSave != null)
            return null;

        for (int i = 0; i <husers.length ; i++) {
            if(husers[i] == null){
                husers[i] = huser;
                break;
            }
        }return huser;

        /*for (int i = 0; i < 10; i++) {
            if(users[i] != user && users[i] != null){
                users[i] = user;
            return  user;
            } else if(users.length >= 10){
                return null;
            }
        }
        return null;*/
//was poluright
        /*for (int i = 0; i < husers.length; i++) {
            if (husers[i] == null) {
                husers[i] = huser;
                return huser;
            }
            if (husers[i] != null && husers[i].getId() == huser.getId()) {
                return null;
            }

            if (husers[husers.length - 1] != null) {
                return null;
            }
        }
        return null;*/

     /* HUser hUserSave = findById(huser.getId());
        if(hUserSave == null){
            return huser;
        } else if(hUserSave != null){
            return null;
        }
        for (int i = 0; i < husers.length; i++) {
            if (husers[husers.length - 1] != null) {
                return null;
            }
        }
       return huser;*/

    }

    public HUser update(HUser huser) {
       /*for (int i = 0; i < husers.length ; i++) {
            if(this.husers[i] != null)
            this.husers[i] = huser;
            return huser;
        }
        return null;*/


      // always null
      /* for (int i = 0; i < husers.length; i++) {
            if (husers[i] == null || husers[i].getId() != huser.getId()) {

                return null;
            }
        }
        return huser;*/
        //right
       /*for (int i = 0; i < husers.length; i++) {
            if (husers[i] != null && husers[i].getId() == huser.getId()) {
                husers[i] = huser;
                return huser;
            }
        }
        return null;*/

       //find

        if(huser == null)
           return null;

        if(findById(huser.getId()) == null)
            return null;

        HUser hUserFound = findById(huser.getId());
        for (int i = 0; i < husers.length; i++) {
        if (husers[i] != null && husers[i].getId()== hUserFound.getId()) {
            husers[i] = huser;
            break;
        }

        }return huser;
       /* if(huser == null)
            return null;
        HUser curUser = findById(huser.getId());
        if(findById(huser.getId()) == null )
            return null;

        long curUserId = curUser.getId();
        int i = 0;
        for (HUser el : husers){
            if(el != null && el.getId() == curUser.getId())
                husers[i] = huser;
            break;
        }
        i++;
        return huser;*/

    }

    public void delete(long id) {
       HUser huser = findById(id);
        if(huser == null)
            return; //What does it mean;
        for (int i = 0; i < husers.length; i++) {
            if(husers[i].getId() == huser.getId()){
                husers[i] = null;
                break;
            }
        }
    }

}
