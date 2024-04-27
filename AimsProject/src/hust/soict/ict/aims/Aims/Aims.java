package hust.soict.ict.aims.Aims;
import java.util.Scanner;
import javax.naming.LimitExceededException;

import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.media.*;
import hust.soict.ict.aims.store.*;
public class Aims{
    private static Cart cart = new Cart();
    private static Store store = new Store();
    public static void main(String[] args){
        storeSetup();
        showMenu();
        
    }

    //add media to the store
    public static void storeSetup(){
        //DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation","Guy Ritchie", 89, 18.99f);
        store.addMedia(dvd1); store.addMedia(dvd2); store.addMedia(dvd3); 

        //CD + Track
        CompactDisc cd1 = new CompactDisc("Thriller", "Pop", "Michael Jackson", 9.99f);
        Track track1 = new Track("Billie Jean", 236); 
        Track track2 = new Track("Beat It", 252);
        Track track3 = new Track("Man in the Mirror", 331);
        cd1.addTrack(track1); cd1.addTrack(track2); cd1.addTrack(track3);
        
        CompactDisc cd2 = new CompactDisc("Kind of Blue", "Jazz", "Miles Davis", 15.50f);
        Track track4 = new Track("So What", 431);  
        Track track5 = new Track("Freddie Freeloader", 539);
        cd2.addTrack(track4); cd2.addTrack(track5); 

        CompactDisc cd3 = new CompactDisc("Bohemian Rhapsody", "Rock", "Queen", 11.99f);
        Track track6 = new Track("Bohemian Rhapsody", 355); 
        Track track7 =  new Track("Killer Queen", 205); 
        Track track8 = new Track("Somebody to Love", 296); 
        cd3.addTrack(track6); cd3.addTrack(track7); cd3.addTrack(track8);
        
        store.addMedia(cd1); store.addMedia(cd2); store.addMedia(cd3);

        //book
        Book book1 = new Book("Hannibal", "Crime Thriller", 8.99f);
        book1.addAuthor("Thomas Harris");
        Book book2 = new Book("Red Dragon", "Crime Thriller", 9.11f);
        book2.addAuthor("Thomas Harris");
        Book book3 = new Book("The Martian", "Science Fiction", 8.97f);
        book3.addAuthor("Andy Weir");
        store.addMedia(book1); store.addMedia(book2); store.addMedia(book3);
    }

