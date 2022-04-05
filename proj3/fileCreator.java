import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class fileCreator {
        public static void main(String[]args) {
                PrintWriter output;
                String file_out;
                int n;

                try {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("\n" + "Please enter the name of the output file that saves the result from the program:");
                    file_out = sc.nextLine();
                    System.out.println("How many numbers sir?");
                    n = sc.nextInt();
                    output = new PrintWriter(new FileOutputStream(file_out));

                    ArrayList<Integer> list = new ArrayList<Integer>(n);
                    Random random = new Random();

                    for (int i = 0; i < n; i++)
                    {
                    list.add(random.nextInt(10+10)-10);
                    }
                    for (int i: list) {
                            output.print(i + ",");
                    }
                    output.close();
                }
                catch (IOException e) {
                    System.out.println(e.getMessage() + "\n");
                    System.exit(1); // I/O error, continue to next loop and allow user to input files again
                }
        }
}
