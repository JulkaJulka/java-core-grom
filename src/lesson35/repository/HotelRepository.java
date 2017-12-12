package lesson35.repository;

import lesson35.Utils;
import lesson35.model.Hotel;
import lesson35.model.User;
import lesson35.model.UserType;


import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user on 30.11.2017.
 */
public class HotelRepository {
    private final  String pathHotelDB = "D:/Ubuntu_backup/dev/HotelDB.txt";
    private Utils utils = new Utils();

    public Hotel addHotel(Hotel hotel, User user) throws Exception {
        if (user.getUserType() != UserType.ADMIN)
            throw new Exception("Adding of hotel is not accessible to you");
        if (hotel == null)
            throw new Exception("You enter wrong hotel");

        try {
            StringBuffer bf = new StringBuffer("");
            StringBuffer bfBkp = new StringBuffer("");
            String lineBkp = new String("");
            BufferedReader brBkp = new BufferedReader(new FileReader(pathHotelDB));
            while ((lineBkp = brBkp.readLine()) != null) {
                bfBkp.append(lineBkp);
                bfBkp.append("\r\n");
            }
            String line = "";
            BufferedReader br = new BufferedReader(new FileReader(pathHotelDB));
            while ((line = br.readLine()) != null) {
                String[] str = line.split(",");
                if (str[1].equals(hotel.getHotelName()) && str[2].equals(hotel.getCountry()) &&
                        str[3].equals(hotel.getCity()) && str[4].equals(hotel.getStreet())) {
                    return null;

                }
            }

            long generateHotelId;
            Random random = new Random();
            generateHotelId = Math.abs(random.nextLong());

            while (checkPresenceIdHotel(generateHotelId)) {
                generateHotelId = Math.abs(random.nextLong());
            }

            hotel.setId(generateHotelId);
            Hotel addHotel = new Hotel(generateHotelId, hotel.getHotelName(),
                    hotel.getCountry(), hotel.getCity(), hotel.getStreet());
            bf.append("\r\n");
            bf.append(generateHotelId);
            bf.append(",");
            bf.append(hotel.getHotelName());
            bf.append(",");
            bf.append(hotel.getCountry());
            bf.append(",");
            bf.append(hotel.getCity());
            bf.append(",");
            bf.append(hotel.getStreet());
            try {
                utils.writeToFile(pathHotelDB, bf);
                return addHotel;
            } catch (Exception e) {
                utils.writeToFileWithClean(pathHotelDB, bfBkp);
            }


        } catch (Exception e) {
            throw new IOException("Can't write to hotelDB " + pathHotelDB);
        }
        return null;

    }

    public void deleteHotel(Hotel hotel, User user) throws Exception {
        if (user.getUserType() != UserType.ADMIN)
            throw new Exception("Deleting of hotel is not accessible to you");
        if (hotel == null)
            throw new Exception("You didn't enter hotel");
        Hotel hotelFind = findHotelById(hotel.getId());
        if (hotelFind == null)
            throw new Exception("Hotel with id " + hotel.getId() + "not exist in hotelDB");
        String line = "";
        StringBuffer res = new StringBuffer();
        StringBuffer dataBeforeChanging = new StringBuffer("");
        try (BufferedReader br = new BufferedReader(new FileReader(pathHotelDB))) {
            while ((line = br.readLine()) != null) {
                dataBeforeChanging.append(line);
                String[] strings = line.split(",");
                long hotelId = Long.parseLong(strings[0]);
                if (hotelId != hotel.getId()) {
                    res.append(line);
                    res.append("\r\n");
                }
                try {
                    utils.writeToFileWithClean(pathHotelDB, res);
                } catch (IOException e) {
                    utils.writeToFile(pathHotelDB, dataBeforeChanging);
                    throw new IOException("Can't write to file " + pathHotelDB);
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + pathHotelDB + " does not exist");
        } catch (IOException e) {
            throw new IOException("Reading from filed " + pathHotelDB + " failed");
        }

    }

    private Hotel findHotelById(Long idFind) throws Exception {
        checkIdHotel(idFind);
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(pathHotelDB))) {
            while ((line = br.readLine()) != null) {
                Hotel findHotel = new Hotel();
                String[] strings = line.split(",");
                long hotelId = Long.parseLong(strings[0]);
                if (hotelId == idFind) {
                    findHotel.setId(hotelId);
                    findHotel.setHotelName(strings[1]);
                    findHotel.setCountry(strings[2]);
                    findHotel.setCity(strings[3]);
                    findHotel.setStreet(strings[4]);
                    return findHotel;
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + pathHotelDB + " does not exist");
        }
        return null;
    }

    public ArrayList<Hotel> findHotelByName(String name) throws Exception {
        checkHotelName(name);
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(pathHotelDB))) {
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
            throw new FileNotFoundException("File " + pathHotelDB + " does not exist");
        } catch (IOException e) {
            throw new IOException("Reading from filed " + pathHotelDB + " failed");
        }
    }

    public ArrayList<Hotel> findHotelByCity(String city) throws Exception {
        checkCityOfHotel(city);
        String line = "";
        StringBuffer res = new StringBuffer();
        ArrayList<Hotel> hotelArrayList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(pathHotelDB))) {
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
            throw new FileNotFoundException("File " + pathHotelDB + " does not exist");
        } catch (IOException e) {
            throw new IOException("Reading from filed " + pathHotelDB + " failed");
        }
    }
    public ArrayList<Hotel> findHotelByCountryAndCity(String country,String city) throws Exception {
        checkCityOfHotel(city);
        checkCountryOfHotel(country);
        String line = "";
        StringBuffer res = new StringBuffer();
        ArrayList<Hotel> hotelArrayList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(pathHotelDB))) {
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
            throw new FileNotFoundException("File " + pathHotelDB + " does not exist");
        } catch (IOException e) {
            throw new IOException("Reading from filed " + pathHotelDB + " failed");
        }
    }

    public boolean checkPresenceIdHotel(long idHotel) throws Exception {
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(pathHotelDB))) {
            while ((line = br.readLine()) != null) {
                String[] strings = line.split(",");
                long idDB = Long.parseLong(strings[0]);
                if (idDB == idHotel) {
                    return true;
                }
                return false;
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + pathHotelDB + " does not exist");
        } catch (IOException e) {
            throw new IOException("Reading from filed " + pathHotelDB + " failed");
        }
        return false; //заглуха?
    }

    public boolean checkHotelName(String name) throws Exception {
        if (name == null || name.isEmpty())
            throw new Exception("Enter name of Hotel");
        if (!utils.checkWordOnLetters(name))
            throw new Exception("Name of hotel " + name + " is wrong. Try again, please");
        return true;
    }

    public boolean checkCityOfHotel(String city) throws Exception {
        if (city == null || city.isEmpty())
            throw new Exception("Enter city of Hotel");
        if (!utils.checkWordOnLetters(city))
            throw new Exception("City " + city + " is wrong. Try again, please");
        return true;
    }
    public boolean checkCountryOfHotel(String country) throws Exception {
        if (country == null || country.isEmpty())
            throw new Exception("Enter city of Hotel");
        if (!utils.checkWordOnLetters(country))
            throw new Exception("Country " + country + " is wrong. Try again, please");
        return true;
    }

    public boolean checkIdHotel(Long idHotel) throws Exception {
        if (idHotel == null || idHotel <= 0)
            throw new Exception("Id " + idHotel + " is wrong");
        return true;
    }

}
