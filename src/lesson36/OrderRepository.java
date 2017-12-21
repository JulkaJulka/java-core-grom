package lesson36;

import lesson36.model.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by user on 30.11.2017.
 */
public class OrderRepository {
    private static final String pathOrderDB = "D:/Ubuntu_backup/dev/OrderDB.txt";
    private final String pathRoomDB = "D:/Ubuntu_backup/dev/RoomDB.txt";
    private final String pathHotelDB = "D:/Ubuntu_backup/dev/HotelDB.txt";
    private final String pathUserDB = "D:/Ubuntu_backup/dev/UserDB.txt";
    private Utils utils = new Utils();

    public void bookRoom(long roomId, long userId, long hotelId) throws Exception {
        if (findRoomById(roomId) == null)
            throw new Exception("Room with id " + roomId + " does not exist in dB");
        if (findUserlById(userId) == null)
            throw new Exception("User with id " + userId + " does not exist in dB");
        if (findHotelById(hotelId) == null)
            throw new Exception("Hotel with id " + hotelId + " does not exist in dB");

        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(pathRoomDB));
             BufferedReader brOrder = new BufferedReader(new FileReader(pathOrderDB))) {
            StringBuffer bfBefore = new StringBuffer();
            StringBuffer addOrder = new StringBuffer("");
            while ((line = brOrder.readLine()) != null) {
                bfBefore.append(line);
                bfBefore.append("\r\n");
            }
            while ((line = br.readLine()) != null) {
                String[] strings = line.split(",");
                if (Long.parseLong(strings[0]) == roomId && Long.parseLong(strings[6]) == hotelId) {
                    Order order = new Order();
                    generateOrderId(order);
                    addOrder.append("\r\n");
                    addOrder.append(order.getId());
                    addOrder.append(",");
                    addOrder.append(userId);
                    addOrder.append(",");
                    addOrder.append(roomId);
                    addOrder.append(",");
                    addOrder.append("20-09-2017");
                    addOrder.append(",");
                    addOrder.append("23-09-2017");
                    addOrder.append(",");
                    addOrder.append(findRoomById(roomId).getPrice() * 3);
                    try {
                        utils.writeToFile(pathOrderDB, addOrder);
                    } catch (IOException e) {
                        utils.writeToFileWithClean(pathOrderDB, bfBefore);
                        throw new IOException("Can't write to file " + pathOrderDB);
                    }
                }

            }
        } catch (Exception e) {
            throw new IOException("Can't write to orderlDB " + pathOrderDB);
        }
    }

    public void cancelReservation(long roomId, long userId, long hotelId) throws Exception {
        if (findRoomById(roomId) == null)
            throw new Exception("Room with id " + roomId + " does not exist in dB");
        if (findUserlById(userId) == null)
            throw new Exception("User with id " + userId + " does not exist in dB");
        if (findHotelById(hotelId) == null)
            throw new Exception("Hotel with id " + hotelId + " does not exist in dB");

        String line;
        StringBuffer res = new StringBuffer();
        StringBuffer dataBeforeChanging = new StringBuffer("");
        try (BufferedReader br = new BufferedReader(new FileReader(pathOrderDB))) {

            while ((line = br.readLine()) != null) {
                dataBeforeChanging.append(line);
                String[] strings = line.split(",");
                long stayRoomId = Long.parseLong(strings[2]);
                long stayUserId = Long.parseLong(strings[1]);

                if (stayUserId == userId && stayRoomId == roomId && findRoomById(stayRoomId) != null &&
                        findRoomById(stayRoomId).getHotel() != null &&
                        findRoomById(stayRoomId).getHotel().getId() == hotelId) {
                    res.append("");

                } else {
                    res.append(line);
                    res.append("\r\n");
                }
                try {
                    utils.writeToFileWithClean(pathOrderDB, res);
                } catch (IOException e) {
                    utils.writeToFile(pathOrderDB, dataBeforeChanging);
                    throw new IOException("Can't write to file " + pathOrderDB);
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + pathOrderDB + " does not exist");
        } catch (IOException e) {
            throw new IOException("Reading from filed " + pathOrderDB + " failed");
        }

    }

    private void generateOrderId(Order order) throws Exception {
        long generateOrderId;
        Random random = new Random();
        generateOrderId = Math.abs(random.nextLong());

        while (checkPresenceIdOrder(generateOrderId)) {
            generateOrderId = Math.abs(random.nextLong());
        }
        order.setId(generateOrderId);
    }

    private boolean checkPresenceIdOrder(long idOrder) throws Exception {
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(pathOrderDB))) {
            while ((line = br.readLine()) != null) {
                String[] strings = line.split(",");
                long idDB = Long.parseLong(strings[0]);
                if (idDB == idOrder) {
                    return true;
                }
                return false;
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + pathOrderDB + " does not exist");
        } catch (IOException e) {
            throw new IOException("Reading from filed " + pathOrderDB + " failed");
        }
        return false; //заглуха?
    }

    public User findUserlById(Long idFind) throws Exception {
        checkIdUser(idFind);
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(pathUserDB))) {
            while ((line = br.readLine()) != null) {
                User findUser = new User();
                String[] strings = line.split(",");
                long userId = Long.parseLong(strings[0]);
                if (userId == idFind) {
                    findUser.setId(userId);
                    findUser.setUserName(strings[1]);
                    findUser.setPassword(strings[2]);
                    findUser.setCountry(strings[3]);
                    if (strings[4].equals("ADMIN")) {
                        findUser.setUserType(UserType.ADMIN);
                    } else {
                        findUser.setUserType(UserType.USER);
                    }
                    return findUser;
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + pathUserDB + " does not exist");
        }
        return null;
    }

    private boolean checkIdUser(Long idUser) throws Exception {
        if (idUser == null || idUser <= 0)
            throw new Exception("Id " + idUser + " is wrong");
        return true;
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

    private boolean checkIdRoom(Long idRoom) throws Exception {
        if (idRoom == null || idRoom <= 0)
            throw new Exception("Id " + idRoom + " is wrong");
        return true;
    }

    public Hotel findHotelById(Long idFind) throws Exception {
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
}
