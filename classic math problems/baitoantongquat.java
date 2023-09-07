import java.util.Scanner;

public class baitoantongquat {
    private int n;
    private boolean cot[];
    private boolean cc[];
    private boolean cp[];
    private int a[];
    private int dem;

    public void Nhap() {
        n = 8;
    }

    public void Init() {
        cot = new boolean[n + 1];
        cc = new boolean[2 * n - 1];
        cp = new boolean[2 * n - 1];
        a = new int[n + 1];

        int i;
        for (i = 0; i < n + 1; i++)
            cot[i] = true;
        for (i = 0; i < 2 * n - 1; i++) {
            cc[i] = true;
            cp[i] = true;
        }
        dem = 0;
    }

    public void InKQ() {
        int i, j;
        dem++;
        System.out.println("Nghiem thu " + dem + ": ");
        for (i = 1; i <= n; i++) {
            for (j = 1; j < a[i]; j++)
                System.out.print("# ");
            System.out.print("O ");
            for (j = a[i] + 1; j <= n; j++)
                System.out.print("# ");
            System.out.println();
        }
        System.out.println();
    }

    public void Try2(int i) { // Tim vi tri dat quan hau vao hang i
        int j;
        for (j = 1; j <= n; j++)
            if ((cot[j] == true) && (cc[i - j + 7] == true) && (cp[i + j - 2] == true)) {
                a[i] = j;
                cot[j] = false;
                cc[i - j + 7] = false;
                cp[i + j - 2] = false;

                if (i == n)
                    InKQ();
                else
                    Try2(i + 1);

                cot[j] = true;
                cc[i - j + 7] = true;
                cp[i + j - 2] = true;
            }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        baitoantongquat t = new baitoantongquat();
        t.Nhap();
        t.Init();
        t.Try2(1);
    }

}