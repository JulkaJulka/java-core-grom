package lesson25;

/**
 * Created by user on 20.08.2017.
 */
public class Order extends IdEntity {
    private  long id;

    public Order(long id) {
        this.id = id;
    }

    @Override
    public long getId() {
        return id;
    }
}
