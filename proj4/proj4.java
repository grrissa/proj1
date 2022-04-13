package proj4;
import java.util.Scanner;
import java.io.*;

// ok two questions:
// 1. program_one() with the file loading? how does that work like whats the file format
// 2. should we make a new empty directory? or should the user input a directory that they want to edit
//    like should the main MAKE a new directory that they edit etc?

public class proj4 {

    static PhoneDirectory my_directory = new PhoneDirectory();
    static boolean stop = false;
    public static void main(String[] args) {
        
        while (!stop) {

            Scanner num_input = new Scanner(System.in);
            System.out.println("Please enter number to select an option");

            System.out.println("1. Load a previously saved phone directory from file");
            System.out.println("2. Add or change an entry");
            System.out.println("3. Remove an entry");
            System.out.println("4. Search for an entry");
            System.out.println("5. Display all entries");
            System.out.println("6. Save the current phone directory to a file");
            System.out.println("7. Quit the program");

            int num = num_input.nextInt();
            
            if (num == 1)
                program_one();
            else if (num == 2){
                program_two();
            }
            else if (num == 3){
                program_three();
            }
            else if (num == 4){
                program_four();
            }
            else if (num == 5){
                program_five();
            }
            else if (num == 6){
                program_six();
            }
            else if (num == 7){
                program_seven();
            }

        }

    }

    public static void program_one() {
 
        
        String inputLine;
        BufferedReader input;

        try {
            // asks user to input file to read
            Scanner file_input = new Scanner(System.in);
            System.out.println("Please enter the file name that you would like to be loaded: ");
            String file_name = file_input.nextLine();
            input = new BufferedReader(new FileReader(file_name));

            // loop that reads the infile line by line
            String[] entry = null;
            while ((inputLine = input.readLine()) != null) {
                entry = inputLine.split(":");
                my_directory.addOrChangeEntry(entry[0], entry[1]);
            }
            input.close();

        } // end try

        // catching exceptions
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1); 
        }
        catch (IOException e){
            System.out.println(e.getMessage());
            System.exit(1); //IO error, exit program
        } // end catch
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    public static void program_two() {
        Scanner name_entry = new Scanner(System.in);
        System.out.println("Please enter name of contact: ");
        String name = name_entry.nextLine();

        Scanner phone_entry = new Scanner(System.in);
        System.out.println("Please enter phone number of contact: ");
        String number = phone_entry.nextLine();

        String old_number = my_directory.addOrChangeEntry(name, number);

        if (old_number == null) {
            System.out.println("Successfully added new contact!");
        } else {
            System.out.println("Successfully changed contact!");
        }
    }

    public static void program_three() {
        Scanner name_entry = new Scanner(System.in);
        System.out.println("Please enter name to delete: ");
        String name = name_entry.nextLine();
        DirectoryEntry removed =  my_directory.removeEntry(name);
        if (removed == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println("Successfully removed contact!");
        }
    }

    public static void program_four() {
        Scanner name_entry = new Scanner(System.in);
        System.out.println("Please enter the name of an entry you would like to find: ");
        String name = name_entry.nextLine();
        DirectoryEntry found = my_directory.searchEntry(name);
        if (found == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println("Successfully found contact!");
    }}


    public static void program_five() {
        my_directory.displayAllEntries();
    }

    public static void program_six() {
        try {
            Scanner file_s = new Scanner(System.in);
            System.out.println("Please enter the file name that you would like to save the contents to: ");
            String output_file = file_s.nextLine(); 
            PrintWriter output = new PrintWriter(new FileOutputStream(output_file));

            output.println(my_directory);
            
            output.close();

        } // end try

        // catching exceptions
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1); 
        }
        catch (IOException e){
            System.out.println(e.getMessage());
            System.exit(1); //IO error, exit program
        } // end catch
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

    }

    
    public static void program_seven() {
        stop = true;
        System.exit(1);
    }
}
