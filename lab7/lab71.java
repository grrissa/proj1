package lab7;

import java.util.Scanner;

class lab71 {
    public static void main(String[]args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of the fibonacci number you want: ");
        int num = input.nextInt();

        int result = recur(num);
        System.out.println("fib = " + result);
    }
    public static int recur(int num){
        int last_one = 1;
        int last_two = 0;

        int temp = 0;
        for (int i = 0; i < num-1; i++) {
            temp = last_two;
            last_two = last_one;
            last_one = last_one + temp;
        }
        return last_one;
    }
}