package lesson15.hw15.api;

/**
 * Created by user on 13.06.2017.
 */
public interface API {
    Room[] findRooms(int price, int persons, String city, String hotel);
    Room[] getAll();
}
