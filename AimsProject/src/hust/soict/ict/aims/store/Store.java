package hust.soict.ict.aims.store;
import hust.soict.ict.aims.media.*;

public class Store {
    int quantity = 0;
    DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[40];
    public void addDVD(DigitalVideoDisc dvd){
        itemsInStore[quantity]=dvd;
        quantity++;
    }
    public void removeDVD(DigitalVideoDisc dvd){
        int i = 0;
        while(i<quantity){
            if(itemsInStore[i].equals(dvd)){
                itemsInStore[i]=null;
                //swap element of array
                for(int j = i;j<quantity;j++){
                    DigitalVideoDisc temp;
                    temp = itemsInStore[j];
                    itemsInStore[j]=itemsInStore[j+1];
                    itemsInStore[j+1]=temp;
                }
                return;
            }
            i++;
            if(i==quantity){
                System.out.println("Cannot find matched DVD to remove.");
                return;
            }
        }
    }
    public void print(){
        for(int i=0;i<quantity;i++){
            if(itemsInStore[i]!=null){
                System.out.println(itemsInStore[i].toString());
            }
            else break;
        }
    }
}
