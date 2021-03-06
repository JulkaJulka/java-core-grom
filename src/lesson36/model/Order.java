package lesson36.model;

import lesson36.repository.GeneralRepository;

import java.util.Date;

/**
 * Created by user on 30.11.2017.
 */
public class Order {
    private long id;
    private User user;
    private Room room;
    private Date dateFrom;
    private Date dateTo;
    private double moneyPaid;

    public Order() {
    }

    public Order(User user, Room room, Date dateFrom, Date dateTo, double moneyPaid) {
        this.id = GeneralRepository.generateId();
        this.user = user;
        this.room = room;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.moneyPaid = moneyPaid;
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Room getRoom() {
        return room;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public double getMoneyPaid() {
        return moneyPaid;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public void setMoneyPaid(double moneyPaid) {
        this.moneyPaid = moneyPaid;
    }

    @Override
    public String toString() {
        String strDateFrom = "20-09-2017";
        String strDateTo = "23-09-2017";
        return id +
                "," + user.getId() +
                "," + room.getId() +
                "," + strDateFrom +
                "," + strDateTo +
                "," + room.getPrice()*3 ;
    }

}
