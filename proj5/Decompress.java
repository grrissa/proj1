package proj5;

//HOW DO WE KNOW WHEN THE TABLE IS DOUBLED
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
    static PrintWriter output;
    //static HashMap<Integer,int[]> Map = new HashMap<Integer,int[]>();
    public static void main(String[] args) { //args will be the name of the file
        //base table size based off of file size... want to avoid rehashing
        
        do {
            BufferedReader input = null;
            if ((args != null) && (args.length > 0)) {
                try {
                    input = new BufferedReader(new FileReader(args[0]));
                    file_name = args[0];
                    String[] file_name_altered = file_name.split(".zzz");
                    output_file = file_name_altered[0];
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

            long start_time = System.nanoTime();
            decompress();
            long time = System.nanoTime() - start_time;

            try {
                PrintWriter output;
                
                log_file = output_file + ".log";
                output = new PrintWriter(new FileOutputStream(log_file));
                
                output.println("Decompression of " + file_name); 
                output.println("Decompression took " + (time/1000000000.0) + " seconds"); 
                output.println("The table was doubled " + double_times + " times FIGURE THIS OUT"); // WHATTTTT

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
            repeat_validation();
        } while((repeat_again!='n') && (repeat_again!='N'));

    }
    

    public static void decompress(){
        ArrayList<String> dic = new ArrayList<String>();
        /*
        try {
            //BufferedReader input = new BufferedReader(new FileReader(file_name));
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(file_name));
            String inputLine = input.readLine();
            int num_of_dic = 0;
            String p = "";
            int p_numform;
            PrintWriter output = new PrintWriter(new FileOutputStream(output_file));

            for (int i= 32; i<=126; i++) {
                dic.add(num_of_dic, Character.toString((char)i));
                num_of_dic++;
            }

            String[] binary_nums = inputLine.split(" ");
            String q = dic.get((Integer.parseInt(binary_nums[0],2))); // reads the first value
            output.print(q);
                     
            for (int index = 1; index < binary_nums.length; index++) {
                p_numform = Integer.parseInt(binary_nums[index],2); // changes to binary to decimal #s

                if (p_numform <= num_of_dic) {
                    p = dic.get(p_numform);
                    output.print(p);
                    System.out.print(p);
                    dic.add(num_of_dic, q + p.charAt(0));
                    num_of_dic++;
                    

                } else {
                    output.print(q +  q.charAt(0));
                    System.out.print(q +  q.charAt(0));
                    dic.add(num_of_dic, q +  q.charAt(0));
                    num_of_dic++;
                }
                q = p;
            }*/
            
            try {
                
                input = new ObjectInputStream(new FileInputStream(file_name));
                int num_of_dic = 0;
                String p = "";
                int p_numform;
                output = new PrintWriter(new FileOutputStream(output_file));
    
                for (int i= 32; i<=126; i++) {
                    dic.add(num_of_dic, Character.toString((char)i));
                    num_of_dic++;
                }
                dic.add(num_of_dic, "\r");
                num_of_dic++;
                dic.add(num_of_dic, "\n");
                num_of_dic++;
                dic.add(num_of_dic, "\t");
                num_of_dic++;
    
                int hi = (Integer)input.readInt();
                String q = dic.get(hi); // reads the first value
                output.print(q);
                         
                while((Integer)(p_numform = input.readInt()) != null) {
                        
                    if (p_numform < num_of_dic) {
                        p = dic.get(p_numform);
                        output.print(p);
                        System.out.print(p);
                        dic.add(num_of_dic, q + p.charAt(0));
                        num_of_dic++;    
    
                    } else {
                        output.print(q +  q.charAt(0));
                        System.out.print(q +  q.charAt(0));
                        dic.add(num_of_dic, q +  q.charAt(0));
                        num_of_dic++;
                    }
                    q = p;
                }


        } // end try


        catch (IOException e){
            //System.out.println(e.getMessage());
            try {
                input.close();
                output.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                //e1.printStackTrace();
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


