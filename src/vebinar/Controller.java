package vebinar;

/**
 * Created by user on 08.10.2017.
 */
public class Controller {

    private static MovieSessionDAO movieSessionDAO = new MovieSessionDAO();

   public void orderTicket(User user, String movieName, String address, int ticketsCount) throws Exception{
       //find movieSession
       //check free tickets
       //order
      // MovieSession movieSession = movieSessionDAO.findByMovieNameAndAddress(movieName, address);

       //TODO
       if(movieName == null)
           throw new Exception("");
   }
}
