package vebinar;

import java.util.ArrayList;

/**
 * Created by user on 08.10.2017.
 */
public class MovieSessionDAO {
    private static ArrayList<MovieSession> movieSessions = new ArrayList<MovieSession>();

   public void findByMovieNameAndAddress(String movieName, String address){
        for(MovieSession movieSession: movieSessions){
           // if(movieSession.getAddress().equals(address) && movieSession.getMovieName(movieName)){}
        }
    }

    //TODO add cinemas
}
