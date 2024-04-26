package hust.soict.ict.aims.cart;
import java.util.ArrayList;

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

    //display cart list
    public void print(){
        
    }

    


}