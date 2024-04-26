package hust.soict.ict.aims.media;

public class Disc extends Media{
    private int length;
    private String director;
    public Disc(String title){
        super(title);
    }
    public Disc(String title, String category, float cost){
        super(title, category, cost);
    }
    public Disc(String title, String category, String director, float cost) {
        super(title, category, cost);
        this.director = director;
    }
    public Disc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }
    public int getLength() {
        return length;
    }
    
    public String getDirector() {
        return director;
    }
    @Override
    public int compareTo(Media other) {
        if (other instanceof Disc) {
            Disc otherDVD = (Disc) other;
            int titleComparison = this.getTitle().compareTo(otherDVD.getTitle());
            if (titleComparison != 0) {
                // Compare by title
                return titleComparison;
            } else {
                // Compare by decreasing length
                int lengthComparison = Integer.compare(otherDVD.getLength(), this.getLength());
                if (lengthComparison != 0) {
                    return lengthComparison;
                } else {
                    // Compare by cost
                    return Double.compare(this.getCost(), otherDVD.getCost());
                }
            }
        } else {
            return super.compareTo(other);
        }
    }
    
}
