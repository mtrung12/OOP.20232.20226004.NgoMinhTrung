package hust.soict.ict.aims.media;
import java.util.List;
import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private List<Track> tracks= new ArrayList<Track>();

    public CompactDisc(String title, String category, String artist, float cost) {
        super(title, category, artist, cost);
    }

    public void addTrack(Track track){
        if(!tracks.contains(track)){
            tracks.add(track);
        }
        else System.out.print("The track " +track.getTitle()+" is already in the Disc.");
    }

    public void removeTrack(Track track){
        if(tracks.contains(track)){
            tracks.remove(track);
        }
        else System.out.print("The track " +track.getTitle()+" is not in the Disc.");
    }

    public int getLength(){
        int total=0;
        for(Track track: tracks){
            total+=track.getLength();
        }
        return total;
    }
    
    @Override
    public void play(){
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());
        for(Track track: tracks){
            track.play();
        }
    }

    @Override
    public String toString(){
        String text = String.format("%2d.%-4s-%-25s-%-25s-%-20s-%5ds: %4.2f$", super.getId(),"CD", super.getTitle(), super.getCategory(), super.getDirector(), this.getLength(), super.getCost());
        return text;
    }
}
