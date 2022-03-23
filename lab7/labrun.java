package lab7;
import java.lang.*;

public class labrun {
    public static void main(String[] args) {
        final Object[][] table = new String[12][];
        
        table[0] = new String[] { "Iteration", "Recursion"};


        double sum_iter = 0;
        double sum_recur = 0;
        double start_time = 0;
        double end_time1 = 0;
        double end_time2 = 0;
        int value = 2;
        for (int i = 1; i<=10; i++){
            start_time = System.currentTimeMillis();
            lab71.recur(value);
            end_time1 = System.currentTimeMillis() - start_time;
            sum_iter += end_time1;

            start_time = System.currentTimeMillis();
            lab72.recur(value);
            end_time2 = System.currentTimeMillis() - start_time;
            sum_recur += end_time2;

            value *=2;

            table[i] = new String[] {String.valueOf(end_time1), String.valueOf(end_time2)};
        }
        table[11] = new String[] {String.valueOf(sum_iter/10), String.valueOf(sum_recur/10)};
        for (final Object[] row : table) {
            System.out.format("%15s%15s%15s%n", row);
        
    }

    }
}
