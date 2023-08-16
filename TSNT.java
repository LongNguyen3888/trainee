import java.util.Scanner;

class TSNT {

    static void printTSNT(int a) {
        int m = 2;
        while (a != 1) {
            if (a % m == 0) {
                System.out.print(m + " ");
                a /= m;
            } else {
                m++;
            }
        }
    }

    public static void main(String[] argvs) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap a: ");
        int a = sc.nextInt();
        TSNT ob = new TSNT();
        ob.printTSNT(a);
    }
}