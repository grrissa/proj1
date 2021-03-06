package proj2;
/*************************************************************************************
Brief Summary: Programthat reads an ASCII file that contains a set of numbers of type int 
and outputs all the numbers to another file, but without any duplicated numbers
Authors: Marissa Esteban and Alizea Hinz
Last Date Modified: 2/27/2022
*************************************************************************************/

import java.util.Scanner;
import java.io.*; 

public class proj2_2 {
    static char repeat_again = 'n';
    public static void main (String[] args){
        
        do {
            BufferedReader input;
            String inputLine;

            try {
                // asks user to input file to read
                Scanner in = new Scanner(System.in);
                System.out.println("\nPlease enter the name of an ASCII file that contains a sorted list of integer numbers, one per line:");
                String input_file = in.nextLine();
                input = new BufferedReader(new FileReader(input_file));

                // creates a new file for the program to output
                Scanner out = new Scanner(System.in);
                System.out.println("\nPlease enter the name of the output file that saves the result from the program:");
                String output_file = out.nextLine();
                PrintWriter output = new PrintWriter(new FileOutputStream(output_file));

                // loop that reads the infile line by line and prints it to the output file 
                double sum = 0.0;
                int count = 0;
                int past_val = 0;
                while ((inputLine = input.readLine()) != null) {
                    int num = Integer.parseInt(inputLine);

                    //first time through the loop, initialize past_val
                    if (count == 0) { 
                        past_val = num;
                        output.println(num);
                        sum += num;
                        count +=1;
                    }
                    // only print if the next number is bigger, and update past_val
                    else if (past_val < num) { 
                        output.println(num);
                        past_val = num;
                        sum += num;
                        count +=1;
                    }
                }
                if (count != 0) {
                    double average = sum/count;
                    String rounded_average = String.format("%.2f", average);
                    output.println(rounded_average);
                }
                input.close();
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

            repeat_validation();
        
        } while ((repeat_again!='n') && (repeat_again!='N'));
    }

    public static void repeat_validation() {
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