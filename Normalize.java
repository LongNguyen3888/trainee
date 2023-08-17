import java.util.Scanner;

public class Normalize {

    char[] Convert(String str) {
        char[] c = new char[0];
        for (int i = 0; i < str.length(); i++) {
            c = str.toCharArray();
        }
        return c;
    }
    void Normarlize(char[] c, String str) {
        int n = str.length();
        for (int i = 0; i < n; i++) {
            if (c[0] >= 'a' && c[0] <= 'z') {
                c[0] -= 32;
            }
            System.out.print(c[i]);
            if ((c[i] == ' ' || c[i] == 39) && c[i + 1] >= 'a' && c[i + 1] <= 'z') {
                c[i + 1] -= 32;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input: ");
        String n = sc.nextLine();
        n = n.trim();
        n = n.replaceAll("( )+", "$1");
        Normalize nm = new Normalize();
        char[] m = nm.Convert(n);
        System.out.print("Ho va ten: ");
        nm.Normarlize(m, n);
    }
}