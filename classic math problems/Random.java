import java.util.Scanner;

public class Random {
    int dem = 0;

    public void getRandom(int[] array) {
        printRandom(array, 0, true);
        System.out.println("");
        System.out.print("So truong hop hoan vi la " + dem);
    }

    private void printRandom(int[] array, int start, boolean display) {
        if (display) {
            System.out.println("");
            ++dem;
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
        }

        for (int j = start; j < array.length; j++) {
            int temp = array[start];
            array[start] = array[j];
            array[j] = temp;
            if (j == start) {
                printRandom(array, start + 1, false);
            } else {
                printRandom(array, start + 1, true);
            }
            temp = array[start];
            array[start] = array[j];
            array[j] = temp;
        }
    }

    public static void main(String[] argvs) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so n: ");
        int n = sc.nextInt();
        int[] array = new int[n * n];
        int no = 1;
        for (int i = 0; i < n * n; i++) {
            array[i] = no;
            ++no;
        }
        Random r = new Random();
        r.getRandom(array);
    }
}