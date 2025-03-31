package librarymanagementsystem;

// This is the Item class that represents an item in the library management system.
public abstract class Item {
    private static int nextId = 1; // Static variable to keep track of the next ID
    
    //Variables to store item details
    private int id; 
    private String title; 
    private String type; 
    private String location; 
    private float cost; 
    private boolean isAvailable; 
    
    // Constructor to initialize the item with the given parameters
    public Item(String title, String type, String location, float cost, boolean isAvailable) {
        this.id = nextId++; 
        this.title = title; 
        this.type = type; 
        this.location = location; 
        this.cost = cost;
        this.isAvailable = isAvailable; 
    }

    // Getters for the item details
    public int getId() {
        return id; 
    }
    public String getTitle() {
        return title; 
    }
    public String getType() {
        return type; 
    }
    public String getLocation() {
        return location; 
    }
    public float getCost() {
        return cost; 
    }
    public boolean isAvailable() {
        return isAvailable; 
    }

    // Setters for the item details
    public void setTitle(String title) {
        this.title = title; 
    }
    public void setType(String type) {
        this.type = type; 
    }
    public void setLocation(String location) {
        this.location = location; 
    }
    public void setCost(float cost) {
        this.cost = cost; 
    }
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable; 
    }

    public abstract String toString(); 
}
