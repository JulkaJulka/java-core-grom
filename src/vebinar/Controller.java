package vebinar;

/**
 * Created by user on 08.10.2017.
 */
public class Controller {

    private static MovieSessionDAO movieSessionDAO = new MovieSessionDAO();
    private OrderMovieSessionDAO orderMovieSessionDAO = new OrderMovieSessionDAO();

   public void orderTicket(User user, String movieName, String address, int ticketsCount) throws Exception{
       //find movieSession
       //check free tickets
       //order
      // MovieSession movieSession = movieSessionDAO.findByMovieNameAndAddress(movieName, address);
MovieSession movieSession = movieSessionDAO.findByMovieNameAndAddress(movieName, address);
       //TODO
       if(movieName == null)
           throw new Exception("");
       if(movieSessionDAO.findFreeTicketsByMovieNameAndAddress(movieName, address) >= ticketsCount ){
           OrderMovieSession orderMovieSession = new OrderMovieSession(movieSession, user);
           orderMovieSessionDAO.createOrder(orderMovieSession);

           //return status succssesful
       }
   }
}
