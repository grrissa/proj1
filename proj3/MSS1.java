package proj3;
/*************************************************************************************
Brief Summary: Program that uses a brute force method of finding the max sub array
sum of a sequence. Uses three loops.
Authors: Marissa Esteban and Alizea Hinz
Last Date Modified: 4/5/2022
*************************************************************************************/
import java.util.Scanner;

public class MSS1 {
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
    Will loop through the array and calculate the sum of subarrays and return the greatest sum
    */
        int maxSum = 0;
        for (int i = 0; i<num.length; i++) {
            for (int j = i; j<=(num.length); j++) {
                int sum = 0;
                for (int k = i; k<j;k++) {
                    sum += num[k];
                }
                if (sum>maxSum) maxSum = sum;
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
            try{
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
