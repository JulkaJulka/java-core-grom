package lesson18;

/**
 * Created by user on 19.07.2017.
 */
public class Definition {
    private void notifyUsers(String[] userEmails){
        for (String email: userEmails) {

//send email to user - error
            try {
                //send email to user - error
                System.out.println("Email " + email + " was sent");
                //
                //

            }catch (Exception e){

                //how should I handle exception
                System.out.println("Email " + email + " was not sent");
            } finally {
                //update status

            }

            //     }  catch (type2 e1)
            //
            //   {


        }
        //1
        //2
        //3
    }
}
