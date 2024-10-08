package hust.soict.ict.aims.media;
import hust.soict.ict.aims.exception.PlayerException;

import java.util.Comparator;

import javax.swing.JPanel;
public abstract class Media implements Comparable<Media>{
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    private int id;
    private String title;
    private String category;
    private float cost;
    private static int nbMedia=0;
    public Media(String title){
        this.title=title;
    }
    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbMedia++;
        id=nbMedia;
    }
    public int getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
    public String toString(){
        String text = String.format("%2d-%-25s-%-25s: %4.2f$", id, title, category, cost);
        return text;
    }
    public void play() throws PlayerException {
        System.out.println("Playing media");
    }
    public String toStringPlay(){
        String playString = "Playing Media";
        return playString;
    }
    @Override
    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        if(!(o instanceof Media)){
            return false;
        }
        Media other = null;
        try {
            other = (Media) o;
        } catch (ClassCastException e) {
            return false;
        }
        return (other.getTitle().equals(this.title)) && (other.getCost() == this.cost);
    }

    @Override
    public int compareTo(Media other) {
        if(other == null){
            throw new NullPointerException("The provided Media object is null");
        }
        int titleComparison = this.getTitle().compareTo(other.getTitle());
        if (titleComparison != 0) {
            return titleComparison;
        } else {
            return Double.compare(this.getCost(), other.getCost());
        }
    }
}
