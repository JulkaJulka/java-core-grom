package lesson11.hw11;

/**
 * Created by user on 13.06.2017.
 */
public interface API {
    Room[] findRooms(int price, int persons, String city, String hotel);
    Room[] getAll();
}
