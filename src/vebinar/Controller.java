package vebinar;

import lesson36.model.UserType;

import java.util.Date;
import java.util.Random;

/**
 * Created by user on 08.10.2017.
 */
public class Controller {

    private static MovieSessionDAO movieSessionDAO = new MovieSessionDAO();
    private OrderMovieSessionDAO orderMovieSessionDAO = new OrderMovieSessionDAO();

    public void orderTicket(User user, String movieName, String address, int ticketsCount) throws Exception {
        //find movieSession
        //check free tickets
        //order
        MovieSession movieSession = movieSessionDAO.findByMovieNameAndAddress(movieName, address);
        if (movieName == null)
            throw new Exception("Movie session with name " + movieName + " not found");
        if (movieSession.getTicketsCount() - movieSession.getTicketsOrder() >= ticketsCount) {
            Random random = new Random();
            int n = ticketsCount;
            while (n > 0) {
                OrderMovieSession orderMovieSession = new OrderMovieSession(random.nextLong(), movieSession, user);
                orderMovieSessionDAO.saveOrder(orderMovieSession);
                n--;
            }
            movieSession.setTicketsOrder(movieSession.getTicketsOrder() + ticketsCount);
            movieSessionDAO.update(movieSession);
            return;

        }
        throw new Exception("There are no " + ticketsCount + " places");

    }

    public void cancelMovieSessionTicket(User user, long id) throws Exception{
        OrderMovieSession orderMovieSession = orderMovieSessionDAO.findByUserAndId(user, id);
        if (orderMovieSession != null) {
            MovieSession movieSession = orderMovieSession.getMovieSession();
            //movie session date - now < 24 h
            //joda time
            long diff = (movieSession.getDate().getTime() - new Date().getTime()) / (1000 * 60 * 60);
            if (diff < 24)
                throw new Exception("You can't cancel ticket in less than 24h");
            orderMovieSession.setActive(false);
            orderMovieSessionDAO.update(orderMovieSession);
        }
    }

        public void saveMovieSession(User user, MovieSession movieSession) throws Exception {
            if(!user.getUserType().equals(UserType.ADMIN))
                throw new Exception("User " + user + " is not authorized to perform this operation");

            movieSessionDAO.save(movieSession);
        }
}
