package lab7;
import java.util.Scanner;
public class lab72 {
    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of the fibonacci number you want: ");
        int num = in.nextInt(); 

        int result = recur(num);
        System.out.println(result);
        }

    public static int recur(int num) {
        if (num == 0) {
            return 0;
        }
        else if (num == 1) {
            return 1;
        }
        else{
            return recur(num-1) + recur(num-2);
        }
    }
}
