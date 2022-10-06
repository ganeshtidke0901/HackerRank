package datastructure;

public class AVLTreeInsertSelfBalancingTree {
    	/* Class node is defined as :
    class Node
    	int val;	//Value
    	int ht;		//Height
    	Node left;	//Left child
    	Node right;	//Right child

	*/

    static Node travelTreeAndInsert(Node root, int value) {
        if(root==null)
        {
            Node node = new Node();
            node.val = value;
            node.ht = 0;
            return node;
        }
        int height = 0;
        if (value <= root.val) {
            if (root.left != null) {
                travelTreeAndInsert(root.left, value);
            } else {
                Node node = new Node();
                node.val = value;
                node.ht = 0;
                root.left = node;
            }
        }
        if (value > root.val) {
            if (root.right != null) {
                travelTreeAndInsert(root.right, value);
            } else {
                Node node = new Node();
                node.val = value;
                node.ht = 0;
                root.right = node;
            }
        }

        root.ht=(findHeight(root.left)>=findHeight(root.right)?findHeight(root.left):findHeight(root.right))+1;
        System.out.println(root.val+" "+root.ht);
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

    static Node travelNRotateIfUnBalanced(Node root) {
        Node node = null;
        if (root.left != null) {
            node = travelNRotateIfUnBalanced(root.left);
            if (node != null) {
                rotateNode(root, root.left);
            }
        }
        if (root.right != null) {
            node = travelNRotateIfUnBalanced(root.right);
            if (node != null) {
                rotateNode(root, root.right);
            }
        }
        int balanceFactor = findHeight(root.left) - findHeight(root.right);
        if (balanceFactor > 1 || balanceFactor < -1) {
            return root;
        } else {
            return null;
        }


    }

    private static void rotateNode(Node root, Node node) {

        int bf = findHeight(node.left) - findHeight(node.right);
        // System.out.println("Rotate:"+root.val+" "+root.ht+" "+bf);
        if (bf < -1) {
            Node newSubTreeNode= rotateLeft(node);
            root.right=newSubTreeNode;
        } else {
            Node newSubTreeNode= rotateRight(node);
            root.left=newSubTreeNode;
        }
    }

    private static Node rotateRight(Node node) {
        Node newRight=node;
        Node newRoot=node.left;
        newRight.left=newRoot.right;
        newRoot.right=newRight;
        return newRoot;
    }

    private static Node rotateLeft(Node node) {
        Node newLeft=node;
        // System.out.println(newLeft.val);
        Node newRoot=node.right;
        // System.out.println(newRoot.val);
        newLeft.right=newRoot.left;
        newRoot.left=newLeft;
        return newRoot;
    }


    static Node insert(Node root, int val) {
        travelTreeAndInsert(root, val);
        travelNRotateIfUnBalanced(root);
        return root;
    }

    public static void main(String[] args) {

    }


}

class Node {
    int val;    //Value
    int ht;        //Height
    Node left;    //Left child
    Node right;    //Right child

}




