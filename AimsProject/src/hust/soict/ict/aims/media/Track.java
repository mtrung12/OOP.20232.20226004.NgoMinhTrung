package hust.soict.ict.aims.media;

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
    
    public void play(){
        System.out.println("Playing Track: " + this.getTitle());
        if(this.getLength()==0){
            System.out.println("Track cannot be played.");
        }
        else System.out.println("Track length: " + this.getLength());
    }   
    
    @Override
    public boolean equals(Object o){
        if(!(o instanceof Track)){
            return false;
        }
        return ((Track)o).getTitle()==this.title&&((Track)o).getLength()==this.length;
    }
}
