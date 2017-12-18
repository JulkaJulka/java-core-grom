package lesson36;

import lesson36.model.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

/**
 * Created by user on 30.11.2017.
 */
public class RoomRepository {
    private final String pathRoomDB = "D:/Ubuntu_backup/dev/RoomDB.txt";
    private final String pathHotelDB = "D:/Ubuntu_backup/dev/HotelDB.txt";
    private Utils utils = new Utils();

    public Collection findRooms(Filter filter) throws Exception {
        String line;
        ArrayList<Room> roomArrayList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(pathRoomDB))) {
            while ((line = br.readLine()) != null) {
                String[] strs = line.split(",");
                long roomId = Long.parseLong(strs[0]);
                int numberOfGuests = Integer.parseInt(strs[1]);
                double price = Double.parseDouble(strs[2]);
                boolean breakfastIncluded = Boolean.parseBoolean(strs[3]);
                boolean isPetsAllowed = Boolean.parseBoolean(strs[4]);

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                Date dateAvailableFrom = simpleDateFormat.parse(strs[5]);

                Room room = new Room();
                room.setId(roomId);
                room.setNumberOfGuests(numberOfGuests);
                room.setPrice(price);
                room.setBreakfastIncluded(breakfastIncluded);
                room.setPetsAllowed(isPetsAllowed);
                room.setDateAvailableFrom(dateAvailableFrom);
                room.setHotel(findHotelById(Long.parseLong(strs[6])));

                if (conformityFilter(room, filter)) {
                    roomArrayList.add(room);
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + pathRoomDB + " does not exist");
        } catch (IOException e) {
            throw new IOException("Reading from filed " + pathRoomDB + " failed");
        }
        return roomArrayList;
    }

    public Room addRoom(Room room, User user) throws Exception {
        if (user.getUserType() != UserType.ADMIN)
            throw new Exception("Adding of room is not accessible to you");
        if (room == null)
            throw new Exception("You enter wrong room");

        try {
            StringBuffer bf = new StringBuffer("");
            StringBuffer bfBkp = new StringBuffer("");
            String lineBkp;
            BufferedReader brBkp = new BufferedReader(new FileReader(pathRoomDB));

            while ((lineBkp = brBkp.readLine()) != null) {
                bfBkp.append(lineBkp);
                bfBkp.append("\r\n");
            }
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            String strDateAvailableFrom = df.format(room.getDateAvailableFrom());

            generateRoomId(room);

            bf.append("\r\n");
            bf.append(room.getId());
            bf.append(",");
            bf.append(room.getNumberOfGuests());
            bf.append(",");
            bf.append(room.getPrice());
            bf.append(",");
            bf.append(room.isBreakfastIncluded());
            bf.append(",");
            bf.append(room.isPetsAllowed());
            bf.append(",");
            bf.append(strDateAvailableFrom);
            bf.append(",");
            bf.append(room.getHotel().getId());

            try {
                utils.writeToFile(pathRoomDB, bf);
                return room;
            } catch (Exception e) {
                utils.writeToFileWithClean(pathRoomDB, bfBkp);
            }
        } catch (Exception e) {
            throw new IOException("Can't write to roomDB " + pathRoomDB);
        }
        return null;

    }

    public void deleteRoom(Room room, User user) throws Exception {
        if (user.getUserType() != UserType.ADMIN)
            throw new Exception("Deleting of room is not accessible to you");
        if (room == null)
            throw new Exception("You didn't enter room");
        Room roomFind = findRoomById(room.getId());
        if (roomFind == null)
            throw new Exception("Room with id " + room.getId() + "not exist in hotelDB");
        String line;
        StringBuffer res = new StringBuffer();
        StringBuffer dataBeforeChanging = new StringBuffer("");
        try (BufferedReader br = new BufferedReader(new FileReader(pathRoomDB))) {
            while ((line = br.readLine()) != null) {
                dataBeforeChanging.append(line);
                String[] strings = line.split(",");
                long roomId = Long.parseLong(strings[0]);
                if (roomId != room.getId()) {
                    res.append(line);
                    res.append("\r\n");
                }
                try {
                    utils.writeToFileWithClean(pathRoomDB, res);
                } catch (IOException e) {
                    utils.writeToFile(pathRoomDB, dataBeforeChanging);
                    throw new IOException("Can't write to file " + pathRoomDB);
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + pathRoomDB + " does not exist");
        } catch (IOException e) {
            throw new IOException("Reading from filed " + pathRoomDB + " failed");
        }
    }

    private void generateRoomId(Room room) throws Exception {
        long generateRoomId;
        Random random = new Random();
        generateRoomId = Math.abs(random.nextLong());

        while (checkPresenceIdRoom(generateRoomId)) {
            generateRoomId = Math.abs(random.nextLong());
        }
        room.setId(generateRoomId);
    }

    private boolean checkPresenceIdRoom(long idRoom) throws Exception {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(pathRoomDB))) {
            while ((line = br.readLine()) != null) {
                String[] strings = line.split(",");
                long idDB = Long.parseLong(strings[0]);
                if (idDB == idRoom) {
                    return true;
                }
                return false;
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + pathRoomDB + " does not exist");
        } catch (IOException e) {
            throw new IOException("Reading from filed " + pathRoomDB + " failed");
        }
        return false; //заглуха?
    }

    private boolean conformityFilter(Room room, Filter filter) {
        if (filter == null)
            return false;
        if ((filter.getNumberOfGuests() == 0 || room.getNumberOfGuests() == filter.getNumberOfGuests()) &&
                (filter.getPrice() == 0 || room.getPrice() == filter.getPrice()) &&
                filter.isBreakfastIncluded() == room.isBreakfastIncluded() &&
                        filter.isPetsAllowed() == room.isPetsAllowed() &&
                        (filter.getDateAvailableFrom() == null ||
                                filter.getDateAvailableFrom().compareTo(room.getDateAvailableFrom()) >= 0) &&
                        (filter.getCountry()== null ||
                                room.getHotel() != null && filter.getCountry().equals(room.getHotel().getCountry()) &&
                        ( filter.getCity() == null ||
                                room.getHotel() != null && filter.getCity().equals(room.getHotel().getCity()))))
            return true;

        return false;
    }

    public Room findRoomById(Long idFind) throws Exception {
        checkIdRoom(idFind);
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(pathRoomDB))) {
            while ((line = br.readLine()) != null) {
                Room findRoom = new Room();
                String[] strings = line.split(",");
                long roomId = Long.parseLong(strings[0]);
                if (roomId == idFind) {
                    findRoom.setId(roomId);
                    findRoom.setNumberOfGuests(Integer.parseInt(strings[1]));
                    findRoom.setPrice(Double.parseDouble(strings[2]));
                    findRoom.setBreakfastIncluded(Boolean.parseBoolean(strings[3]));
                    findRoom.setPetsAllowed(Boolean.parseBoolean(strings[4]));

                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    Date dateAvailableFrom = simpleDateFormat.parse(strings[5]);

                    findRoom.setDateAvailableFrom(dateAvailableFrom);

                    findRoom.setHotel(findHotelById(Long.parseLong(strings[6])));
                    return findRoom;
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + pathHotelDB + " does not exist");
        }
        return null;
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

    private boolean checkIdHotel(Long idHotel) throws Exception {
        if (idHotel == null || idHotel <= 0)
            throw new Exception("Id " + idHotel + " is wrong");
        return true;
    }
    private boolean checkIdRoom(Long idRoom) throws Exception {
        if (idRoom == null || idRoom <= 0)
            throw new Exception("Id " + idRoom + " is wrong");
        return true;
    }
}
