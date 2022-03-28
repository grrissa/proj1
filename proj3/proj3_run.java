package proj3;
/*************************************************************************************
Brief Summary: 
Authors: Marissa Esteban and Alizea Hinz
Last Date Modified: 
*************************************************************************************/

import java.util.Scanner;
import java.io.*; 

public class proj3_run {
    static char repeat_again = 'n';
    public static void main (String[] args){
        
        do {
            BufferedReader input;
            String inputLine;

            try {
                // asks user to input file to read
                Scanner in = new Scanner(System.in);
                System.out.println("\nPlease enter the name of a file that contains a list of integer numbers, separated by commas on one line:");
                //String input_file = in.nextLine();
                String input_file = "file3.out";
                input = new BufferedReader(new FileReader(input_file));
                
                // creates a new file for the program to output
                Scanner p = new Scanner(System.in);
                System.out.println("\nPlease enter the number for which Maximum Subsequence Sum program you would like to run:");
                System.out.println("\n1) MSS1\n2) MSS2\n3) MSS3\n4) MSS4\n5) All 4 programs in a sequence");
                int program = p.nextInt();

                while ((program<1) || (program>5) ) {
                    System.out.println("\nInvalid Response:\nPlease enter the number for which Maximum Subsequence Sum program you would like to run:");
                    System.out.println("\n1) MSS1\n2) MSS2\n3) MSS3\n4) MSS4\n5) All 4 programs in a sequence");
                    program = p.nextInt();
                }
                String[] str_nums;
                // loop that reads the infile line by line and prints it to the output file 
                if ((inputLine = input.readLine()) != null) inputLine = input.readLine(); {
                    str_nums = inputLine.split(",");}

                else {
                    System.out.println("File is empty");
                }
                int[] nums = new int[str_nums.length];

                for(int i = 0;i < str_nums.length;i++) {
                    try {
                        nums[i] = Integer.parseInt(str_nums[i]);
                    }
                    catch (NumberFormatException nfe) {
                        System.out.println(nfe.getMessage());
                        System.exit(1);
                        //Do nothing or you could print error if you want
                    }
                }
                
                input.close();
                switch (program){
                    case 1:
                        System.out.println("Execution Time for MSS1: " + run_program(MSS1.sum(nums)));
                    case 2:
                        System.out.println("Execution Time for MSS2: " + run_program(MSS2.sum(nums)));
                    case 3:
                        System.out.println("Execution Time for MSS3: " + run_program(MSS3.sum(nums)));
                    case 4:
                        System.out.println("Execution Time for MSS4: " + run_program(MSS4.sum(nums)));
                    case 5:
                        System.out.println("Execution Time for MSS1: " + run_program(MSS1.sum(nums)));
                        System.out.println("Execution Time for MSS2: " + run_program(MSS2.sum(nums)));
                        System.out.println("Execution Time for MSS3: " + run_program(MSS3.sum(nums)));
                        System.out.println("Execution Time for MSS4: " + run_program(MSS4.sum(nums)));
                }

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
    public static long run_program(int program){
        int max_sum = 0;
        long start_time = 0;
        long end_time = 0;
        start_time = System.currentTimeMillis();
        max_sum = program;
        end_time = System.currentTimeMillis() - start_time;
        return end_time;
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
