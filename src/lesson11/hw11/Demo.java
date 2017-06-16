package lesson11.hw11;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by user on 13.06.2017.
 */
public class Demo {
    public static void main(String[] args) {
        Date date1 = new Date();
        Room room1 = new Room(354, 120, 1, date1, "Lybid", "Kyiv");
        Room room2 = new Room(354, 289, 2, date1, "Lybid", "Kyiv");
        Room room3 = new Room(354, 1000, 5, date1, "Lybid", "Kyiv");
        Room room4 = new Room(354, 1000, 5, date1, "Lybid", "Kyiv");

        Room[] roomsBooking = new Room[]{room2};
        Room[] roomsTrip = new Room[]{room2, room3,room4};

        BookingComAPI bookingComAPI2 = new BookingComAPI(roomsBooking);
        TripAdvisorAPI tripAdvisorAPI2 = new TripAdvisorAPI(roomsTrip);

       // BookingComAPI api1 = new BookingComAPI(roomsBooking);
       // TripAdvisorAPI api2 = new TripAdvisorAPI(roomsTrip);
        API[] apis = new API[]{bookingComAPI2,tripAdvisorAPI2};
        Controller controller = new Controller(apis);
        controller.check(bookingComAPI2,tripAdvisorAPI2);
        //controller.check(bookingComAPI2, tripAdvisorAPI2);

/*int[] mas = new int[]{120,50,1000};
int a = 100;
        int[] find = new int[]{};

            for (int i = 0; i <mas.length ; i++) {
                if(mas[i] != 0 && mas[i] >= a - 100 && mas[i] <= a + 100){
                    find[i] = mas[i];
                }
                System.out.println(find[i]);

            }

        }*/

int[] mas1 = new int[]{45,0, 4567,89};
        int[] mas2 = new int[]{64,22};
        int[] mas3 = new int[]{54, 789,0,432,1900};
        int[] ar1 = new int[mas1.length+mas2.length + mas3.length];



        int[] ar2 = concatArray(mas1,mas2, mas3);
        for (int i = 0; i <mas1.length+mas2.length + mas3.length ; i++) {
            System.out.print(ar2[i] + " ");

        }
        System.out.println();



        Room[] rooms = new Room[]{room1, room2, room3};
        BookingComAPI bookingComAPI = new BookingComAPI(rooms);
        TripAdvisorAPI tripAdvisorAPI = new TripAdvisorAPI(rooms);
        //read(bookingComAPI);
       // read(tripAdvisorAPI);
    }

       /* private  static void read(API api){
            Room[] roomsFind = api.findRooms(200,0,"gg","fdj");
            for (Room room:roomsFind) {
                System.out.println(room);

            }*/
        //}
        private static int[] concatArray(int[] mas1, int[] mas2, int[] mas3){
            if(mas1 == null){
                System.out.println(mas2);
            }
            if(mas2 == null){
                System.out.println(mas1);
            }
            int r[] = new int[mas1.length + mas2.length+ mas3.length];
            System.arraycopy(mas1, 0, r, 0, mas1.length);
            System.arraycopy(mas2, 0, r, mas1.length, mas2.length);
            System.arraycopy(mas3, 0, r, mas2.length + mas1.length, mas3.length);
            return r;
        }


}
