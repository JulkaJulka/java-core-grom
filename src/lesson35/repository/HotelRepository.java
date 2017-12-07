package lesson35.repository;

import lesson35.model.Hotel;


import java.io.*;

/**
 * Created by user on 30.11.2017.
 */
public class HotelRepository {
    private final String pathHotelDB = "D:/Ubuntu_backup/dev/HotelDB.txt";

    public Hotel findHotelByName(String name) throws Exception{
        checkHotelName(name);

        String line = "";
        StringBuffer res = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(pathHotelDB))) {
            while ((line = br.readLine()) != null) {
                Hotel findHotel = new Hotel();
                String[] strings = line.split(",");
                if (strings[1].equals(name)){
                    long hotelId = Long.parseLong(strings[0]);
                    findHotel.setId(hotelId);
                    findHotel.setHotelName(strings[1]);
                    findHotel.setCountry(strings[2]);
                    findHotel.setCity(strings[3]);
                    findHotel.setStreet(strings[4]);
                    return findHotel;}
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + pathHotelDB + " does not exist");
        } catch (IOException e) {
            throw new IOException("Reading from filed " + pathHotelDB + " failed");
        }
        return null;
    }

    public Hotel findHotelByCity(String city) throws Exception{
        checkCityOfHotel(city);
        String line = "";
        StringBuffer res = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(pathHotelDB))) {
            while ((line = br.readLine()) != null) {
                Hotel findHotel = new Hotel();
                String[] strings = line.split(",");
                if (strings[3].equals(city)){
                    long hotelId = Long.parseLong(strings[0]);
                    findHotel.setId(hotelId);
                    findHotel.setHotelName(strings[1]);
                    findHotel.setCountry(strings[2]);
                    findHotel.setCity(strings[3]);
                    findHotel.setStreet(strings[4]);
                    return findHotel;}
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + pathHotelDB + " does not exist");
        } catch (IOException e) {
            throw new IOException("Reading from filed " + pathHotelDB + " failed");
        }
        return null;
    }

    public void writeToFile(String path, StringBuffer contentToWrite) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.append(contentToWrite);

        } catch (IOException e) {
            throw new IOException("Can't write to file " + path);
        }
    }

    public boolean checkHotelName (String name) throws Exception{
        if(name == null || name.isEmpty())
            throw new Exception("Enter name of Hotel");
        if(!checkWordOnLetters(name))
            throw new Exception("Name of hotel " + name + " is wrong. Try again, please");
        return true;
    }
    public boolean checkCityOfHotel (String city) throws Exception{
        if(city == null || city.isEmpty())
            throw new Exception("Enter city of Hotel");
        if(!checkWordOnLetters(city))
            throw new Exception("City " + city + " is wrong. Try again, please");
        return true;
    }

    private boolean checkWordOnLetters(String word) {
        char[] chars = word.toCharArray();
        for (char ch : chars) {
            if (!Character.isLetter(ch))
                return false;
        }

        return true;
    }
}
