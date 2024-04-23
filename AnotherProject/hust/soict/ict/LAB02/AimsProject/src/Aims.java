public class Aims{
    public static void main(String[] args){
    //create a new order
    Cart order = new Cart();

    //Create new dvd objects and add them to the cart
    DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
    DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
    DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
    DigitalVideoDisc[] discList = new DigitalVideoDisc[]{dvd1, dvd2, dvd3};
    order.addDigitalVideoDisc(discList);
    order.addDigitalVideoDisc(dvd1);
    order.addDigitalVideoDisc(dvd1, dvd2);
    order.addDigitalVideoDisc(dvd2);
    order.addDigitalVideoDisc(dvd3);
    order.addDigitalVideoDisc(dvd3);
    order.removeDigitalVideoDisc(dvd3);
    System.out.println("\nHere is your bill:");
    order.dispCart();
    System.out.printf("%-24s\n", "----------------------------");
    System.out.printf("%-22s%.2f", "    Total",order.totalCost());
    

}
}
