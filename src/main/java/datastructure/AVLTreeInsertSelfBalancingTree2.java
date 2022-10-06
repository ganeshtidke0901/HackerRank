package datastructure;

import java.util.Scanner;
import java.util.Stack;

public class AVLTreeInsertSelfBalancingTree2 {


    static Node travelTreeAndInsert(Node root, int value) {

        if (value <= root.val) {
            if (root.left != null) {
                Node node = travelTreeAndInsert(root.left, value);
                if (node != null) {
                    root.left = node;
                }
            } else {
                Node node = new Node();
                node.val = value;
                node.ht = 0;
                root.left = node;

            }
        }
        if (value > root.val) {
            if (root.right != null) {
                Node node = travelTreeAndInsert(root.right, value);
                if (node != null) {
                    root.right = node;
                }

            } else {
                Node node = new Node();
                node.val = value;
                node.ht = 0;
                root.right = node;
            }
        }

        root.ht = (findHeight(root.left) >= findHeight(root.right) ? findHeight(root.left) : findHeight(root.right)) + 1;
        int balanceFactor = findHeight(root.left) - findHeight(root.right);
        if (balanceFactor > 1) {
            int leftNodeBF = findHeight(root.left.left) - findHeight(root.left.right);
            if (leftNodeBF < 0) {
                Node newLeft = rotateLeft(root.left);
                root.left = newLeft;
            }
            Node node = rotateRight(root);
            return node;
        } else if (balanceFactor < -1) {
            int rightNodeBF = findHeight(root.right.left) - findHeight(root.right.right);
            if (rightNodeBF > 0) {
                Node node =  rotateRight(root.right);
                root.right=node;
            }
            Node node = rotateLeft(root);
            return node;

        }

        // System.out.println(root.val+" "+root.ht);

        return null;
    }

    static int findHeight(Node node) {
        if (node == null)
            return -1;
        if (node.left == null && node.right == null) {
            return 0;
        } else {
            return node.ht;
        }
    }


    private static void rotateNode(Node root, Node node) {

        int bf = findHeight(node.left) - findHeight(node.right);
        // System.out.println("Rotate:"+root.val+" "+root.ht+" "+bf);
        if (bf < -1) {
            Node newSubTreeNode = rotateLeft(node);
            root.right = newSubTreeNode;
        } else {
            Node newSubTreeNode = rotateRight(node);
            root.left = newSubTreeNode;
        }
    }

    private static Node rotateRight(Node node) {
        Node newRight = node;
        Node newRoot = node.left;
        newRight.left = newRoot.right;
        newRoot.right = newRight;
        newRight.ht = (findHeight(newRight.left) >= findHeight(newRight.right) ? findHeight(newRight.left) : findHeight(newRight.right)) + 1;
        newRoot.ht = (findHeight(newRoot.left) >= findHeight(newRoot.right) ? findHeight(newRoot.left) : findHeight(newRoot.right)) + 1;
        return newRoot;
    }

    private static Node rotateLeft(Node node) {
        Node newLeft = node;
        Node newRoot = node.right;
        newLeft.right = newRoot.left;
        newRoot.left = newLeft;
        newLeft.ht = (findHeight(newLeft.left) >= findHeight(newLeft.right) ? findHeight(newLeft.left) : findHeight(newLeft.right)) + 1;
        newRoot.ht = (findHeight(newRoot.left) >= findHeight(newRoot.right) ? findHeight(newRoot.left) : findHeight(newRoot.right)) + 1;

        return newRoot;
    }


    static Node insert(Node root, int val) {
       Node node= travelTreeAndInsert(root, val);
        return node!=null?node:root;
    }

    public static void travelInOrder(Node node) {
        if (node == null) {
            return;
        }
        travelInOrder(node.left);
        int balanceFactor = findHeight(node.left) - findHeight(node.right);
        System.out.print(node.val + "(BF=" + balanceFactor + ") ");
        travelInOrder(node.right);
    }

    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int n=scanner.nextInt();
//        int [] data=new int[n];
//        for(int i=1;i<=n;i++)
//        {
//            data[i]=scanner.nextInt();
//        }
        int[] data = {14, 25, 21, 10, 23, 7, 26, 12, 30, 16, 19};
        Node node = new Node();
        node.val = data[0];
        node.ht = 0;

        for(int i=1;i<=2;i++)
        {
            node=insert(node, data[i]);
            travelInOrder(node);
            System.out.println();

        }


//        insert(node, 6);
//        travelInOrder(node);
//        System.out.println();

    }


}



