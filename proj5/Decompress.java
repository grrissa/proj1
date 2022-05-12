package proj5;

/*************************************************************************************
Brief Summary: Program decompresses the compressed file using perfect hashing
Last Date Modified: 5/11/2022
*************************************************************************************/

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class Decompress {
    static char repeat_again = 'n';
    static String file_name = "";
    static String output_file = "";
    static String log_file = "";
    static int table_size;
    static int double_times;
    static ObjectInputStream input;
    static boolean go_through = false;
    static PrintWriter output;
    public static void main(String[] args) { //args will be the name of the file
        
        do {
            BufferedReader input = null;
            if ((!go_through) && (args != null) && (args.length > 0)) { //if the user inputs a file
                try {
                    input = new BufferedReader(new FileReader(args[0]));
                    file_name = args[0];
                    String[] file_name_altered = file_name.split(".zzz");
                    output_file = file_name_altered[0];
                }
                catch (FileNotFoundException e){
                    System.out.println("An invalid filename was entered when trying to run this program.");
                    args[0] = null; 
                }
            }
            if ((go_through) || (args[0] == null) || (args.length == 0)) { //if file name is not given or if the file is incorrect it goes here
                boolean valid_file = false;
                
                do {
                    try {
                        // asks user to input file to read
                        Scanner file_input = new Scanner(System.in);
                        System.out.println("\nPlease enter the file name that you would like to be decompressed: ");
                        file_name = file_input.nextLine();
                        input = new BufferedReader(new FileReader(file_name));
                        valid_file = true;
                        String[] file_name_altered = file_name.split(".zzz");
                        output_file = file_name_altered[0];
                    } 

                    // making sure file is valid before continuing
                    catch (FileNotFoundException e) {
                        System.out.println("Invalid Filename.");
                        valid_file = false;
                    }
                } while (valid_file == false);
            
            }

            //runs decompress algorithm and checks time
            long start_time = System.nanoTime();
            decompress();
            long time = System.nanoTime() - start_time;

            try { // creates log file
                PrintWriter output;
                
                log_file = output_file + ".log";
                output = new PrintWriter(new FileOutputStream(log_file));
                
                output.println("Decompression of " + file_name); 
                output.println("Decompression took " + (time/1000000000.0) + " seconds"); 
                output.println("The table was doubled " + double_times + " times");

                output.close();
                input.close();
        
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
            go_through = true;
            repeat_validation();
        } while((repeat_again!='n') && (repeat_again!='N'));

    }
    

    public static void decompress(){
        /*
        decompresses the file using perfect hashing
        */
        ArrayList<String> dic = new ArrayList<String>();
            
            try {
                
                input = new ObjectInputStream(new FileInputStream(file_name));
                int num_of_dic = 0;
                String p = "";
                int p_numform;
                output = new PrintWriter(new FileOutputStream(output_file));
    
                //initializes dictionary
                for (int i= 32; i<=126; i++) {
                    dic.add(num_of_dic, Character.toString((char)i));
                    num_of_dic++;
                }
                dic.add(num_of_dic, "\n");
                num_of_dic++;
                dic.add(num_of_dic, "\t");
                num_of_dic++;
                dic.add(num_of_dic, "\r");
                num_of_dic++;
        
                //reads first value and primes the loop by initializing q
                int hi = (Integer)input.readInt();
                String q = dic.get(hi); // reads the first value
                output.print(q);
                         
                //loops through the remaining binary file to decompess the file back into ascii
                while((Integer)(p_numform = input.readInt()) != null) {
                        
                    //if code is in dictionary already
                    if (p_numform < num_of_dic) {
                        p = dic.get(p_numform);
                        output.print(p);
                        dic.add(num_of_dic, q + p.charAt(0));
                        num_of_dic++;    
                    
                    //if code is not in dictionary
                    } else {
                        output.print(q +  q.charAt(0));
                        dic.add(num_of_dic, q +  q.charAt(0));
                        num_of_dic++;
                    }
                    q = p;
                }


        } // end try


        catch (IOException e){
            try { // closes file when the end of the input file is reached
                input.close();
                output.close();
            } catch (IOException e1) {
                System.out.println(e1.getMessage());
            }
            
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


