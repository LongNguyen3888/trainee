import java.util.Scanner;

class IndianMathProblem {

    static long multiply(long a, long b) {
        if (b == 0) {
            return 0;
        }
        long t = multiply(a, b / 2);
        t = t + t;
        if (b % 2 == 1) {
            t = t + a;
        }
        return t;
    }

    static long power(long a, long b) {
        if (b == 0) {
            return 1;
        }
        long t = power(a, b / 2);
        t = t * t;
        if (b % 2 == 1) {
            t = t * a;
        }
        return t;
    }

    public static void main(String[] argvs) {
        long a, b;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap a: ");
        a = sc.nextLong();
        System.out.print("Nhap b: ");
        b = sc.nextLong();
        if (b == 0) {
            System.out.print("Invalid input");
        }
        IndianMathProblem ob = new IndianMathProblem();
        long result1 = ob.multiply(a, b);
        System.out.println("Multiply: " + result1);
        long result2 = ob.power(a, b);
        System.out.print("Power :" + result2);
    }
}