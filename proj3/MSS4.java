package proj3;
/*************************************************************************************
Brief Summary: Program that will find the MSS by iterating through the sequence and simultaneously 
calculating the sum of each number.  Will update max sum accordingly and return the max subarray.
Authors: Marissa Esteban and Alizea Hinz
Last Date Modified: 
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
        int maxSum = 0, sum = 0;
        for(int i = 0; i<num.length; i++){
            sum += num[i];
            if (sum>maxSum){
                maxSum = sum;
            }
            else {
                if (sum<0) sum = 0;
            }
        }
        return maxSum;
    }
    public static int[] convert_array(String nums_str) {
        String[] nums_array = nums_str.split(",");
        int[] nums = new int[nums_array.length];

        for(int i = 0;i < nums_array.length;i++) {
            try
            {
                nums[i] = Integer.parseInt(nums_array[i]);
            }
            catch (NumberFormatException nfe)
            {
                System.out.println(nfe.getMessage());
                System.exit(1);
                //Do nothing or you could print error if you want
            }
        }
        return nums;
    }
}