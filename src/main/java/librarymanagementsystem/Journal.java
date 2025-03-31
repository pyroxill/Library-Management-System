package librarymanagementsystem;

public class Journal extends Item{
    private int issueNum;
    private int pageCount;
    private String publisher;
    private String subject;

    //Constructor to initialize the journal
    public Journal(String title, String location, float cost, boolean isAvailable, int issueNum, int pageCount, String publisher, String subject) {
        
        super(title, "Journal", location, cost, isAvailable);
        this.issueNum = issueNum;
        this.pageCount = pageCount;
        this.publisher = publisher;
        this.subject = subject;
    }

    //Getters for the journal details
    public int getIssueNum() {
        return issueNum;
    }
    public int getPageCount() {
        return pageCount;
    }
    public String getPublisher() {
        return publisher;
    }
    public String getSubject() {
        return subject;
    }

    //Setters for the journal details
    public void setIssueNum(int issueNum) {
        this.issueNum = issueNum;
    }
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    @Override
    public String toString() {
        return "Journal{" +
                "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", type='" + getType() + '\'' +
                ", location='" + getLocation() + '\'' +
                ", cost=" + getCost() +
                ", isAvailable=" + isAvailable() +
                ", issueNum=" + issueNum +
                ", pageCount=" + pageCount +
                ", publisher='" + publisher + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
