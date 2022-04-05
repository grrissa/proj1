package proj3;
/*************************************************************************************
Brief Summary: Program that will find the MSS by iterating through the sequence and simultaneously 
calculating the sum of each number.  Will update max sum accordingly and return the max subarray.
Authors: Marissa Esteban and Alizea Hinz
Last Date Modified: 4/5/2022
*************************************************************************************/
import java.util.Scanner;

public class MSS4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter numbers separated by commas: ");
        String num = input.nextLine();
        int[] nums_ints = convert_array(num);
        int result = sum(nums_ints);
        System.out.println("Maximum Sum = " + result);
    }
    public static int sum(int[] num){
    /* 
        Method that loops through an array of ints and will calculate the maximum sum possible
    */
        int maxSum = 0, sum = 0;
        System.out.println(num.length);
        for(int i = 0; i<num.length; i++){
            sum += num[i];
            if (sum>maxSum){
                maxSum = sum;
            }
            else { // disregards the sum if it is less than 0, and resets it
                if (sum<0) sum = 0;
            }
        }
        return maxSum;
    }
    public static int[] convert_array(String nums_str) {
    /* 
        Method that converts a String of numbers separated by commas into an int array
    */
        String[] nums_array = nums_str.split(",");
        int[] nums = new int[nums_array.length];

        for(int i = 0;i < nums_array.length;i++) {
            try {
                nums[i] = Integer.parseInt(nums_array[i]);
            }
            catch (NumberFormatException nfe){
                System.out.println(nfe.getMessage());
                System.exit(1);
            }
        }
        return nums;
    }
}