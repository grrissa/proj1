package proj5;

import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

public class Compress {
    static char repeat_again = 'n';
    static String file_name = "";
    static File comp_file;
    static String output_file;
    static int table_size;
    static long time = 0;
    static int rehash_num;
    static int num_entries;
    //static HashMap<Integer,int[]> Map = new HashMap<Integer,int[]>();
    public static void main(String[] args) { //args will be the name of the file
        //base table size based off of file size... want to avoid rehashing
        
        do {
            BufferedReader input = null;
            if ((args != null) && (args.length > 0)) {
                try {
                    input = new BufferedReader(new FileReader(args[0]));
                    file_name = args[0];
                }
                catch (FileNotFoundException e){
                    System.out.println("An invalid filename was entered when trying to run this program.");
                    args[0] = ""; 
                }
            }
            if ((args == null) || (args.length == 0)) {
                boolean valid_file = false;
                
                do {
                    try {
                        // asks user to input file to read
                        Scanner file_input = new Scanner(System.in);
                        System.out.println("\nPlease enter the file name that you would like to be compressed: ");
                        file_name = file_input.nextLine();
                        input = new BufferedReader(new FileReader(file_name));
                        
                        valid_file = true;
                    } 

                    // making sure file is valid before continuing
                    catch (FileNotFoundException e) {
                        System.out.println("Invalid Filename.");
                        valid_file = false;
                    }
                } while (valid_file == false);
            
            }
            File og_file = new File(file_name);
            long og_size = og_file.length();
            //long og_size = determine_size(og_file);
            table_size = table_size(og_size);
            output_file= file_name + ".zzz";
            comp_file = new File(output_file);

            long start_time = System.nanoTime();
            compress(input);
            time = System.nanoTime() - start_time;

            long comp_size = comp_file.length();

            try {
                PrintWriter output;
                String output_file = file_name + ".zzz.log";
                
                output = new PrintWriter(new FileOutputStream(output_file));
                
                output.println("Compression of " + file_name); 
                if ((og_size < 1000) && (comp_size < 1000)){
                    output.println("Compressed from " + og_size + " bytes to " + comp_size +" bytes"); }
                else {
                    output.println("Compressed from " + og_size/1000.0 + " Kilobytes to " + comp_size/1000.0 +" Kilobytes"); }
                output.println("Compression took " + (time/1000000000.0) + " seconds"); 
                output.println("The dictionary contains " + num_entries + " total entries"); 
                output.println("The table was rehashed " + rehash_num + " times ADD NEW LINE CHARACTER AND /T and other one!!!!"); 

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
        if (file_size < 100) {
            table_size = 149;}
        else if (file_size < 200) {
            table_size = 331;}
        else if (file_size < 650) {
            table_size = 733;}
        else if (file_size < 850) {
            table_size = 953;}
        else if (file_size < 1250) {
            table_size = 1049;}
        else{
            table_size = 733;
        }
        return table_size;
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
        HashTableChain dic = new HashTableChain (table_size);

        // how do we initialize for all possible chars that may occur?

        try {

            // loop that reads the infile line by line
            String inputLine;
            int index_on = 0;
            int ahead = 0;
            int num_of_dic = 0;
            String to_add;
            String p = "";
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(output_file));

            //initializing all possible chars
            
            for(int i= 32; i<=126; i++) {
                char letter_char = (char)i;
                dic.put(Character.toString(letter_char), num_of_dic);
                num_of_dic++;
            }
            

            while ( ((inputLine = original.readLine()) != null) ) {
                
                for(int i=0; i<(inputLine.length()); i++){
                    String c = Character.toString(inputLine.charAt(i));
                    System.out.print(c);
                    if((i == inputLine.length()-1) && (dic.get(p+c) != null)){
                        //output.print(Integer.toBinaryString((int) dic.get(p+c))); //print value of p to file
                        output.writeInt((int) dic.get(p+c));
                    }
                    if(dic.get(p+c) == null){ //if p+c is not in the dictionary
                        //output.print(Integer.toBinaryString((int) dic.get(p)) + " "); //print value of p to file
                        output.writeInt((int) dic.get(p));
                        dic.put(p+c,num_of_dic); // insert p+c into dic
                        num_of_dic++;
                        p =""; 
                        if(i == inputLine.length()-1){
                            //output.print(Integer.toBinaryString((int) dic.get(c)));
                            output.writeInt((int) dic.get(c));
                        }
                    }
                    p += c;
                }
        }
            output.close();
            original.close();

        } // end try

        catch (IOException e){
            System.out.println(e.getMessage());
            System.exit(1); //IO error, exit program
        } // end catch
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        num_entries = dic.size();
        rehash_num = dic.number_rehash();
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
