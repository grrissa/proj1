package proj5;

import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

public class Compress {
    static char repeat_again = 'n';
    static String file_name = "";
    static File comp_file;
    static File og_file;
    static HashMap<Integer,int[]> Map = new HashMap<Integer,int[]>();
    public static void main(String[] args) { //args will be the name of the file
        //base table size based off of file size... want to avoid rehashing
        
        do {
            BufferedReader input = null;
            if (args[0].length() > 0) {
                try {
                    input = new BufferedReader(new FileReader(args[0]));
                    file_name = args[0];
                    og_file = new File(args[0]);
                }
                catch (FileNotFoundException e){
                    System.out.println("An invalid filename was entered when trying to run this program.");
                    args[0] = ""; 
                }
            }
            if (args[0].length() == 0) {
                boolean valid_file = false;
                
                do {
                    try {
                        // asks user to input file to read
                        Scanner file_input = new Scanner(System.in);
                        System.out.println("\nPlease enter the file name that you would like to be compressed: ");
                        file_name = file_input.nextLine();
                        input = new BufferedReader(new FileReader(file_name));
                        og_file = new File(file_name);
                        valid_file = true;
                    } 

                    // making sure file is valid before continuing
                    catch (FileNotFoundException e) {
                        System.out.println("Invalid Filename.");
                    }
                } while (valid_file = false);
            
            }
            long og_size = determine_size(og_file);
            int table_size = table_size(og_size);

            compress(input);
            try {
                PrintWriter output;
                String output_file = file_name + ".zzz.log";
                
                output = new PrintWriter(new FileOutputStream(output_file));
                
                output.println("Compression of " + file_name); 
                output.println("Compressed from " + og_size + " Kilobytes to " + determine_size(comp_file)+" Kilobytes"); 
                output.println("Compression of " + file_name); 
                output.println("Compression of " + file_name); 

                output.close();
        
                } // end try

            // catching exceptions
            catch (IOException e){
                System.out.println(e.getMessage());
                System.exit(1); //IO error, exit program
            } // end catch
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
            repeat_validation();
        } while((repeat_again!='n') && (repeat_again!='N'));

    }
    public static int table_size(long file_size){
        // in this function calculate the size of the hash map and 

        return table_size;
    }
    public static long determine_size(File file) {
        long size = file.length(); // size in bytes
        size = size / 1000; // convert to kilobytes
        return size;
    }
    public static void compress(BufferedReader original) {
    /*
    compression algorithm:
        initialize the dictionary for all possible chars that may occur in the input file
        loop: 
            find the longest prefix p of the unencoded part of the input file that is in the dictionary
            output the code
            if there is next char c in the input file, then p+c is assigned the code and insert the pair into the dictionary
    */
        
        


    }

    public static void repeat_validation() {
        /*
        Asks user if they would like to run the program again or not
        */
        //asks the user whether they would like to run the program again
        Scanner again = new Scanner(System.in);
        System.out.println("\nDo you want to run the program again (y for yes and n for no)?");
        repeat_again = again.next().charAt(0);

        //ensures user inputs a valid character
        while ((repeat_again!='y') && (repeat_again!='n') && (repeat_again!='Y') && (repeat_again!='N') ) {
            System.out.println("\nInvalid response: \nDo you want to run the program again (y for yes and n for no)?");
            repeat_again = again.next().charAt(0);
        }
    
    }
}
