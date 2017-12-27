package lesson36.repository;

import lesson36.Utils;
import lesson36.model.Entity;
import lesson36.model.Hotel;
import lesson36.model.User;
import lesson36.model.UserType;


import java.io.*;
import java.util.ArrayList;

/**
 * Created by user on 30.11.2017.
 */
public class HotelRepository extends GeneralRepository {
    private final  String pathHotelDB = "D:/Ubuntu_backup/dev/HotelDB.txt";
    private Utils utils = new Utils();


   public Hotel addHotel(Hotel hotel, User user) throws Exception {
       if (user.getUserType() != UserType.ADMIN)
           throw new Exception("Adding of hotel is not accessible to you");
       if (hotel == null)
           throw new Exception("You enter wrong hotel");

       StringBuffer bf = new StringBuffer("");
       super.generateId(hotel);
       bf.append("\r\n");
       bf.append(hotel.toString());

       try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathHotelDB, true))) {
           bufferedWriter.append(bf);
           return hotel;
       } catch (IOException e) {
           throw new IOException("Can't write to hotelDB " + pathHotelDB);
       }
   }
    public void deleteHotel(Hotel hotel, User user) throws Exception {
        if (user.getUserType() != UserType.ADMIN)
            throw new Exception("Deleting of hotel is not accessible to you");
        if (hotel == null)
            throw new Exception("You didn't enter hotel");

        ArrayList<Hotel> hotelArrayListBeforeDel = hotelToArrayList(pathHotelDB);

        if (!hotelArrayListBeforeDel.contains(hotel.getId()))
            throw new Exception("Hotel with id " + hotel.getId() + " does not exist in hotelDB");

        StringBuffer res = new StringBuffer();
        StringBuffer resBkp = new StringBuffer();
        for (Hotel ht : hotelArrayListBeforeDel) {
            resBkp.append(ht.toString());
            resBkp.append("\r\n");

            if (hotel.getId() != ht.getId()) {
                res.append(ht.toString());
                res.append("\r\n");
            }
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathHotelDB, false))) {
            bw.append(res);
        } catch (IOException e) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathHotelDB, false))) {
                bw.append(resBkp);
            }
            throw new IOException("Can't write to file " + pathHotelDB);
        }
    }
    /*public Hotel findHotelById(Long idFind) throws Exception {
        setPathDB(getPathHotelDB());
        Entity entity = super.findEntitylById(idFind);

        if(entity == null)
            throw new Exception("Hotel with id " + idFind + "doesn't exist in HotelDB" );

        ArrayList<Hotel> hotelArrayList = hotelToArrayList(pathHotelDB);
        for (Hotel ht : hotelArrayList) {
            if (ht.getId() == idFind) {
                return ht;
            }
        }
        return null;
    }*/

    public ArrayList<Hotel> findHotelByName(String name) throws Exception {
        checkHotelName(name);
        ArrayList<Hotel> findHotels = new ArrayList<>();
        ArrayList<Hotel> hotelToArrayList = hotelToArrayList(pathHotelDB);
        for (Hotel ht: hotelToArrayList){
            if(ht.getHotelName().equals(name)){
                findHotels.add(ht);
            }
        }
        return findHotels;
    }

    private ArrayList<Hotel> findHotelByCity(String city) throws Exception {
        checkCityOfHotel(city);
        ArrayList<Hotel> hotelFindArrayList = new ArrayList<>();
        ArrayList<Hotel> hotelToArrayList = hotelToArrayList(pathHotelDB);
        for(Hotel ht : hotelToArrayList){
            if(ht.getCity().equals(city)){
                hotelFindArrayList.add(ht);
            }
        }
        return hotelFindArrayList;
    }
    public ArrayList<Hotel> findHotelByCountryAndCity(String country,String city) throws Exception {
        checkCityOfHotel(city);
        checkCountryOfHotel(country);
        ArrayList<Hotel> hotelFindArrayList = new ArrayList<>();
        ArrayList<Hotel> hotelToArrayList = hotelToArrayList(pathHotelDB);
        for(Hotel ht : hotelToArrayList){
            if(ht.getCity().equals(city) && ht.getCountry().equals(country)){
                hotelFindArrayList.add(ht);
            }
        }
        return hotelFindArrayList;
    }
    public ArrayList<Hotel> hotelToArrayList(String path) throws Exception {
        ArrayList<Hotel> hotelToArrayList = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(pathHotelDB))) {
            while ((line = br.readLine()) != null) {
                String[] strs = line.split(",");
                Hotel hotel = createHotel(strs);
                hotelToArrayList.add(hotel);
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + path + " does not exist");
        } catch (IOException e) {
            throw new IOException("Reading from filed " + path + " failed");
        }

        return hotelToArrayList;
    }

    public Hotel createHotel(String[] str) throws Exception {
        if (str.length == 0 || str == null || str.length != 5)
            throw new Exception("Error of reading");
        Hotel hotel = new Hotel();

        hotel.setId(Long.parseLong(str[0]));
        hotel.setHotelName(str[1]);
        hotel.setCountry(str[2]);
        hotel.setCity(str[3]);
        hotel.setStreet(str[4]);

        return hotel;
    }

    private boolean checkHotelName(String name) throws Exception {
        if (name == null || name.isEmpty())
            throw new Exception("Enter name of Hotel");
        if (!utils.checkWordOnLetters(name))
            throw new Exception("Name of hotel " + name + " is wrong. Try again, please");
        return true;
    }

    private boolean checkCityOfHotel(String city) throws Exception {
        if (city == null || city.isEmpty())
            throw new Exception("Enter city of Hotel");
        if (!utils.checkWordOnLetters(city))
            throw new Exception("City " + city + " is wrong. Try again, please");
        return true;
    }
    private boolean checkCountryOfHotel(String country) throws Exception {
        if (country == null || country.isEmpty())
            throw new Exception("Enter city of Hotel");
        if (!utils.checkWordOnLetters(country))
            throw new Exception("Country " + country + " is wrong. Try again, please");
        return true;
    }

}
