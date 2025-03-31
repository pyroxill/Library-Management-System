package librarymanagementsystem;

public class AVItem extends Item {
    private int duration; 
    private String format; 

    // Constructor
    public AVItem(String title, String location, float cost, boolean isAvailable, int duration, String format) {
        
        super(title, "AVItem", location, cost, isAvailable);
        this.duration = duration;
        this.format = format;
    }

    //Getters for the AV item details
    public int getDuration() {
        return duration;
    }
    public String getFormat() {
        return format;
    }

    // Setters for the AV item details
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "AVItem [ID: " + getId() + ", Title: " + getTitle() +
               ", Duration: " + duration + " mins, Format: " + format +
               ", Location: " + getLocation() + ", Cost: £" + getCost() +
               ", Issued: " + isAvailable() + "]";
    }
}