package hust.soict.ict.aims.Aims;
import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.media.*;
import hust.soict.ict.aims.store.*;
public class Aims{
    public static void main(String[] args){
    //create a new order
    Cart order = new Cart();

    //Create new dvd objects and add them to the cart
    DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
    DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
    DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation","Director", 89, 18.99f);
}
}
