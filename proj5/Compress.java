package proj5;

import java.util.Scanner;
import java.io.*;

public class Compress {
    static char repeat_again = 'n';
    public static void main(String[] args) { //args will be the name of the file
        //base table size based off of file size... want to avoid rehashing

        do {
            BufferedReader input = null;
            if (args[0].length() > 0) {
                try {
                    input = new BufferedReader(new FileReader(args[0]));
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
                        String file_name = file_input.nextLine();
                        input = new BufferedReader(new FileReader(file_name));
                        valid_file = true;
                    } 

                    // making sure file is valid before continuing
                    catch (FileNotFoundException e) {
                        System.out.println("Invalid Filename.");
                    }
                } while (valid_file = false);
            
            }
            compress(input);
            repeat_validation();
        } while((repeat_again!='n') && (repeat_again!='N'));

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
