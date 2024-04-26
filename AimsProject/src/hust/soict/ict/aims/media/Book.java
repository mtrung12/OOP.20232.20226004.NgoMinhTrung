package hust.soict.ict.aims.media;
import java.util.List;
import java.util.ArrayList;

public class Book extends Media{
    private List<String> authors = new ArrayList<String>();
    
    public Book(String title, String category, float cost,List<String> authors) {
        super(title, category, cost);
        this.authors = authors;
    }
    public List<String> getAuthors() {
        return authors;
    }
    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String authorName){
        if(!authors.contains(authorName)){
            authors.add(authorName);
        }
        else System.out.println("Author "+authorName +" is already in the author list.");
    }

    public void removeAuthor(String authorName){
        if(authors.contains(authorName)){
            authors.remove(authorName);
        }
        else System.out.println("Author "+authorName+" is not in the author list.");
    }
    
}
