package hust.soict.ict.aims.store;
import java.util.ArrayList;

import hust.soict.ict.aims.media.*;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    public void addMedia(Media media){
        if(itemsInStore.contains(media)){
            System.out.println("\""+media.getTitle()+"\" is already in the store.");
        }
        else{
            itemsInStore.add(media);

        }
        
    }
    public void removeMedia(Media media){
        if(itemsInStore.size()==0){
            System.out.println("Empty Store! Nothing to remove.");
        }
        else{
            if(!itemsInStore.contains(media)){
                System.out.println("\""+media.getTitle()+"\" is not in the store.");
            }
            else{
                itemsInStore.remove(media);
            }
        }
    }
    public void print(){
        System.out.println("---------------------------------------------STORE---------------------------------------------");
        for(Media media: itemsInStore){
            System.out.println(media.toString());
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
    }
    public Media search(String title){
        for(Media media: itemsInStore){
            if(media.getTitle().equalsIgnoreCase(title)) return media;
        }
        return null;
    }

    public ArrayList<Media> getItemsInStore(){
        return itemsInStore;
    }
}
