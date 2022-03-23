import java.util.Scanner;

class lab71 {
    public static void main(String[]args) {

        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        int last_one = 1;
        int last_two = 0;

        int temp = 0;
        for (int i = 0; i <= num; i++) {

            if (num==0)
                System.out.println("fib = 0");
            else if (num == 1)
                System.out.println("fib = 1");
            else {
                temp = last_one;
                last_two = last_one;
                last_one = last_one + temp;
            }
            
        }
        int fib = last_one + last_two
        System.out.println("fib = " + fib)
    }
}