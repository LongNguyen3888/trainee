import java.util.Scanner;

public class IndianMathProblem2 {

    static long mutiply(long a, long b, long c) {
        if (b == 0) {
            return 0;
        }
        long t = mutiply(a, b / 2, c) % c;
        t = (t + t) % c;
        if (b % 2 == 1) {
            t = (t + a % c) % c;
        }
        return t;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input a: ");
        long a = sc.nextLong();
        System.out.print("Input b: ");
        long b = sc.nextLong();
        System.out.print("Input c: ");
        long c = sc.nextLong();
        long result = mutiply(a, b, c);
        System.out.print(result);
    }
}
