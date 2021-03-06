package lesson36.model;

import lesson36.repository.GeneralRepository;

/**
 * Created by user on 30.11.2017.
 */
public class Hotel {
private long id;
    private String hotelName;
    private String country;
    private String city;
   private String street;

    public Hotel() {
    }

    public Hotel( String hotelName, String country, String city, String street) {
        this.id = GeneralRepository.generateId();
        this.hotelName = hotelName;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        return id +
                "," + hotelName +
                "," + country +
                "," + city +
                "," + street;
    }


    public static Hotel formHotel(String[] str) throws Exception {
        if (str == null || str.length == 0 || str.length != 5)
                throw new Exception("Error of reading: Incorrect data");
            Hotel hotel = new Hotel();
            hotel.setId(Long.parseLong(str[0]));
            hotel.setHotelName(str[1]);
            hotel.setCountry(str[2]);
            hotel.setCity(str[3]);
            hotel.setStreet(str[4]);

            return hotel;
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
