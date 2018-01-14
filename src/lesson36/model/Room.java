package lesson36.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * Created by user on 30.11.2017.
 */
public class Room extends Entity{
   private long id;
   private int numberOfGuests;
   private double price;
   private boolean breakfastIncluded;
   private boolean petsAllowed;
   private Date dateAvailableFrom;
   private Hotel hotel;

    public Room() {
    }

    public Room(long id, int numberOfGuests, double price, boolean breakfastIncluded, boolean petsAllowed, Date dateAvailableFrom, Hotel hotel) {
        this.id = id;
        this.numberOfGuests = numberOfGuests;
        this.price = price;
        this.breakfastIncluded = breakfastIncluded;
        this.petsAllowed = petsAllowed;
        this.dateAvailableFrom = dateAvailableFrom;
        this.hotel = hotel;
    }

    public long getId() {
        return id;
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

    public Hotel getHotel() {
        return hotel;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBreakfastIncluded(boolean breakfastIncluded) {
        this.breakfastIncluded = breakfastIncluded;
    }

    public void setPetsAllowed(boolean petsAllowed) {
        this.petsAllowed = petsAllowed;
    }

    public void setDateAvailableFrom(Date dateAvailableFrom) {
        this.dateAvailableFrom = dateAvailableFrom;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;

    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String strDateAvailableFrom = df.format(dateAvailableFrom);
        return id +
                "," + numberOfGuests +
                "," + price +
                "," + breakfastIncluded +
                "," + petsAllowed +
                "," + strDateAvailableFrom +
                "," + hotel.getId();
    }

   /* public static Room formRoom(String[] str) throws Exception {
        if (str.length == 0  || str.length != 7 || str == null)
            throw new Exception("Error of reading.Incorrect data");
        Room room = new Room();
        room.setId(Long.parseLong(str[0]));
        room.setNumberOfGuests(Integer.parseInt(str[1]));
        room.setPrice(Double.parseDouble(str[2]));
        room.setBreakfastIncluded(Boolean.parseBoolean(str[3]));
        room.setPetsAllowed(Boolean.parseBoolean(str[4]));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date dateAvailableFrom = simpleDateFormat.parse(str[5]);

        room.setDateAvailableFrom(dateAvailableFrom);

        room.setHotel(Hotel.(Long.parseLong(str[6])));
        super.formEntity(str);
        return room;
    }*/
}
