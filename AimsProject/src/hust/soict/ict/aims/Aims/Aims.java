package hust.soict.ict.aims.Aims;
import java.util.ArrayList;
import java.util.List;
import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.media.*;
import hust.soict.ict.aims.store.*;
public class Aims{
    public static void main(String[] args){
    //create a new order
    Cart cart = new Cart();
    List<Media> medias = new ArrayList<Media>();

    DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
    DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
    DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation","Director", 89, 18.99f);
    CompactDisc cd1 = new CompactDisc("Thriller", "Pop", "Michael Jackson", 9.99f);
    CompactDisc cd2 = new CompactDisc("Kind of Blue", "Jazz", "Miles Davis", 15.50f);
    CompactDisc cd3 = new CompactDisc("Bohemian Rhapsody", "Rock", "Queen", 11.99f);
    Book book1 = new Book("Hannibal", "Crime Thriller", 8.99f);
    book1.addAuthor("Thomas Harris");
    Book book2 = new Book("Red Dragon", "Crime Thriller", 9.11f);
    book2.addAuthor("Thomas Harris");
    Book book3 = new Book("The Martian", "Science Fiction", 8.97f);
    book2.addAuthor("Andy Weir");
    medias.add(book1); medias.add(book2); medias.add(book3);
    medias.add(cd1); medias.add(cd2); medias.add(cd3);
    medias.add(dvd1); medias.add(dvd2); medias.add(dvd3);

    for(Media media: medias){
        System.out.println(media.toString());
    }
}
}
