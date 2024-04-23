package hust.soict.ict.disc;
public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private static int nbDigitalVideoDisc = 0;
    private int id=0;
    //constructor
    public DigitalVideoDisc(String title) {
        this.title = title;
        id=nbDigitalVideoDisc;
        nbDigitalVideoDisc++;
    }
    
    
    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        id=nbDigitalVideoDisc;
        nbDigitalVideoDisc++;
    }
    

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        id=nbDigitalVideoDisc;
        nbDigitalVideoDisc++;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDisc++;
        id=nbDigitalVideoDisc;
    }


    //getter
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public String getDirector() {
        return director;
    }
    public int getLength() {
        return length;
    }
    public float getCost() {
        return cost;
    }
    public int getID(){
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String toString(){
        String text = String.format("%2d.DVD-%-25s %-15s %-20s %2d: %3.2f$", id, title, category, director, length, cost);
        //return ""+id+"."+title+" "+category+" "+director+" "+length+" "+cost+"$";
        return text;
    }
    public boolean isMatch(String title){
        if(this.title.equals(title)) return true;
        return false;
    }

    
}
