package lesson28;

import java.util.Comparator;

/**
 * Created by user on 20.09.2017.
 */
public class FullComparator implements Comparator<Capability> {

    // если channelName не равно - сравниваю по нему +
    // если равно - сравниваю по fingerprint
    // если fingerprint не равно - сравнимваю по нему
    // если равно - сравниваю DateCreated
    // если DateCreated не равно - сравниваю по нему
    // если равно - обьекты равны
    @Override
    public int compare(Capability o1, Capability o2) {
        if (!o1.getChannelName().equals(o2.getChannelName())) {
            return o1.getChannelName().compareTo(o2.getChannelName());
        }
        if(!o1.getFingerprint().equals(o2.getFingerprint())) {
            return o1.getFingerprint().compareTo(o2.getFingerprint());
        }
        if(!o2.getDateCreated().equals(o1.getDateCreated())){
            return o2.getDateCreated().compareTo(o1.getDateCreated());
        }

        return 0;
    }
}
