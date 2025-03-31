package librarymanagementsystem;

public class Book extends Item{
    private String author;
    private int pageCount; 
    private String publisher; 

    // Constructor to initialize the book
    public Book(String title, String location, float cost, boolean isAvailable, String author, int pageCount, String publisher) {
        
        super(title, "Book", location, cost, isAvailable);
        this.author = author; 
        this.pageCount = pageCount; 
        this.publisher = publisher;  
    }

    // Getters for the book details
    public String getAuthor() {
        return author; 
    }
    public int getPageCount() {
        return pageCount; 
    }
    public String getPublisher() {
        return publisher; 
    }

    // Setters for the book details
    public void setAuthor(String author) {
        this.author = author; 
    }
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount; 
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher; 
    }

    @Override
    public String toString() {
       return "Book{" +
                "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", type='" + getType() + '\'' +
                ", location='" + getLocation() + '\'' +
                ", cost=" + getCost() +
                ", isAvailable=" + isAvailable() +
                ", author='" + author + '\'' +
                ", pageCount=" + pageCount +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
