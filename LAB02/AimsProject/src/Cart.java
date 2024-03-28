public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;
    
    //add a disc
    public void addDigitalVideoDisc(DigitalVideoDisc disc){
       if(qtyOrdered<MAX_NUMBERS_ORDERED){
            itemsOrdered[qtyOrdered]=disc;
            qtyOrdered++;
            System.out.println("The DVD has been added to your cart.");
            if(qtyOrdered==MAX_NUMBERS_ORDERED) System.out.println("Your cart is now full");
       }
       else{
            System.out.printf("The cart is full. The DVD %s cannot be added to your cart.", disc.getTitle());
       }
    }

    //add list of discs
    public void addDigitalVideoDisc(DigitalVideoDisc[] discList){
        for(int i = 0;i<discList.length;i++){
            if(qtyOrdered<MAX_NUMBERS_ORDERED){
                itemsOrdered[qtyOrdered]=discList[i];
                qtyOrdered++;
            }
            else{
                System.out.println("The cart is now full. Cannot add the following discs:");
                for(int j = i; j<discList.length;j++){
                    System.out.println(discList[j].getTitle());
                }
                return;
            }
        }
        System.out.println("All the discs in the list have been added.");
    }

    //add two discs
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }
    //remove disc
    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        int i = 0;
        while(i<qtyOrdered){
            if(disc.equals(itemsOrdered[i])){
                itemsOrdered[i]=null;
                //swap elements of arrays;
                for(int j = i; j<qtyOrdered-1;j++){
                    DigitalVideoDisc temp;
                    temp = itemsOrdered[j];
                    itemsOrdered[j] = itemsOrdered[j+1];
                    itemsOrdered[j+1]=temp;
                }
                qtyOrdered--;
                System.out.println("The disc has been removed.");
                return;
            }
            i++;
        }
        System.out.println("Cannot remove as the disc is not in the cart.");
    }
    
    //total cost of Cart
    public float totalCost(){
        float total=0f;
        for(int i=0;i<qtyOrdered;i++){
            total+=itemsOrdered[i].getCost();
        }
        return total;
    }

    //display cart list
    public void dispCart(){
        for(int i=0;i<MAX_NUMBERS_ORDERED;i++){
            if(itemsOrdered[i]!=null){
                System.out.printf("%2d. %-17s %.2f", i+1, itemsOrdered[i].getTitle(), itemsOrdered[i].getCost());
                System.out.println("");
            }
            else break;
        }
    }

}