package hust.soict.ict.aims.cart;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Iterator;
import javax.naming.LimitExceededException;

import hust.soict.ict.aims.media.*;
public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    //add media method
    public void addMedia(Media media) throws LimitExceededException{
        if(itemsOrdered.size()>=MAX_NUMBERS_ORDERED){
            throw new LimitExceededException("Your cart is already full");
        }
        else{
            if(itemsOrdered.contains(media)){
                System.out.println("\""+media.getTitle()+"\" is already in your cart.");
            }
            else{
                itemsOrdered.add(media);
                System.out.println("\""+media.getTitle()+"\" has been added to your cart");
            }
        }
    }
    //remove media method
    public void removeMedia(Media media){
        if(itemsOrdered.size()==0){
            System.out.println("Empty Cart! Nothing to remove.");
        }
        else{
            if(!itemsOrdered.contains(media)){
                System.out.println("\""+media.getTitle()+"\" is not in your cart.");
            }
            else{
                itemsOrdered.remove(media);
                System.out.println("\""+media.getTitle()+"\" has been succesfully removed from your cart");
            }
        }
    }
    
    //get total cost of cart
    public float totalCost(){
        float total=0f;
        for(Media media: itemsOrdered){
            total+=media.getCost();
        }
        return total;
    }

    //get total number of media
    public int getQuantities(){
        return itemsOrdered.size();
    }
    
    //display cart list
    public void print() {
        System.out.println("---------------------------------------------CART---------------------------------------------");
        System.out.println("Ordered Items:");
        for (Media media : itemsOrdered) {
            System.out.println(media.toString());
        }
        System.out.println("Total items: " + itemsOrdered.size());
        System.out.println("Total cost: " + totalCost()+"$");
        System.out.println("----------------------------------------------------------------------------------------------");
    }
    public Media searchByTitle(String title){
        for(Media media: itemsOrdered){
            if(media.getTitle().equalsIgnoreCase(title)) return media;
        }
        return null;
    }
    public Media searchByID(int id){
        for(Media media: itemsOrdered){
            if(media.getId()==id) return media;
        }
        return null;
    }
    //empty the cart
    public void empty(){
        for(Media media:itemsOrdered){
            media = null;
        }
    }

    //sort the media in the cart
    public void sortMediaByTitle() {
        Collections.sort((List<Media>)itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        Iterator<Media> iterator = itemsOrdered.iterator();
    
        while (iterator.hasNext()) {
            System.out.println(((Media)iterator.next()).toString());
        }
    }
    public void sortMediaByCost() {
        Collections.sort((List<Media>)itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        for(Media m:itemsOrdered){
            System.out.println(m.toString());
        }
    }


}