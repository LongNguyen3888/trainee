import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class Vietnamese {
    private Node root = null;
    public static boolean flag = false;

    Vietnamese() {
    }

    public void insert(String i) {
        this.root = this.insert(this.root, i);
    }

    //Create a binary tree
    public Node insert(Node node, String value) {
        if (node == null) {
            return new Node(value);
        } else {
            if (value.compareTo(node.value) < 0) {
                node.left = this.insert(node.left, value);
            } else {
                if (value.compareTo(node.value) <= 0) {
                    return node;
                }

                node.right = this.insert(node.right, value);
            }

            return node;
        }
    }

    //Find the input in binary tree
    public boolean searchNode(Node temp, String data) {
        if (this.root == null) {
            return false;
        } else {
            if (Objects.equals(temp.value, data)) {
                flag = true;
                return flag;
            }

            if (!flag && temp.left != null) {
                this.searchNode(temp.left, data);
            }

            if (!flag && temp.right != null) {
                this.searchNode(temp.right, data);
            }
        }

        return flag;
    }

    //Reorganize binary tree
    public void inOrder(Node node) {
        if (node != null) {
            this.inOrder(node.left);
            this.inOrder(node.right);
        }
    }

    //Check the input
    public String Test(String[] strArr, int n, int m) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n; i < m; i++) {
            stringBuilder.append(strArr[i]).append(" ");
        }
        return stringBuilder.substring(0, stringBuilder.length()-1);
    }

    public static void main(String[] args) {
        Vietnamese bst = new Vietnamese();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter word you want to Search from file: ");
        String SearchWord = sc.nextLine();

        //Convert the input string to char array
        char[] charArray = new char[SearchWord.length()];
        for (int i = 0; i < SearchWord.length(); i++) {
            charArray[i] = SearchWord.charAt(i);
            if (charArray[i] >= 48 && charArray[i] <= 57) {
                charArray[i] = 32;
            }
        }

        //Recreate the string
        SearchWord = new String(charArray);
        SearchWord = SearchWord.toLowerCase().replaceAll("\\p{Punct}", "").replaceAll("( )+", "$1").trim();

        //Convert to string array
        String[] strArr = SearchWord.split("\\s+");

        int n = strArr.length;
        int count = 0;

        try {
            //Read the file
            File fileDir = new File("C:/Users/admin/Documents/Zalo Received Files/Dic.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), "UTF8"));

            String str;
            //Insert each lines in file to the binary tree
            while ((str = in.readLine()) != null) {
                bst.insert(str);
            }

            //Reorganize
            bst.inOrder(bst.root);

            String Test1;
            StringBuilder Test2 = new StringBuilder();

            //Create a test2 string
            while (count != n) {
                for (int i = 0; i < n; i++) {
                    if (count == n - i) {
                        break;
                    }
                    Test1 = bst.Test(strArr, count, n - i);
                    if (bst.searchNode(bst.root, Test1)) {
                        Test2.append(Test1).append(" ");
                        flag = false;
                        break;
                    }
                }
                if(Test2.isEmpty()) {
                    break;
                } else {
                    String[] strArray = Test2.toString().split("\\s+");
                    if (count == strArray.length) {
                        break;
                    }
                    count = strArray.length;
                }
            }

            //Checking test2 with input
            if (!Test2.isEmpty()) {
                String result = Test2.substring(0, Test2.length()-1);
                if (Objects.equals(result, SearchWord)) {
                    System.out.println("Đây là một câu Tiếng Việt.");
                } else {
                    System.out.println("Không phải là một câu Tiếng Việt.");
                }
            } else {
                System.out.println("Không phải là một câu Tiếng Việt.");
            }

            in.close();
        } catch (UnsupportedEncodingException var7) {
            System.out.println(var7.getMessage());
        } catch (IOException var8) {
            System.out.println(var8.getMessage());
        } catch (Exception var9) {
            System.out.println(var9.getMessage());
        }

    }

    static class Node {
        String value;
        Node left;
        Node right;

        Node(String value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}