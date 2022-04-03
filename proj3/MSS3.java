package proj3;
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
    public static int sum(int[] num, int low, int high){
        if (high <= low)
            return num[high];
        
        int mid = (high - low)/ 2;
        int left_side_max = sum(num, low, mid);
        int right_side_max = sum(num, mid+1, high);
        int mid_sum_max = mid_sum(num, low, mid, high);
        
        return max(left_side_max, right_side_max, mid_sum_max);
    }
    public static int max(int left, int right, int mid) {
        if (left >= right && left >= mid)
            return left;
        else if (right >= left && right >= mid)
            return right;
        else
            return mid;
    }
    public static int mid_sum(int[] num, int low, int mid, int high) {
        int maxSumLeft = 0;
        for (int i = mid; i>low; i--) {
            int sum = 0;
            for (int j = i; j<mid-low; j--) {
                sum += num[j];
                if (sum>maxSumLeft) maxSumLeft = sum;
            }
        }

        int maxSumRight = 0;
        for (int i = mid+1; i<high+1; i++) {
            int sum = 0;
            for (int j = i; j<high; j++) {
                sum += num[j];
                if (sum>maxSumRight) maxSumRight = sum;
            }
        }
        return maxSumLeft + maxSumRight;
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

