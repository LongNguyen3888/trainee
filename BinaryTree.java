import java.util.Objects;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class BinaryTree {
    private Node root;
    public static boolean flag = false;

    BinaryTree() {
        root = null;
    }

    static class Node {
        String value;
        Node left;
        Node right;

        Node(String value) {
            this.value = value;
            left = null;
            right = null;
        }

        /*
         * public void displayData() {
         * System.out.print(value + " ");
         * }
         */
    }

    public void insert(String i) {
        root = insert(root, i);
    }

    public Node insert(Node node, String value) {
        if (node == null) {
            return new Node(value);
        }
        if (value.compareTo(node.value) < 0) {
            node.left = insert(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            node.right = insert(node.right, value);
        } else {
            return node;
        }
        return node;
    }

    // searchNode() will search for the particular node in the binary tree
    public void searchNode(Node temp, String data) {
        // Check whether tree is empty
        if (root == null) {
            System.out.println("Tree is empty");
        } else {
            // If value is found in the given binary tree then, set the flag to true
            if (Objects.equals(temp.value, data)) {
                flag = true;
                return;
            }
            // Search in left subtree
            if (!flag && temp.left != null) {
                searchNode(temp.left, data);
            }
            // Search in right subtree
            if (!flag && temp.right != null) {
                searchNode(temp.right, data);
            }
        }
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            // node.displayData();
            inOrder(node.right);
        }
    }

    /*
     * public void preOrder(Node node) {
     * if (node != null) {
     * node.displayData();
     * preOrder(node.left);
     * preOrder(node.right);
     * }
     * }
     * 
     * public void postOrder(Node node) {
     * if (node != null) {
     * postOrder(node.left);
     * postOrder(node.right);
     * node.displayData();
     * }
     * }
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String SearchWord;
        BinaryTree bst = new BinaryTree();
        System.out.print("Enter word you want to Search from file: ");
        SearchWord = sc.nextLine();
        try {
            File fileDir = new File("C:/Users/admin/Documents/Zalo Received Files/Dic.txt");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileDir), "UTF8"));

            String str;

            while ((str = in.readLine()) != null) {
                bst.insert(str);
            }

            bst.inOrder(bst.root);

            bst.searchNode(bst.root, SearchWord);

            if (flag)
                System.out.println(SearchWord);
            else
                System.out.println("Element is not present in the binary tree.");

            in.close();
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
