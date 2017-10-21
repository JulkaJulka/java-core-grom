package vebinar;

/**
 * Created by user on 19.10.2017.
 */
public class OrderDAO {
    private MovieSession movieSession;
    private User user;

    public OrderDAO(MovieSession movieSession, User user) {
        this.movieSession = movieSession;
        this.user = user;
    }

    public MovieSession getMovieSession() {
        return movieSession;
    }

    public User getUser() {
        return user;
    }
}
