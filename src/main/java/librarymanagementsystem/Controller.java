package librarymanagementsystem;

import java.util.*;

public class Controller {
    private Library library = new Library();
    private Scanner sc = new Scanner(System.in);
    private Validators validator = new Validators(sc);

    public void start() { 
        boolean running = true;

        while (running) {
            menu();
            
            System.out.print("Enter your choice: ");
            int choice = validator.validateInteger(sc.nextLine(), "choice");

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    deleteItem();
                    break;
                case 3:
                    editItem();
                    break;
                case 4:
                    searchByTitle();
                    break;
                case 5:
                    searchByType();
                    break;
                case 6:
                    searchByID();
                    break;
                case 7:
                    calculateTotalCost();
                    break;
                case 8:
                    calculateInsuranceCost();
                    break;
                case 9:
                    running = false;
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Display the menu options to the user
    private void menu() {
        System.out.println("\nLibrary Management System");
        System.out.println("1. Add Item");
        System.out.println("2. Delete Item");
        System.out.println("3. Edit Item");
        System.out.println("4. Search Item by Title");
        System.out.println("5. Search Item by Type");
        System.out.println("6. Search Item by ID");
        System.out.println("7. Calculate Total Cost");
        System.out.println("8. Calculate insurance cost");
        System.out.println("9. Exit");
    }

    // Method to show all items in the library
    private void showAllItems() {
        library.showallItems();
    }

    // This method allows the user to add a new item to the library.
    private void addItem() {
        clearScreen();
        System.out.print("What type of item do you want to add? \n1.Book \n2.Journal \n3. Audio/Video: ");
        String typeChoice = sc.nextLine();

        if (typeChoice.equals("1")) {
            clearScreen();
            System.out.println("Enter details for the new book: ");

            System.out.print("Title: ");
            String title = validator.validateString(sc.nextLine(), "title");

            System.out.print("Location: ");
            String location = validator.validateString(sc.nextLine(), "location");

            System.out.print("Cost: ");
            float cost = validator.validateFloat(sc.nextLine(), "cost");

            System.out.print("Is it available? true/false: ");
            boolean isAvailable = validator.validateBoolean(sc.nextLine(), "availability");

            System.out.print("Author: ");
            String author = validator.validateString(sc.nextLine(), "author");

            System.out.print("Publisher: ");
            String publisher = validator.validateString(sc.nextLine(), "publisher");

            System.out.print("Page Count: ");
            int pageCount = validator.validateInteger(sc.nextLine(), "page count");

            library.addItem(new Book(title, location, cost, isAvailable, author, pageCount, publisher));
            System.out.println("Book added successfully.");

        } else if (typeChoice.equals("2")) {
            clearScreen();
            System.out.println("Enter details for the new Journal: ");

            System.out.print("Title: ");
            String title = validator.validateString(sc.nextLine(), "title");

            System.out.print("Location: ");
            String location = validator.validateString(sc.nextLine(), "location");

            System.out.print("Cost: ");
            float cost = validator.validateFloat(sc.nextLine(), "cost");

            System.out.print("Is it available? true/false: ");
            boolean isAvailable = validator.validateBoolean(sc.nextLine(), "availability");

            System.out.print("Publisher: ");
            String publisher = validator.validateString(sc.nextLine(), "publisher");

            System.out.print("Issue Number: ");
            int issueNum = validator.validateInteger(sc.nextLine(), "issue number");

            System.out.print("Subject: ");
            String subject = validator.validateString(sc.nextLine(), "subject");

            System.out.print("Page Count: ");
            int pageCount = validator.validateInteger(sc.nextLine(), "page count");

            library.addItem(new Journal(title, location, cost, isAvailable, issueNum, pageCount, publisher, subject));
            System.out.println("Journal added successfully.");

        } else if (typeChoice.equals("3")) {
            clearScreen();
            System.out.println("Enter details for the new Audio/Video: ");

            System.out.print("Title: ");
            String title = validator.validateString(sc.nextLine(), "title");

            System.out.print("Location: ");
            String location = validator.validateString(sc.nextLine(), "location");

            System.out.print("Cost: ");
            float cost = validator.validateFloat(sc.nextLine(), "cost");

            System.out.print("Is it available? true/false: ");
            boolean isAvailable = validator.validateBoolean(sc.nextLine(), "availability");

            System.out.print("Duration (in minutes): ");
            int duration = validator.validateInteger(sc.nextLine(), "duration");

            System.out.print("Format: ");
            String format = validator.validateString(sc.nextLine(), "format");

            library.addItem(new AVItem(title, location, cost, isAvailable, duration, format));
            System.out.println("Audio/Video item added successfully.");

        } else {
            System.out.println("Invalid choice. Please try again.");
        }
    }

    // This method allows the user to delete an item from the library.
    private void deleteItem() {
        clearScreen();
        showAllItems();
        System.out.print("Enter the ID of the item to delete: ");
        sc.nextLine(); // Consume newline if needed
        int id = validator.validateInteger(sc.nextLine(), "ID");

        if (library.deleteItem(id)) {
            System.out.println("Item deleted successfully.");
        } else {
            System.out.println("Item not found.");
        }
    }

    // This method allows the user to edit an existing item in the library.
    private void editItem() {
        clearScreen();
        showAllItems();

        System.out.print("Enter the item ID you want to edit: ");
        sc.nextLine();
        int id = validator.validateInteger(sc.nextLine(), "ID");

        Item item = library.getItem(id);

        if (item == null) {
            System.out.println("Item not found.");
            return;
        }

        System.out.println("Editing item: " + item);
        editCommonFields(item);

        if (item instanceof Book) {
            editBookFields((Book) item);
        } else if (item instanceof Journal) {
            editJournalFields((Journal) item);
        } else if (item instanceof AVItem) {
            editAVFields((AVItem) item);
        }

        System.out.println("Item edited successfully!");
    }

    // This method allows the user to edit common fields of an item
    private void editCommonFields(Item item) {
        clearScreen();
        System.out.println("Editing Item Details!");

        System.out.println("Current Title: " + item.getTitle());
        System.out.print("Enter new title or press enter to keep current: ");
        String input = sc.nextLine();
        if (!input.isEmpty()) {
            item.setTitle(validator.validateString(input, "title"));
        }

        System.out.println("Current Location: " + item.getLocation());
        System.out.print("Enter new location or press enter to keep current: ");
        input = sc.nextLine();
        if (!input.isEmpty()) {
            item.setLocation(validator.validateString(input, "location"));
        }

        System.out.println("Current Cost: " + item.getCost());
        System.out.print("Enter new cost or press enter to keep current: ");
        input = sc.nextLine();
        if (!input.isEmpty()) {
            item.setCost(validator.validateFloat(input, "cost"));
        }

        System.out.println("Current Availability: " + item.isAvailable());
        System.out.print("Enter new availability (true/false) or press enter to keep current: ");
        input = sc.nextLine();
        if (!input.isEmpty()) {
            item.setAvailable(validator.validateBoolean(input, "availability"));
        }
    }

    // This method allows the user to edit the fields of a Book item
    private void editBookFields(Book book) {
        System.out.println("\nEditing Book Details!");

        System.out.println("Current Author: " + book.getAuthor());
        System.out.print("Enter new author or press enter to keep current: ");
        String input = sc.nextLine();
        if (!input.isEmpty()) {
            book.setAuthor(validator.validateString(input, "author"));
        }

        System.out.println("Current Publisher: " + book.getPublisher());
        System.out.print("Enter new publisher or press enter to keep current: ");
        input = sc.nextLine();
        if (!input.isEmpty()) {
            book.setPublisher(validator.validateString(input, "publisher"));
        }

        System.out.println("Current Page Count: " + book.getPageCount());
        System.out.print("Enter new page count or press enter to keep current: ");
        input = sc.nextLine();
        if (!input.isEmpty()) {
            book.setPageCount(validator.validateInteger(input, "page count"));
        }
    }

    // This method allows the user to edit the fields of a Journal item
    private void editJournalFields(Journal journal) {
        System.out.println("\nEditing Journal Details!");

        System.out.println("Current Publisher: " + journal.getPublisher());
        System.out.print("Enter new publisher or press enter to keep current: ");
        String input = sc.nextLine();
        if (!input.isEmpty()) {
            journal.setPublisher(validator.validateString(input, "publisher"));
        }

        System.out.println("Current Issue Number: " + journal.getIssueNum());
        System.out.print("Enter new issue number or press enter to keep current: ");
        input = sc.nextLine();
        if (!input.isEmpty()) {
            journal.setIssueNum(validator.validateInteger(input, "issue number"));
        }

        System.out.println("Current Subject: " + journal.getSubject());
        System.out.print("Enter new subject or press enter to keep current: ");
        input = sc.nextLine();
        if (!input.isEmpty()) {
            journal.setSubject(validator.validateString(input, "subject"));
        }

        System.out.println("Current Page Count: " + journal.getPageCount());
        System.out.print("Enter new page count or press enter to keep current: ");
        input = sc.nextLine();
        if (!input.isEmpty()) {
            journal.setPageCount(validator.validateInteger(input, "page count"));
        }
    }

    // This method allows the user to edit the fields of an Audio/Video item
    private void editAVFields(AVItem item) {
        System.out.println("\nEditing Audio/Video Details!");

        System.out.println("Current Duration: " + item.getDuration());
        System.out.print("Enter new duration or press enter to keep current: ");
        String input = sc.nextLine();
        if (!input.isEmpty()) {
            item.setDuration(validator.validateInteger(input, "duration"));
        }

        System.out.println("Current Format: " + item.getFormat());
        System.out.print("Enter new format or press enter to keep current: ");
        input = sc.nextLine();
        if (!input.isEmpty()) {
            item.setFormat(validator.validateString(input, "format"));
        }
    }

    // This method allows the user to search for an item by its title
    private void searchByTitle() {
        clearScreen();
        System.out.print("Enter the title of the item to search: ");
        String title = sc.nextLine();
        List<Item> items = library.searchbyTitle(title);

        if (items.isEmpty()) {
            System.out.println("No items found with that title.");
        } else {
            System.out.println("Found items:");
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }

    // This method allows the user to search for an item by its type
    private void searchByType() {
        clearScreen();
        System.out.print("Enter the type of the item to search (Book, Journal, AVItem): ");
        String type = sc.nextLine();
        List<Item> items = library.searchbyType(type);

        if (items.isEmpty()) {
            System.out.println("No items found with that type.");
        } else {
            System.out.println("Found items:");
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }

    // This method allows the user to search for an item by its ID
    private void searchByID() {
        clearScreen();
        System.out.print("Enter the ID of the item to search: ");
        try {
            int id = Integer.parseInt(sc.nextLine());
            List<Item> items = library.searchbyID(id);

            if (items.isEmpty()) {
                System.out.println("No items found.");
            } else {
                System.out.println("Found items:");
                for (Item item : items) {
                    System.out.println(item);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Enter a valid number.");
        }
    }

    // This method calculates the total cost of all items in the library
    private void calculateTotalCost() {
        clearScreen();
        float totalCost = library.calculateTotalCost();
        System.out.println("Total cost of all items in the library: £" + String.format("%.2f", totalCost));
    }

    // This method calculates the insurance cost for an item
    private void calculateInsuranceCost() {
        clearScreen();
        System.out.print("Enter the title of the item to calculate insurance for: ");
        String itemTitle = sc.nextLine();

        List<Item> items = library.searchbyTitle(itemTitle);
        if (items.isEmpty()) {
            System.out.println("No items found with that title.");
        } else {
            for (Item item : items) {
                float insuranceCost = item.getCost() * 0.5f;
                if (insuranceCost > 400) {
                    insuranceCost = 400;
                }
                System.out.println(
                        "Insurance cost for " + item.getTitle() + ": £" + String.format("%.2f", insuranceCost));
            }
        }
    }

    // This method clears the console
    private void clearScreen() {
        System.out.print("\033[H\033[2J");
    }
}