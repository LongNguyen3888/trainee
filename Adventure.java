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
        if (ch[count - 1] == 69) {
            ch[count] = 69;
        } else if (ch[count - 1] == 87) {
            ch[count] = 87;
        } else if (ch[count - 1] == 83) {
            ch[count] = 83;
        } else if (ch[count - 1] == 78) {
            ch[count] = 78;
        }
    }
}