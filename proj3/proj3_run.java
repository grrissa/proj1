package proj3;
/*************************************************************************************
Brief Summary: Program that will ask the user to input a file with a sequence of numbers, and then ask user to 
select between four algorithms to run on the file.  Will display the running time of the four algorithms for 
user to compare.
Authors: Marissa Esteban and Alizea Hinz
Last Date Modified: 4/5/2022
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
                String input_file = in.nextLine();
                //String input_file = "file3.out";
                input = new BufferedReader(new FileReader(input_file));
                
                // asks user which program they would like to run
                Scanner p = new Scanner(System.in);
                System.out.println("\nPlease enter the number for which Maximum Subsequence Sum program you would like to run:");
                System.out.println("1) MSS1\n2) MSS2\n3) MSS3\n4) MSS4\n5) All 4 programs in a sequence");
                int program = p.nextInt();

                while ((program<1) || (program>5) ) {
                    System.out.println("\nInvalid Response:\nPlease enter the number for which Maximum Subsequence Sum program you would like to run:");
                    System.out.println("1) MSS1\n2) MSS2\n3) MSS3\n4) MSS4\n5) All 4 programs in a sequence");
                    program = p.nextInt();
                }
                String[] str_nums = null;
                int length = 0;
                // loop that reads the infile line by line and prints it to the output file 
                if ((inputLine = input.readLine()) != null) { 
                    str_nums = inputLine.split(",");
                    length = str_nums.length;
                 }
                else {
                    System.out.println("File is empty");
                }
                int[] nums = new int[length]; 

                for(int i = 0;i < length;i++) {
                    try {
                        nums[i] = Integer.parseInt(str_nums[i]);
                    }
                    catch (NumberFormatException nfe) {
                        System.out.println(nfe.getMessage());
                        System.exit(1);
                    }
                }
                
                input.close();
                if (program == 5) {
                    System.out.println("Execution Time for MSS1 in seconds: " + run_program(1, nums));
                    System.out.println("Execution Time for MSS2 in seconds: " + run_program(2, nums));
                    System.out.println("Execution Time for MSS3 in seconds: " + run_program(3, nums));
                    System.out.println("Execution Time for MSS4 in seconds: " + run_program(4, nums));}
                else {
                    System.out.println("Execution Time for MSS"+program+" in seconds: " + run_program(program, nums));
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
    public static float run_program(int program, int[] nums){
        long start_time = 0;
        System.out.println(System.nanoTime());
        if (program == 1) {
            start_time = System.nanoTime();
            int max_sum = MSS1.sum(nums);}
        else if (program ==2) {
            start_time = System.nanoTime();
            int max_sum = MSS2.sum(nums);}
        else if (program ==3) {
            start_time = System.nanoTime();
            int max_sum = MSS3.sum(nums, 0, nums.length-1);}
        else if (program ==4) {
            start_time = System.nanoTime();
            int max_sum = MSS4.sum(nums);}        
        float end_time = System.nanoTime() - start_time;
        return (float) (end_time/1000000000.0);
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
