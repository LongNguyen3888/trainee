import java.util.Scanner;
import java.lang.Math;

public class Binary {

    public void printBinary(int s) {

        int[] binary = new int[8];
        int temp = Math.abs(s);

        for (int i = 0; i < 8; i++) {
            binary[8 - 1 - i] = temp % 2;
            temp /= 2;
        }

        if (s < 0) {
            System.out.print("So bu 2 cua n la: ");

            for (int k = 0; k < 8; k++) {
                if (binary[k] == 0) {
                    binary[k] = 1;
                } else {
                    binary[k] = 0;
                }
            }

            binary[7] += 1;

            for (int h = 0; h < 8; h++) {
                if (binary[7 - h] == 2) {
                    binary[7 - h] = 0;
                    binary[6 - h] += 1;
                }
            }

            for (int l = 0; l < 8; l++) {
                if (l == 4) {
                    System.out.print(" ");
                }
                System.out.print(binary[l]);
            }

            System.out.println("");
        } else {
            System.out.print("So nhi phan cua n la: ");

            for (int j = 0; j < 8; j++) {
                if (j == 4) {
                    System.out.print(" ");
                }
                System.out.print(binary[j]);
            }

            System.out.println("");
        }
    }

    public static void main(String[] argvs) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so n: ");
        int n = sc.nextInt();
        Binary obj = new Binary();
        obj.printBinary(n);
    }
}
