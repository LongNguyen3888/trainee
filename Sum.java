import java.util.Arrays;
import java.util.Scanner;
import java.lang.String;
import java.math.*;

public class Sum {

    // Turn String to Int Array
    static int[] Sum(String x) {
        char[] arr = x.toCharArray();
        int[] array = new int[x.length()];
        // Turn char array to int array
        for (int i = 0; i < x.length(); i++) {
            array[i] = arr[i] - 48;
        }
        return array;
    }

    // Sum 2 int array
    public void printSum(int[] x, int[] y) {

        int m = x.length - y.length;
        int max = Math.max(x.length, y.length);
        int min = Math.min(x.length, y.length);
        int[] z = new int[max];
        int[] temp = new int[max];

        // If x and y has the same length
        if (m == 0) {
            // Calculate sum
            for (int i = 0; i < max; i++) {
                z[max - 1 - i] = x[max - 1 - i] + y[max - 1 - i];
            }
        }
        // If x have more index than y
        else if (m > 0) {
            // Create temporary array
            for (int l = 0; l < min; l++) {
                temp[l + m] = y[l];
                if (l < Math.abs(m)) {
                    temp[l] = 0;
                }
            }
            // Calculate Sum
            for (int i = 0; i < max; i++) {
                z[max - 1 - i] = x[max - 1 - i] + temp[max - 1 - i];
            }
        }
        // If y have more index than x
        else {
            // Create temporary array
            for (int l = 0; l < min; l++) {
                temp[l - m] = x[l];
                if (l < Math.abs(m)) {
                    temp[l] = 0;
                }
            }
            // Calculate Sum
            for (int i = 0; i < max; i++) {
                z[max - 1 - i] = y[max - 1 - i] + temp[max - 1 - i];
            }
        }

        // Sum condition
        for (int j = 0; j < max - 1; j++) {
            if (z[max - 1 - j] >= 10) {
                z[max - 1 - j] -= 10;
                z[max - 2 - j] += 1;
            }
        }

        // Print result
        for (int k = 0; k < max; k++) {
            System.out.print(z[k]);
        }
    }

    public static void main(String[] argvs) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so n: ");
        String n = sc.nextLine();
        System.out.print("Nhap so m: ");
        String m = sc.nextLine();
        int[] no1 = Sum(n);
        int[] no2 = Sum(m);
        Sum obj = new Sum();
        System.out.print("Tong 2 so la: ");
        obj.printSum(no1, no2);
    }
}
