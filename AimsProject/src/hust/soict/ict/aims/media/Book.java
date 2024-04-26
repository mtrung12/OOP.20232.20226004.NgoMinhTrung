package hust.soict.ict.aims.media;
import java.util.List;
import java.util.ArrayList;

public class Book extends Media{
    private List<String> authors = new ArrayList<String>();
    
    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }
    

    public void addAuthor(String authorName){
        if(!authors.contains(authorName)){
            authors.add(authorName);
        }
        else System.out.println("Author "+authorName +" is already in the author list of "+"\""+super.getTitle()+"\".");
    }

    public void removeAuthor(String authorName){
        if(authors.contains(authorName)){
            authors.remove(authorName);
        }
        else System.out.println("Author "+authorName+" is not in the author list"+"\""+super.getTitle()+"\".");
    }

    @Override
    public String toString(){
        String authorsString = String.join(", ", authors);
        String text = String.format("%2d.%-4s-%-25s-%-25s-%-27s: %-4.2f$", super.getId(),"Book", super.getTitle(), super.getCategory(), authorsString, super.getCost());
        return text;
    }
}
