package lesson8.ads;

/**
 * Created by user on 17.05.2017.
 */
public class HouseAd extends Ad {
    String ownerName;
    String adress;
    double square;
    int floors;

    public HouseAd(long id, int price, String ownerName, String adress, double square, int floors) {
        super(id, price);
        this.ownerName = ownerName;
        this.adress = adress;
        this.square = square;
        this.floors = floors;
    }

    boolean checkOwner(){
Owners owners = new Owners();
        for(String owner:owners.owners){
            if(ownerName == owner)
                return true;
        }
        return false;
    }
}
