package proj4;
import java.util.Scanner;
import java.io.*;
/*************************************************************************************
Brief Summary: Program that prompts user to pick between 7 programs that either modify or access the
phone directory.  Will give the user an option to load a file into a new directory or save the directory
into a new file.
Last Date Modified: 4/20/2022
*************************************************************************************/

public class proj4 {

    static PhoneDirectory my_directory = new PhoneDirectory();
    static boolean stop = false;
    public static void main(String[] args) {
        
        while (!stop) {

            // will ask the user what program they would like to run
            Scanner num_input = new Scanner(System.in);
            System.out.println("\nPlease enter number to select an option: ");

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
    /*
    Will ask the user what file they would like to be loaded and the load that file into 
    the phone directory.
    */
   
        String inputLine;
        BufferedReader input;

        try {
            // asks user to input file to read
            Scanner file_input = new Scanner(System.in);
            System.out.println("\nPlease enter the file name that you would like to be loaded: ");
            String file_name = file_input.nextLine();
            input = new BufferedReader(new FileReader(file_name));

            // loop that reads the infile line by line
            while ( ((inputLine = input.readLine()) != null) ) {
                String[] entry = inputLine.split(":");
                my_directory.addOrChangeEntry(entry[0].trim(), entry[1].trim());
            }
            input.close();

        } // end try

        // catching exceptions
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
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
    /*
    Will allow the user to add or change a directory entry
    */

        Scanner name_entry = new Scanner(System.in);
        System.out.println("\nPlease enter name of contact: ");
        String name = name_entry.nextLine();

        Scanner phone_entry = new Scanner(System.in);
        System.out.println("Please enter phone number of contact: ");
        String number = phone_entry.nextLine();

        String old_number = my_directory.addOrChangeEntry(name, number);

        if (old_number == null) {
            System.out.println("\nSuccessfully added new contact!");
        } else {
            System.out.println("\nSuccessfully changed contact!");
        }
    }

    public static void program_three() {
    /*
    Will allow the user to remove a directory entry
    */

        Scanner name_entry = new Scanner(System.in);
        System.out.println("\nPlease enter name to delete: ");
        String name = name_entry.nextLine();
        DirectoryEntry removed =  my_directory.removeEntry(name);
        if (removed == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println("Successfully removed contact!");
        }
    }

    public static void program_four() {
    /*
    Will allow the user to search for an entry
    */

        Scanner name_entry = new Scanner(System.in);
        System.out.println("\nPlease enter the name of an entry you would like to find: ");
        String name = name_entry.nextLine();
        DirectoryEntry found = my_directory.searchEntry(name);
        if (found == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(found.name + ": " + found.number);
    }}


    public static void program_five() {
    /*
    Will display all the entries in the directory
    */
        my_directory.displayAllEntries();
    }

    public static void program_six() {
        try {
            Scanner file_s = new Scanner(System.in);
            System.out.println("\nPlease enter the file name that you would like to save the contents to: ");
            String output_file = file_s.nextLine(); 
            char overwrite = '1';
            
            if (output_file.exists()) {
                Scanner ow = new Scanner(System.in);
                System.out.println("\nWould you like to replace or append? \n1)replace\n2)append ");
                overwrite = ow.next().charAt(0); 
                PrintWriter output = new PrintWriter(new FileOutputStream(output_file));

                //ensures user inputs a valid character
                while ((overwrite!='1') && (overwrite !='2')) {
                    System.out.println("\nInvalid response: \nWould you like to replace or append? (1 for replace, 2 for append)?");
                    repeat_again = again.next().charAt(0);
                }
            }

            if (overwrite == '1'){ //replace
                output.println(my_directory);
            }
            else { //append
                output.println(my_directory,true);
            }
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
