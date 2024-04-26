package hust.soict.ict.aims.media;
import java.util.Comparator;
public class MediaComparatorByCostTitle implements Comparator<Media>{
    @Override
    public int compare(Media m1, Media m2) {
        // Compare by cost
        int costComparison = Double.compare(m2.getCost(), m1.getCost());
        if (costComparison != 0) {
            return costComparison;
        }
        // Compare by title
        return m1.getTitle().compareTo(m2.getTitle());        
    }
}
