package hust.soict.ict.aims.TestPassingParameter;
import hust.soict.ict.aims.media.DigitalVideoDisc;
public class TestPassingParameter {
    public static void main(String[] args){
        //TODO Auto-generated method stub
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle DVD title: "+ jungleDVD.getTitle());
        System.out.println("cinderella DVD title: "+cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.err.println("jungle DVD title: "+jungleDVD.getTitle());
    }

    public static void swap(Object o1, Object o2){
        Object temp = o1;
        o1=o2;
        o2=temp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title){
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}
