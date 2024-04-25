package hust.soict.ict.aims.media;


public class DigitalVideoDisc extends Disc{
    private String director;
    private int length;

    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, director, length, cost);
    }


    //getter
    public String getDirector() {
        return director;
    }
    public int getLength() {
        return length;
    }
    
    public String toString(){
        String text = String.format("%2d.DVD-%-25s %-15s %-20s %2d: %3.2f$", super.getId(), super.getTitle(), super.getCategory(), director, length, super.getCost());
        return text;
    }
    public boolean isMatch(String title){
        String title1Upper = title.toUpperCase();
        String title2Upper = super.getTitle().toUpperCase();
        if(title2Upper.contains(title1Upper)) return true;
        return false;
    }

    
}
