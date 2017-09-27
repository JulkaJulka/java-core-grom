package lesson28;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by user on 20.09.2017.
 */
public class DemoComparator {
    public static void main(String[] args) {
        Capability capability1 = new Capability(1001, null, "rrrr", false, new Date());
        Capability capability2 = new Capability(1005, "test", "rrrr", false, new Date());
        Capability capability3 = new Capability(900, "2222", "2222", true, new Date());
        Capability capability4 = new Capability(900, "2222", "1111", true, new Date());

        ArrayList<Capability> capabilities = new ArrayList<>();
        capabilities.add(capability1);
        capabilities.add(capability2);
        capabilities.add(capability3);
        capabilities.add(capability4);

        System.out.println(capabilities);

        capabilities.sort(new IsActiveComparator());

        System.out.println(capabilities);

        System.out.println("---Test1---");

        capabilities.sort(new FullComparator());
        System.out.println("----");
        System.out.println(capabilities);

        /*Comparator<Capability> comparator = new Comparator<Capability>() {
// если channelName не равно - сравниваю по нему +
            // если равно - сравниваю по fingerprint
            // если fingerprint не равно - сравнимваю по нему
            // если равно - сравниваю DateCreated
            // если DateCreated не равно - сравниваю по нему
            // если равно - обьекты равны


            @Override
            public int compare(Capability o1, Capability o2) {
                if (!o1.getChannelName().equals(o2))
                    return o1.getChannelName().compareTo(o2.getChannelName());
                return 0;
            }
        };*/
    }
}




