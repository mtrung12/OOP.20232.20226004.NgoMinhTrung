package hust.soict.ict.aims.media;


import hust.soict.ict.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable{
    private String director;
    private int length;

    //constructor
    public DigitalVideoDisc(String title){
        super(title);
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }


    //getter
    public String getDirector() {
        return director;
    }
    public int getLength() {
        return length;
    }
    
    @Override
    public String toString(){
        String text = String.format("%2d.%-4s-%-25s-%-25s-%-20s-%5ds: %4.2f$", super.getId(),"DVD", super.getTitle(), super.getCategory(), super.getDirector(), super.getLength(), super.getCost());
        return text;
    }
    public boolean isMatch(String title){
        String title1Upper = title.toUpperCase();
        String title2Upper = super.getTitle().toUpperCase();
        if(title2Upper.contains(title1Upper)) return true;
        return false;
    }

    @Override
    public void play() throws PlayerException{
        if(super.getLength()>0){
            System.out.println("Playing DVD: " + super.getTitle());
            System.out.println("DVD length: " + super.getLength());
        }
        else{
            throw new PlayerException("ERROR: DVD cannot be played");
        }

    }   

    @Override
    public String toStringPlay(){
        String playString = "Playing DVD: " + super.getTitle();
        if(super.getLength()==0){
            playString = playString + "\nDVD cannot be played";
        }
        else playString = playString + "\nDVD length: "+super.getLength()+"s";
        return playString;
    }
    
}
