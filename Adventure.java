/*Đoàn thám hiểm Nam cực xuất phát từ Trạm nghiên cứu đặt ở điểm có toạ độ (0, 0). Trục OX chạy từ tây sang đông, trục OY chạy từ nam lên bắc. 
Ban đầu Đoàn đi theo một trong số 4 hướng Đông (E), Tây (W), Nam (S) hoặc Bắc (N). Sau khi đi một quảng đường là một đơn vị độ dài Đoàn dừng lại 
thực hiện các đo đạc khảo sát cần thiết và tuỳ theo tình hình thực tế, trưởng đoàn sẽ quyết định đi tiếp theo hướng nào. Để đánh dấu các điểm trên 
bản đồ khai thác và dễ dàng xác định đường trở về lịch trình di chuyển trong nhật ký được ghi dưới dạng xâu các ký tự trong tập {E, W, S, N}. 
Tuy vậy thời tiết ở địa cực nổi tiếng là đỏng đảnh. Bão tuyết có thể nổi lên bất kỳ lúc nào kèm theo các cơn bão từ làm rối loạn la bàn. 
Khi đó đường đi sẽ được ghi nhận bằng các ký tự L - Rẽ trái, R - Rẽ phải, B – Đi ngược lại hướng vừa đi hoặc C - Tiếp tục đi thẳng theo hướng cũ. 
Mỗi khi bão từ chấm dứt, la bàn hoạt động bình thường trở lại lịch trình di chuyển lại được ghi nhận bằng các ký tự E, W, S, N. 
Ở thời điểm ban đầu của cuộc thám hiểm thời tiết tốt, không có bão từ. Trong suốt cuộc hành trình có thể không có trận bão từ nào hoặc bão từ 
có thể xẩy ra nhiều lần. Ví dụ, lịch trình ở hình bên có thể được ghi nhận bằng xâu WRECSSCRWWCRN.
Yêu cầu: Cho một lịch trình di chuyển xác định bởi xâu Z độ dài không quá 200 gồm các ký tự trong tập {E, W, S, N, L ,R, B, C}, bắt đầu 
bằng một trong số 4 ký tự đầu tiên. Hãy tính khoảng cách theo đường chim bay từ điểm dừng cuối của đoàn thám hiểm tớỉ Trạm nghiên cứu mà Đoàn xuất phát. 
Dữ liệu: Vào từ file văn bản EXPLORE.INP gồm một dòng chứa xâu Z xác định một lịch trình di chuyển của đoàn thám hiểm.
Kết quả: Đưa ra file văn bản EXPLORE.OUT một số thực có 3 chữ số sau dấu chấm thập phân, đó là khoảng cách tìm được với dữ liệu vào đã cho. */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class Adventure {
    public static int x = 0;
    public static int y = 0;

    public static void main(String[] args) {
        try {
            File fileDir = new File("C:/Users/admin/Documents/Zalo Received Files/map.txt/");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileDir), "UTF8"));

            String str;
            str = in.readLine();
            str = str.toUpperCase();
            char[] ch = new char[str.length()];
            boolean check = true;
            Adventure ob = new Adventure();

            if (str.length() > 200) {
                check = false;
            } else {
                for (int i = 0; i < str.length(); i++) {
                    ch[i] = str.charAt(i);
                    if (ch[0] != 69 && ch[0] != 87 && ch[0] != 83 && ch[0] != 78) {
                        check = false;
                        break;
                    }
                    if (ch[i] != 69 && ch[i] != 87 && ch[i] != 83 && ch[i] != 78 && ch[i] != 76 && ch[i] != 82
                            && ch[i] != 66 && ch[i] != 67) {
                        check = false;
                        break;
                    }
                }
            }

            if (!check) {
                System.out.print("Error");
            } else {
                for (int i = 1; i < str.length(); i++) {
                    if (ch[i] == 76) {
                        ob.Left(ch, i);
                    } else if (ch[i] == 82) {
                        ob.Right(ch, i);
                    } else if (ch[i] == 66) {
                        ob.Back(ch, i);
                    } else if (ch[i] == 67) {
                        ob.Continue(ch, i);
                    }
                }

                for (int i = 0; i < str.length(); i++) {
                    if (ch[i] == 69) {
                        ++x;
                    } else if (ch[i] == 87) {
                        --x;
                    } else if (ch[i] == 83) {
                        --y;
                    } else if (ch[i] == 78) {
                        ++y;
                    }
                }

                String result = String.format("%.3f", Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
                System.out.print(result);
            }
            in.close();
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void Right(char[] ch, int count) {
        if (ch[count - 1] == 69) {
            ch[count] = 83;
        } else if (ch[count - 1] == 87) {
            ch[count] = 78;
        } else if (ch[count - 1] == 83) {
            ch[count] = 87;
        } else if (ch[count - 1] == 78) {
            ch[count] = 69;
        }
    }

    public void Left(char[] ch, int count) {
        if (ch[count - 1] == 69) {
            ch[count] = 78;
        } else if (ch[count - 1] == 87) {
            ch[count] = 83;
        } else if (ch[count - 1] == 83) {
            ch[count] = 69;
        } else if (ch[count - 1] == 78) {
            ch[count] = 87;
        }
    }

    public void Back(char[] ch, int count) {
        if (ch[count - 1] == 69) {
            ch[count] = 87;
        } else if (ch[count - 1] == 87) {
            ch[count] = 69;
        } else if (ch[count - 1] == 83) {
            ch[count] = 78;
        } else if (ch[count - 1] == 78) {
            ch[count] = 83;
        }
    }

    public void Continue(char[] ch, int count) {
        if (ch[count - 1] == 69 || ch[count - 1] == 87 || ch[count - 1] == 83 || ch[count - 1] == 78) {
            ch[count] = ch[count - 1];
        }
    }
}
