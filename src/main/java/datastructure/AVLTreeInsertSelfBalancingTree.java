package datastructure;

public class AVLTreeInsertSelfBalancingTree {
    void rotateLeft()
    {

    }
    void rotateRight()
    {

    }

    static int travelTreeAndInsert(Node root, int value){
        int height=0;
        if(value<=root.val)
        {
            if(root.left!=null){
                height=1+ travelTreeAndInsert(root.left,value);
            }
            else{
                Node node=new Node();
                node.val=value;
                node.ht=0;
                root.left=node;
            }
        }  if(value>root.val)
        {
            if(root.right!=null){
                height=1+ travelTreeAndInsert(root.right,value);
            }
            else{
                Node node=new Node();
                node.val=value;
                node.ht=0;
                root.right=node;
            }
        }
        root.ht=height;
        return height;

    }

   static int findBalanceFactor(Node root){
        if(root.left==null && root.right==null)
            return 0;
//        if(root.left)
return 0;
    }





    static Node insert(Node root,int val)
    {
        travelTreeAndInsert(root,val);
        int balanceFactor=findBalanceFactor(root);
        return root;
    }
}
class Node
    {	int val;	//Value
    	int ht;		//Height
    	Node left;	//Left child
    	Node right;	//Right child

	}

