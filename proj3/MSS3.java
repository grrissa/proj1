package proj3;
/*************************************************************************************
Brief Summary: Program that will recursively find the MSS of the sequence by findinging the max left subarray, 
max right subarray, and then the max mid subarray and then comparing the three.
Authors: Marissa Esteban and Alizea Hinz
Last Date Modified: 4/5/2022
*************************************************************************************/
import java.util.Scanner;

public class MSS3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter numbers separated by commas: ");
        String num = input.nextLine();
        int[] nums_ints = convert_array(num);
        int result = sum(nums_ints, 0, nums_ints.length-1);
        System.out.println("Maximum Sum = " + result);
    }
    
    public static int sum(int[] nums, int low, int high){
    /* 
        Method that recursively calls sum in order to calculate the maximum subsequence sum
    */
        if (high == low) //Base Case
            return nums[high];

        else{ //Recursive case
            int mid = (high + low)/ 2;

            return Math.max(Math.max(sum(nums, low, mid), sum(nums, mid+1, high)), mid_sum(nums, low, mid, high));
        }
    }

    public static int mid_sum(int[] num, int low, int mid, int high) {
    /* 
        Method that caluclates both the max left and right sums and returns the largets value
    */
        int maxSumLeft = 0, sum = 0;
        for(int i = mid; i>=low; i--){
            sum += num[i];
            if (sum>maxSumLeft)
                maxSumLeft= sum;
        }

        int maxSumRight = 0;
        sum = 0; // resets sum to reuse
        for(int i = mid+1; i<=high; i++){
            sum += num[i];
            if (sum>maxSumRight)
                maxSumRight = sum;
        }
        return Math.max(Math.max(maxSumLeft + maxSumRight,maxSumLeft),maxSumRight);
    }

    public static int[] convert_array(String nums_str) {
    /* 
        Method that converts a String of numbers separated by commas into an int array
    */
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

