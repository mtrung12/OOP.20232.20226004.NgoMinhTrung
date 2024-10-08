package hust.soict.ict.aims.media;

import hust.soict.ict.aims.exception.PlayerException;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Track implements Playable{
    private String title;
    private int length;
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }

    @Override
    public void play() throws PlayerException {
        if(this.getLength()>0){
            System.out.println("Playing Track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        }
        else{
            throw new PlayerException("ERROR: Track cannot be played");
        }
    }   
    @Override
    public String toStringPlay(){
        String playString = new String();
        int length = this.getLength();
        int minute = length/60;
        int second = length%60;
        if(this.getLength()==0){
            playString = playString + "\nTrack cannot be played";
        }
        else playString = playString + "["+minute+":"+second +"]"+this.getTitle();
        return playString;
    }
    @Override
    public boolean equals(Object o){
        if(!(o instanceof Track)){
            return false;
        }
        return ((Track)o).getTitle()==this.title&&((Track)o).getLength()==this.length;
    }
}
