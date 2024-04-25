package hust.soict.ict.aims.store;
import hust.soict.ict.aims.disc.DigitalVideoDisc;
public class StoreTest{
    public static void main(String[] args){
    Store store = new Store();

    //Create new dvd objects and add them to the cart
    DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
    DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
    DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation","Director", 89, 18.99f);
    store.addDVD(dvd1);
    store.addDVD(dvd2);
    store.addDVD(dvd3);
    store.removeDVD(dvd3);
    store.print();
}
}
