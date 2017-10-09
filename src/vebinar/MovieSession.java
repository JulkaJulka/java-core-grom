package vebinar;

import java.util.Date;

/**
 * Created by user on 08.10.2017.
 */
public class MovieSession {
    private long id;
    private int ticketsCount;
    private Date date;
    private int price;
    private String address;
    private String movieName;

    public MovieSession(long id, int ticketsCount, Date date, int price, String address) {
        this.id = id;
        this.ticketsCount = ticketsCount;
        this.date = date;
        this.price = price;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public int getTicketsCount() {
        return ticketsCount;
    }

    public Date getDate() {
        return date;
    }

    public int getPrice() {
        return price;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieSession that = (MovieSession) o;

        if (id != that.id) return false;
        if (ticketsCount != that.ticketsCount) return false;
        if (price != that.price) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        return movieName != null ? movieName.equals(that.movieName) : that.movieName == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + ticketsCount;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (movieName != null ? movieName.hashCode() : 0);
        return result;
    }
}
