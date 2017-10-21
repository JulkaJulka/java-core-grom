package vebinar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 08.10.2017.
 */
public class MovieSessionDAO {
    private static ArrayList<MovieSession> movieSessions = new ArrayList<MovieSession>();
    private OrderMovieSessionDAO orderMovieSessionDAO;

   public MovieSession findByMovieNameAndAddress(String movieName, String address) {
       for (MovieSession movieSession : movieSessions) {
           if (movieSession.getAddress().equals(address) && movieSession.getMovieName().equals(movieName))
               return movieSession;
       }
       return null;
   }

   public int findFreeTicketsByMovieNameAndAddress(String movieName, String address){
       List<OrderMovieSession> ordersByMovieNameAndAddress =
               orderMovieSessionDAO.ordersByMovieNameAndAddress(movieName,address);
       MovieSession movieSession = findByMovieNameAndAddress(movieName,address);
       return movieSession.getTicketsCount() - ordersByMovieNameAndAddress.size();
   }

    //TODO add cinemas
}
