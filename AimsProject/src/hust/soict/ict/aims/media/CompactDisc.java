package hust.soict.ict.aims.media;
import hust.soict.ict.aims.exception.PlayerException;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
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
    public void play() throws PlayerException{
        if(this.getLength() > 0) {
            java.util.Iterator iter = tracks.iterator();
            Track nextTrack;
            while(iter.hasNext()) {
                nextTrack = (Track) iter.next();
                try {
                    nextTrack.play();
                }catch(PlayerException e) {
                    throw e;
                }
            }
        }else {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }

    @Override
    public String toStringPlay() {
        String playString = "Playing CD: " + super.getTitle();
        String temp;
        if(this.getLength()==0){
            playString = playString + "\nCD cannot be played";
        }
        else {
            playString = playString + "\nCD length: "+this.getLength()+"s\n\n"+"Tracks:";
            for(Track track: tracks){
                playString = playString + "\n> "+track.toStringPlay();
            }
        }
        return playString;
    }

    @Override
    public String toString(){
        String text = String.format("%2d.%-4s-%-25s-%-25s-%-20s-%5ds: %4.2f$", super.getId(),"CD", super.getTitle(), super.getCategory(), super.getDirector(), this.getLength(), super.getCost());
        return text;
    }

    public List<Track> getTracks() {
        return tracks;
    }

}
