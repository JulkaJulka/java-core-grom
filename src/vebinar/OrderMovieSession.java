package vebinar;

/**
 * Created by user on 08.10.2017.
 */
public class OrderMovieSession {
    private long id;
    private MovieSession movieSession;
    private User user;
    private boolean isActive;

    public OrderMovieSession(long id, MovieSession movieSession, User user) {
        this.id = id;
        this.movieSession = movieSession;
        this.user = user;
        this.isActive = true;
    }
    public MovieSession getMovieSession() {
        return movieSession;
    }

    public User getUser() {
        return user;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
