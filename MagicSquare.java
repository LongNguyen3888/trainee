import java.util.Scanner;

public class MagicSquare {
    // Tạo ma phương với n là số lẻ
    public void makeSquare(int s) {
        int magicSqr[][] = new int[s][s];

        // Tìm vị trí cho số 1
        int r = s / 2;
        int c = s - 1;

        // Tìm từng vị trí trong ma phương cho từng số
        for (int no = 1; no <= s * s;) {
            if (r == -1 && c == s) {
                c = s - 2;
                r = 0;
            } else {
                // Nếu số tiếp theo ngoài khoảng cột
                if (c == s) {
                    c = 0;
                }

                // Nếu số tiếp theo ngoài khoảng hàng
                if (r < 0) {
                    r = s - 1;
                }
            }

            // Nếu số đấy đã tồn tại trong ma phương thì hàng+1 và cột-2
            if (magicSqr[r][c] != 0) {
                c = c - 2;
                r = r + 1;
                continue;
            } else {
                // Tăng số đang xét lên
                magicSqr[r][c] = no;
                no = no + 1;
            }

            // Điều kiện
            c = c + 1;
            r = r - 1;
        }

        // In ra ma phương
        System.out.println("Ma phuong cho " + s + " la : \n");
        System.out.println("Tong cua tung hang hoac cot la " + s * (s * s + 1) / 2 + ": \n");
        for (r = 0; r < s; r++) {
            for (c = 0; c < s; c++) {
                System.out.print(magicSqr[r][c] + " ");
            }
            System.out.println();
        }
    }

    //
    public static void main(String[] argvs) {

        // Nhập số n bất kì từ bàn phím
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so n: ");
        int n = sc.nextInt();

        // Nếu n chia hết cho 2
        if (n % 2 == 0) {
            System.out.println("Chau chua giai duoc:(");
        }

        // Tạo đối tượng cho class Magic
        MagicSquare obj = new MagicSquare();
        obj.makeSquare(n);

    }
}