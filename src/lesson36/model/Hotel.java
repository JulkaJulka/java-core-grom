package lesson36.model;

/**
 * Created by user on 30.11.2017.
 */
public class Hotel extends Entity {

    private String hotelName;
    private String country;
    private String city;
   private String street;

    public Hotel() {
    }

    public Hotel(long id) {
        super(id);
    }

    public Hotel(long id, String hotelName, String country, String city, String street) {
        super(id);
        this.hotelName = hotelName;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return super.toString()+
                "," + hotelName +
                "," + country +
                "," + city +
                "," + street;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hotel hotel = (Hotel) o;

        if (!hotelName.equals(hotel.hotelName)) return false;
        if (!country.equals(hotel.country)) return false;
        if (!city.equals(hotel.city)) return false;
        return street.equals(hotel.street);

    }

    @Override
    public int hashCode() {
        int result = hotelName.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + street.hashCode();
        return result;
    }
}
