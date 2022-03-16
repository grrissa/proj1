package proj2;
/*************************************************************************************
Brief Summary: 
Authors: Marissa Esteban and Alizea Hinz
Last Date Modified: 
*************************************************************************************/

//ASK ABOUT AVERAGE AND WHETHER IT IS ALL NUMBER IN THE FILE OR JUST THE ONES WE ARE PRINTING

import java.util.Scanner;
import java.io.*; 

public class proj2 {
    static char repeat_again = 'n';
    public static void main (String[] args){
        
        do {
            BufferedReader input;
            String inputLine;

            try {
                Scanner in = new Scanner(System.in);
                System.out.println("\nPlease enter the name of an ASCII file that contains a sorted list of integer numbers, one per line:");
                String input_file = in.nextLine();
                input = new BufferedReader(new FileReader(input_file));

                Scanner out = new Scanner(System.in);
                System.out.println("\nPlease enter the name of the output file that saves the result from the program:");
                String output_file = out.nextLine();
                PrintWriter output = new PrintWriter(new FileOutputStream(output_file));

                int sum = 0;
                int count = 0;
                int past_val = 0;
                while ((inputLine = input.readLine()) != null) {
                    int num = Integer.parseInt(inputLine);
                    sum += num;
                    count +=1;
                    if (count == 1) { //first time through the loop, initialize past_val
                        past_val = num;
                        output.println(num);
                    }
                    else if (past_val < num) { // only print if the next number is bigger, and update past_val
                        output.println(num);
                        past_val = num;
                    }
                }
                if (count != 0) {
                    double average = sum/count;
                    output.println(average);
                }
                input.close();
                output.close();

            } // end try
            catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
                System.exit(1); 
            }
            catch (IOException e){
                System.out.println(e.getMessage());
                System.exit(1); //IO error, exit program
            } // end catch

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