    //clear console method
    public static void clc(){
        for(int i=0;i<20;i++){
            System.out.println();
        }
    }

    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("AIMS: ");
            System.out.println("--------------------------------");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3");
            String option = scanner.nextLine();
            switch (option) {
                case "0":
                    clc();
                    System.out.println("Thank you! Goodbye and have a nice day.");
                    scanner.close();
                    return;
                case "1":
                    clc();
                    store.print();
                    storeMenu();
                    break;
                case "2":
                    updateStore();
                    break;
                case "3":
                    clc();
                    cart.print();
                    cartMenu();
                    break;
                default:
                    clc(); 
                    System.out.println("Invalid option, please choose a number: 0-1-2-3.");
                    break;
                }
        }
        
    }

    public static void storeMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean back = false;
        while(!back){
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media’s details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4");
            String option = scanner.nextLine();
            switch (option) {
                case "0":
                    clc();
                    back=true;
                    break;
                case "1":
                    while(true){
                        System.out.print("Enter the title of the media to view details(Press 0 to return): ");
                        String title = scanner.nextLine();
                        if(title.equals("0")) break;
                        Media foundMedia=store.search(title);
                        if(foundMedia==null){
                            System.out.println(title+" is not in the store. Please try another.");
                        }
                        else{
                            System.out.println("Details: "+foundMedia.toString());
                            mediaDetailsMenu(foundMedia);
                        }
                    }
                    break;
                case "2":
                    while(true){
                        System.out.print("Enter the title of the media to add to your cart(Press 0 to return): ");
                        String title = scanner.nextLine();
                        if(title.equals("0")) break;
                        Media foundMedia=store.search(title);
                        if(foundMedia==null){
                            System.out.println(title+" is not in the store. Please try another.");
                        }
                        else{
                            System.out.println(foundMedia.toString());
                            try {
                                cart.addMedia(foundMedia);
                            } catch (LimitExceededException e) {
                            break;
                            }
                            System.out.println("Current number of items in your cart: "+cart.getQuantities());
                        }
                    }
                    break; 
                case "3":
                    while(true){
                        System.out.print("Enter the title of the media to play(Press 0 to return): ");
                        String title = scanner.nextLine();
                        if(title.equals("0")) break;
                        Media foundMedia=store.search(title);
                        if(foundMedia==null){
                            System.out.println(title+" is not in the store. Please try another.");
                        }
                        else if(foundMedia instanceof CompactDisc || foundMedia instanceof DigitalVideoDisc){
                            foundMedia.play();
                        }
                        else{
                            System.out.println(title+ " cannot be played! Please try another.");
                        }
                    }
                    break;
                case "4":
                    clc();
                    cart.print();
                    cartMenu();
                    break;
                default:
                    clc(); 
                    System.out.println("Invalid option! Please choose a number: 0-1-2-3-4.");
                    break;
                }
        }  
    }

    public static void mediaDetailsMenu(Media media) {
        Scanner scanner = new Scanner(System.in);
        
        boolean back = false;
        while(!back){
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");
            String option = scanner.nextLine();
            switch (option) {
                case "0":
                    clc();
                    back = true;
                    break;
                case "1":
                    clc();
                    try {
                        cart.addMedia(media);
                    } catch (LimitExceededException e) {
                        break;
                    }
                    break;
                case "2":
                if(media instanceof CompactDisc || media instanceof DigitalVideoDisc){
                    clc();
                    media.play();
                }
                else{
                    System.out.println(media.getTitle()+ " cannot be played! Please try another.");
                }
                    break;
                default:
                    break;
            }

        }
    }
    
    public static void cartMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean back = false;
        while(!back){
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter media in cart");
            System.out.println("2. Sort media in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4-5");
            String option = scanner.nextLine();
            switch (option) {
                case "0":
                    clc();
                    back=true;
                    break;
                case "1":
                    System.out.println("Filter by:\n(1)Title\n(2)Cost\n");
                    int filterOption = scanner.nextInt();
                    scanner.nextLine();
                    while(true){
                        Media foundMedia = null;
                        if(filterOption==1){
                            System.out.print("Enter the title of the media to filter (press 0 to stop): ");
                            String title = scanner.nextLine();
                            if(title.equals("0")) break;
                            foundMedia=cart.searchByTitle(title);
                        }
                        else if(filterOption==2){
                            System.out.print("Enter the ID of the media to filter (press 0 to stop): ");
                            int id = scanner.nextInt();
                            if(id==0) break;
                            foundMedia=cart.searchByID(id);
                        }
                        else{
                            clc();
                            System.out.println("Invalid Input.");
                        }
                        if(foundMedia==null){
                            clc();
                            System.out.println("There is no matched items in your cart.");
                        }
                        else{
                            clc();
                            System.out.println("Result: "+foundMedia.toString());
                        }
                    }
                    break;
                case "2":
                    System.out.println("Sort medias in cart by (1) title or (2) cost:");
                    int sortOption = scanner.nextInt();
                    scanner.nextLine();
                    if (sortOption == 1) {
                        cart.sortMediaByTitle();
                    } else if (sortOption == 2) {
                        cart.sortMediaByCost();
                    } else {
                        System.out.println("Invalid option.");
                    }
                    break;
                case "3":
                    while(true){
                        System.out.print("Enter the title of the media to remove (press 0 to return): ");
                        String title = scanner.nextLine();
                        if(title.equals("0")) break;
                        Media foundMedia = cart.searchByTitle(title);
                        if(foundMedia==null){
                            clc();
                            System.out.println(title+" is not in the cart. Please try another");
                        }
                        else{
                            cart.removeMedia(foundMedia);
                            System.out.println(foundMedia.getTitle()+" has been successfully removed.");
                        }
                    }
                    break;
                case "4":
                    while(true){
                        System.out.print("Enter the title of the media to play (press 0 to return): ");
                        String title = scanner.nextLine();
                        if(title.equals("0")) break;
                        Media foundMedia=cart.searchByTitle(title);
                        if(foundMedia==null){
                            clc();
                            System.out.println(title+" is not in the cart. Please try another.");
                        }
                        else if(foundMedia instanceof CompactDisc || foundMedia instanceof DigitalVideoDisc){
                            clc();
                            foundMedia.play();
                        }
                        else{
                            clc();
                            System.out.println(title+ " cannot be played! Please try another.");
                        }
                    }
                    break;
                case "5":
                    clc();
                    System.out.println("The order has successfully created.\nYour cart is now empty.");
                    cart.empty();
                    break;  
                default:
                    System.out.println("Invalid option. Please choose a number: 0-1-2-3-4-5.");
                    break;
            }
        }
        
    }

    public static void updateStore(){
        Scanner scanner = new Scanner(System.in);
        boolean back = false;
        while (!back) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add a media");
            System.out.println("2. Remove a media");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");
            String option = scanner.nextLine();
            switch (option) {
                case "0":
                    clc();
                    back = true;
                    break;
                case "1":
                    boolean back1 = false;
                    while(!back1){
                        System.out.println("Enter the category of the media:\n(1)Book\n(2)CD\n(3)DVD\n(0)Back");
                        String choice = scanner.nextLine();
                        switch(choice){
                            case "0":
                                clc();
                                back1=true;
                                break;
                            case "1":
                                clc();
                                System.out.println("Enter book title: ");
                                String bookTitle = scanner.nextLine();
                                System.out.println("Enter book category: ");
                                String bookCategory = scanner.nextLine();
                                System.out.println("Enter book cost: ");
                                Float bookCost = scanner.nextFloat();
                                scanner.nextLine();
                                Book newBook = new Book(bookTitle, bookCategory, bookCost);
                                store.addMedia(newBook);
                                break;
                            case "2":
                                clc();
                                System.out.println("Enter CD title: ");
                                String cdTitle = scanner.nextLine();
                                System.out.println("Enter CD category: ");
                                String cdCategory = scanner.nextLine();
                                System.out.println("Enter CD artist: ");
                                String cdArtist = scanner.nextLine();
                                System.out.println("Enter CD cost: ");
                                Float cdCost = scanner.nextFloat();
                                scanner.nextLine();

                                CompactDisc newCD = new CompactDisc(cdTitle, cdCategory, cdArtist, cdCost);
                                System.out.println("Do you want to add tracks to your CD?\n (1) Yes (0) No:");
                                int addTrack = scanner.nextInt();
                                scanner.nextLine();
                                
                                if (addTrack == 1) {
                                    System.out.println("How many tracks in your CD?");
                                    int numTrack = scanner.nextInt();
                                    scanner.nextLine();
                                    for (int i = 0; i < numTrack; i++) {
                                        System.out.println("Your " + (i+1) + " track: ");
                                        System.out.println("Enter track title: ");
                                        String trackTitle = scanner.nextLine();
                                        System.out.println("Enter track length: ");
                                        int trackLength = scanner.nextInt();
                                        scanner.nextLine();

                                        Track newTrack = new Track(trackTitle, trackLength);
                                        newCD.addTrack(newTrack);
                                    }
                                    store.addMedia(newCD);
                                } 
                                else if (addTrack == 0) {
                                    store.addMedia(newCD);
                                }
                                break;
                            case "3":
                                clc();
                                System.out.println("Enter DVD title: ");
                                String dvdTitle = scanner.nextLine();
                                System.out.println("Enter DVD category: ");
                                String dvdCategory = scanner.nextLine();
                                System.out.println("Enter DVD director");
                                String dvdDirector = scanner.nextLine();
                                System.out.println("Enter DVD length(in seconds)");
                                int dvdLength = scanner.nextInt();
                                System.out.println("Enter DVD cost: ");
                                Float dvdCost = scanner.nextFloat();
                                scanner.nextLine();
                                
                                DigitalVideoDisc newDVD = new DigitalVideoDisc(dvdTitle, dvdCategory, dvdDirector, dvdLength, dvdCost);
                                store.addMedia(newDVD);
                                break;
                            default:
                                clc();
                                System.out.println("Invalid Input! Please choose a number: 0-1-2-3.");
                                break;
                        }
                    }
                    
                    
                    break;
                case "2":
                    clc();
                    while(true){
                        System.out.print("Enter the title of the media to remove from the store (press 0 to return): ");
                        String title = scanner.nextLine();
                        if(title.equals("0")){
                            break;
                        }
                        Media foundMedia = store.search(title);
                        if(foundMedia==null){
                            System.out.println(title+" is not in the store. Try another.");
                        }
                        else{
                            System.out.println(foundMedia.getTitle()+" has been removed from the store.");
                            store.removeMedia(foundMedia);
                            
                        }
                    }
                    break;
                default:
                    clc();
                    System.out.println("Invalid option! Please choose a number: 0-1-2.");
                    break;
            }
        }
    }
}
