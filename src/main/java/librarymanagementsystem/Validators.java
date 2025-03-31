package librarymanagementsystem;

import java.util.Scanner;

public class Validators {
    private Scanner scanner;
    
    public Validators(Scanner scanner) {
        this.scanner = scanner;
    }
    
    // Validates and parses an integer from the input. If invalid, prompts the user to try again
    public Integer validateInteger(String input, String context) {
        try {
            int value = Integer.parseInt(input);
            if (value <= 0) {
                System.out.println("Error: " + context + " must be greater than 0.");
                System.out.print("Enter " + context + " again: ");
                return validateInteger(scanner.nextLine(), context);
            }
            return value;
        } catch (NumberFormatException num) {
            System.out.println("Invalid " + context + ". Must be a number.");
            System.out.print("Enter " + context + " again: ");
            return validateInteger(scanner.nextLine(), context);
        }
    }

    // Validates and parses a float from the input. If invalid, prompts the user to try again
    public Float validateFloat(String input, String context) {
        try {
            float value = Float.parseFloat(input);
            if (value < 1) {
                System.out.println("Error: " + context + " must be 1 or more.");
                System.out.print("Enter " + context + " again: ");
                return validateFloat(scanner.nextLine(), context);
            }
            return value;
        } catch (NumberFormatException num) {
            System.out.println("Invalid " + context + ". Must be a number.");
            System.out.print("Enter " + context + " again: ");
            return validateFloat(scanner.nextLine(), context);
        }
    }

    // Validates if the string input is not empty. If empty, prompts the user to try again
    public String validateString(String input, String context) {
        if (input == null || input.trim().isEmpty()) {
            System.out.println("Error: " + context + " cannot be empty.");
            System.out.print("Enter " + context + " again: ");
            return validateString(scanner.nextLine(), context);
        }
        return input;
    }
    
    // Validates a boolean input (true/false)
    public Boolean validateBoolean(String input, String context) {
        input = input.toLowerCase().trim();
        if (input.equals("true") || input.equals("false")) {
            return Boolean.parseBoolean(input);
        } else {
            System.out.println("Invalid " + context + ". Must be true or false.");
            System.out.print("Enter " + context + " again: ");
            return validateBoolean(scanner.nextLine(), context);
        }
    }
    
    // Validates that a format is supported
    public String validateFormat(String input, String context) {
        input = validateString(input, context).toLowerCase();
        String[] supportedFormats = {"dvd", "cd", "mp3", "mp4", "","blu-ray"};
        
        for (String format : supportedFormats) {
            if (input.equals(format)) {
                return input;
            }
        }
        
        System.out.println("Error: Format not supported. Supported formats: " + String.join(", ", supportedFormats));
        System.out.print("Enter format again: ");
        return validateFormat(scanner.nextLine(), context);
    }
}
