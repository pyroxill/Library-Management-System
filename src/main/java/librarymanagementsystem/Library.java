package librarymanagementsystem;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Item> items = new ArrayList<>();

    // Method to add a new item to the library
    public void addItem(Item item) {
        items.add(item);
        System.out.println("Item added: " + item.getTitle());
    }

    // Method to delete an item 
    public boolean deleteItem(int id) {
        for (Item item : items) {
            if (item.getId() == id) {
                items.remove(item);
                return true;
            }
        }
        return false; 
    }

    // Method to edit an item
    public Item getItem(int id){
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null; 
    }

    //Method to display all items in the library
    public void showallItems() {
        for (Item item : items) {
            System.out.println(item);
        }
    }

    // Method to search for an item by title
    public List<Item> searchbyTitle(String title){
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if(item.getTitle().equalsIgnoreCase(title)){
                result.add(item);
            }
        }
        return result;
    }
    
    //Method to search for an item by type
    public List<Item> searchbyType(String type){
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if(item.getType().equalsIgnoreCase(type)){
                result.add(item);
            }
        }
        return result;
    }

    //Method to search for an item by ID
    public List<Item> searchbyID(int id){
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if(item.getId() == id){
                result.add(item);
            }
        }
        return result;
    }


    //Method to calculate the total cost of the library
    public float calculateTotalCost(){
        float totalCost = 0;
        for (Item item : items) {
            totalCost += item.getCost();
        }
        return totalCost;
    }

    //Method to calculate insurance cost
    public float calculateInsuranceCost(){
        float totalInsuranceCost = 0;
        for (Item item : items){
            float insurance = item.getCost() * 0.5f;
            if (insurance > 400) {
                return 400;
            }
        }
        return totalInsuranceCost;
    }

    //Method to get all the items in the library
    public List<Item> getAllItems(){
        return new ArrayList<>(items);
    }
}
