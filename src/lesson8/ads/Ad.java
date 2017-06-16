package lesson8.ads;

import java.util.Date;

/**
 * Created by user on 17.05.2017.
 */
public class Ad extends BaseEntity{
    int price;
    Date createdDate;

    public Ad( long id, int price) {
        super(id);
        this.price = price;
        this.createdDate = new Date();
    }

    void publishAd(){
        //somelogic
    }
}
