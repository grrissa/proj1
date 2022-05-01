package proj5;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;
public class Decompress {
    static char repeat_again = 'n';
    static String file_name = "";
    static File comp_file;
    static File og_file;
    static int table_size;
    //static HashMap<Integer,int[]> Map = new HashMap<Integer,int[]>();
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

            decompress();

            try {
                PrintWriter output;
                String output_file = file_name + ".zzz.log";
                
                output = new PrintWriter(new FileOutputStream(output_file));
                
                output.println("Decompression of " + file_name); 
                output.println("Compressed from " + ); 
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

    public static void decompress(){
        ArrayList<String> dict = new ArrayList<String>(table_size);
        try {
            BufferedReader input = new BufferedReader(new FileReader(file_name));
            String inputLine;
            String p;
            // loop that reads the infile line by line
            while ( ((inputLine = input.readLine()) != null) ) {
                //String<> values = inputLine.split();
                
                for() {
                    if(dict.indexOf(p)!= -1){
                        
                    }
                }
            }
            input.close();

        } // end try


        catch (IOException e){
            System.out.println(e.getMessage());
            System.exit(1); //IO error, exit program
        } // end catch
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
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


