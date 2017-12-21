package lesson35.repository;

import lesson24.exercise.GeneralDAO;
import lesson35.Utils;
import lesson35.model.Entity;
import lesson35.model.Hotel;
import lesson35.model.User;
import lesson35.model.UserType;


import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user on 30.11.2017.
 */
public class HotelRepository extends GeneralRepository {
    //private final  String pathHotelDB = "D:/Ubuntu_backup/dev/HotelDB.txt";
    private Utils utils = new Utils();

   /* public String getPathHotelDB() {
        return pathHotelDB;
    }*/

    public Hotel addHotel(Hotel hotel, User user) throws Exception {
        if (user.getUserType() != UserType.ADMIN)
            throw new Exception("Adding of hotel is not accessible to you");
        if (hotel == null)
            throw new Exception("You enter wrong hotel");

        try (BufferedReader br = new BufferedReader(new FileReader(getPathDB()))){
            StringBuffer bf = new StringBuffer("");
            String line;
            //BufferedReader br = new BufferedReader(new FileReader(getPathDB()));

            while ((line = br.readLine()) != null) {
                String[] str = line.split(",");
                if (str[1].equals(hotel.getHotelName()) && str[2].equals(hotel.getCountry()) &&
                        str[3].equals(hotel.getCity()) && str[4].equals(hotel.getStreet())) {
                    return null;
                }
            }
            super.generateId(hotel);
            String strHotel = hotel.toString();
            bf.append("\r\n");
            bf.append(strHotel);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(getPathDB(), true));
                bufferedWriter.append(bf);
        } catch (Exception e) {
            throw new IOException("Can't write to hotelDB " + getPathDB());
        }
        return null;

    }

    public void deleteHotel(Hotel hotel, User user) throws Exception {
        if (user.getUserType() != UserType.ADMIN)
            throw new Exception("Deleting of hotel is not accessible to you");
        if (hotel == null)
            throw new Exception("You didn't enter hotel");
        if(findHotelById(hotel.getId()) == null)
            throw new Exception("ooooooooo");
        Hotel hotelFind = findHotelById(hotel.getId());
        if (hotelFind == null)
            throw new Exception("Hotel with id " + hotel.getId() + "not exist in hotelDB");
        String line = "";
        StringBuffer res = new StringBuffer();
        StringBuffer dataBeforeChanging = new StringBuffer("");
        try (BufferedReader br = new BufferedReader(new FileReader(getPathHotelDB()))) {
            while ((line = br.readLine()) != null) {
                dataBeforeChanging.append(line);
                String[] strings = line.split(",");
                long hotelId = Long.parseLong(strings[0]);
                if (hotelId != hotel.getId()) {
                    res.append(line);
                    res.append("\r\n");
                }
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(getPathHotelDB(),false))){
                    bw.append(res);
                } catch (IOException e) {
                    try( BufferedWriter bw = new BufferedWriter(new FileWriter(getPathHotelDB()))){
                        bw.append(dataBeforeChanging);}
                    throw new IOException("Can't write to file " + getPathHotelDB());
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + getPathHotelDB() + " does not exist");
        } catch (IOException e) {
            throw new IOException("Reading from filed " + getPathHotelDB() + " failed");
        }

    }

    public Hotel findHotelById(Long idFind) throws Exception {
        setPathDB(getPathHotelDB());
        Entity entity = super.findEntitylById(idFind);
if(entity == null)
    throw new Exception("Hotel with id " + idFind + "doesn't exist in HotelDB" );
        Hotel findHotel = (Hotel) entity;
        String line;
        BufferedReader br = new BufferedReader(new FileReader(getPathDB()));
            while ((line = br.readLine()) != null) {
                String[] strings = line.split(",");
                findHotel.setHotelName(strings[1]);
                findHotel.setCountry(strings[2]);
                findHotel.setCity(strings[3]);
                findHotel.setStreet(strings[4]);}
                    return findHotel;
    }

    public ArrayList<Hotel> findHotelByName(String name) throws Exception {
        checkHotelName(name);
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(getPathHotelDB()))) {
            ArrayList<Hotel> hotelArrayList = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                Hotel findHotel = new Hotel();
                String[] strings = line.split(",");
                if (strings[1].equals(name)) {
                    long hotelId = Long.parseLong(strings[0]);
                    findHotel.setId(hotelId);
                    findHotel.setHotelName(strings[1]);
                    findHotel.setCountry(strings[2]);
                    findHotel.setCity(strings[3]);
                    findHotel.setStreet(strings[4]);
                    hotelArrayList.add(findHotel);
                }
            }
            return hotelArrayList;
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + getPathHotelDB() + " does not exist");
        } catch (IOException e) {
            throw new IOException("Reading from filed " + getPathHotelDB() + " failed");
        }
    }

    private ArrayList<Hotel> findHotelByCity(String city) throws Exception {
        checkCityOfHotel(city);
        String line = "";
        ArrayList<Hotel> hotelArrayList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(getPathHotelDB()))) {
            while ((line = br.readLine()) != null) {

                String[] strings = line.split(",");
                if (strings[3].equals(city)) {
                    Hotel findHotel = new Hotel();
                    long hotelId = Long.parseLong(strings[0]);
                    findHotel.setId(hotelId);
                    findHotel.setHotelName(strings[1]);
                    findHotel.setCountry(strings[2]);
                    findHotel.setCity(strings[3]);
                    findHotel.setStreet(strings[4]);
                    hotelArrayList.add(findHotel);
                }
            }
            return hotelArrayList;
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + getPathHotelDB() + " does not exist");
        } catch (IOException e) {
            throw new IOException("Reading from filed " + getPathHotelDB() + " failed");
        }
    }
    public ArrayList<Hotel> findHotelByCountryAndCity(String country,String city) throws Exception {
        checkCityOfHotel(city);
        checkCountryOfHotel(country);
        String line ;
        ArrayList<Hotel> hotelArrayList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(getPathHotelDB()))) {
            while ((line = br.readLine()) != null) {

                String[] strings = line.split(",");
                if (strings[2].equals(country) && strings[3].equals(city) ) {
                    Hotel findHotel = new Hotel();
                    long hotelId = Long.parseLong(strings[0]);
                    findHotel.setId(hotelId);
                    findHotel.setHotelName(strings[1]);
                    findHotel.setCountry(strings[2]);
                    findHotel.setCity(strings[3]);
                    findHotel.setStreet(strings[4]);
                    hotelArrayList.add(findHotel);
                }
            }
            return hotelArrayList;
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + getPathHotelDB() + " does not exist");
        } catch (IOException e) {
            throw new IOException("Reading from filed " + getPathHotelDB() + " failed");
        }
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
