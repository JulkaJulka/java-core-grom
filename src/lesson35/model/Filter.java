package lesson35.model;

import java.util.Comparator;
import java.util.Date;

/**
 * Created by user on 30.11.2017.
 */
public class Filter implements Comparator<Room> {
    private int numberOfGuests;
    private double price;
    private boolean breakfastIncluded;
    private boolean petsAllowed;
    private Date dateAvailableFrom;
    private String country;
    private String city;

    public Filter(int numberOfGuests, double price, boolean breakfastIncluded, boolean petsAllowed,
                  Date dateAvailableFrom, String country, String city) {
        this.numberOfGuests = numberOfGuests;
        this.price = price;
        this.breakfastIncluded = breakfastIncluded;
        this.petsAllowed = petsAllowed;
        this.dateAvailableFrom = dateAvailableFrom;
        this.country = country;
        this.city = city;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public double getPrice() {
        return price;
    }

    public boolean isBreakfastIncluded() {
        return breakfastIncluded;
    }

    public boolean isPetsAllowed() {
        return petsAllowed;
    }

    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    @Override
    public int compare(Room o1, Room o2) {
        if(o1.getNumberOfGuests() != 0 && o1.getNumberOfGuests() !=0 &&
                o1.getNumberOfGuests() != o2.getNumberOfGuests())
            return Integer.compare(o1.getNumberOfGuests(), o2.getNumberOfGuests());

        if(o1.getPrice() != 0 && o2.getPrice() != 0 &&
                o1.getPrice() != o2.getPrice())
            return Double.compare(o1.getPrice(), o2.getPrice());

        if(  o1.isBreakfastIncluded() != o2.isBreakfastIncluded())
            return Boolean.compare(o1.isBreakfastIncluded(),o2.isBreakfastIncluded());

        if(o1.isPetsAllowed() != o2.isPetsAllowed())
            return Boolean.compare(o1.isPetsAllowed(), o2.isPetsAllowed());

        if(!o1.getDateAvailableFrom().equals(o2.getDateAvailableFrom()) &&
                o1.getDateAvailableFrom() != o2.getDateAvailableFrom())
            return o1.getDateAvailableFrom().compareTo(o2.getDateAvailableFrom());

        if(o1.getHotel().getCountry()!= null && o2.getHotel().getCountry() != null &&
                !o1.getHotel().getCountry().equals(o2.getHotel().getCountry()))
            return o1.getHotel().getCountry().compareTo(o2.getHotel().getCountry());

        if(o1.getHotel().getCity() != null && o2.getHotel().getCity() != null &&
                o1.getHotel().getCity().equals(o2.getHotel().getCity()))
            return o1.getHotel().getCity().compareTo(o2.getHotel().getCity());
        return 0;
    }
}
