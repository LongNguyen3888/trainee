import java.util.Scanner;

class ucln {

    static int ucln(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    static int bcnn(int a, int b) {
        return a * b / ucln(a, b);
    }

    public static void main(String[] argvs) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap a: ");
        int a = sc.nextInt();
        System.out.print("Nhap b: ");
        int b = sc.nextInt();
        System.out.println("UCLN cua a va b la: " + ucln(a, b));
        System.out.print("BCNN a va b la: " + bcnn(a, b));
    }
}