package vebinar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 08.10.2017.
 */
public class OrderMovieSessionDAO {
    private ArrayList<OrderMovieSession> orderMovieSessions = new ArrayList<>();

    public OrderMovieSession saveOrder(OrderMovieSession orderMovieSession) {

        return null;
    }

   public List<OrderMovieSession> ordersByMovieNameAndAddress(String movieName, String address){
        //TODO
        return new ArrayList<>();
    }

    public OrderMovieSession findByUserAndId(User user, long id) {
        for (OrderMovieSession order : orderMovieSessions) {
            if (order.getId() == id && order.getUser().equals(user)) {
                return order;
            }
        }
        return null;
    }

    public OrderMovieSession update(OrderMovieSession orderMovieSession) {
        int index = 0;
        for (OrderMovieSession order : orderMovieSessions) {
            if (order.getId() == orderMovieSession.getId()) {
                orderMovieSessions.set(index, orderMovieSession);
                return orderMovieSession;
            }
            index++;
        }
        return null;
    }
}


