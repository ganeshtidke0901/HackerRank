package com.ganesh.brentwood.ganesh.hackrank.introduction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis {
    public abstract int getResult();

    public abstract void visitNode(TreeNode node);

    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    int counter = 0;

    public int getResult() {

        return counter;
    }

    public void visitNode(TreeNode node) {

    }

    public void visitLeaf(TreeLeaf leaf) {
        counter += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    long counter = 1;

    public int getResult() {

        return (int) counter;
    }

    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED)
            counter = (counter * node.getValue()) % 1000000007;
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED)
            counter = (counter * leaf.getValue()) % 1000000007;
    }
}

class FancyVisitor extends TreeVis {
    int sumOfNonLeafAtEvenDepth = 0;
    int sumOfGreenLeadNodes = 0;

    public int getResult() {
        int result = sumOfNonLeafAtEvenDepth - sumOfGreenLeadNodes;
        return result < 0 ? result * -1 : result;
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            // System.out.println("---"+node.getValue()+" "+node.getDepth());
            sumOfNonLeafAtEvenDepth += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            sumOfGreenLeadNodes += leaf.getValue();
        }
    }
}

public class JavaVisitorPatternTreeDemo2 {

    public static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        String[] numbers = new String[0];
        String[] colors = new String[0];
        try {
            n = Integer.parseInt(bufferedReader.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
        int[] treeNodes = new int[n];
        int[] treeColors = new int[n];
        try {
            numbers = bufferedReader.readLine().split(" ");
            colors = bufferedReader.readLine().split(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < numbers.length; i++) {
            treeNodes[i] = Integer.parseInt(numbers[i]);
            treeColors[i] = Integer.parseInt(colors[i]);

        }

        int rootIndex = 0;
        LinkedHashMap<Integer, List<Integer>> map = new LinkedHashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<Integer>());
        }
        for (int i = 1; i < n; i++) {
            String line = "";
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            int firstNodeIndex = Integer.parseInt(line.split(" ")[0]);
            if (i == 1) {
                rootIndex = firstNodeIndex;
            }
            int secomdNodeIndex = Integer.parseInt(line.split(" ")[1]);
            map.get(firstNodeIndex).add(secomdNodeIndex);
            map.get(secomdNodeIndex).add(firstNodeIndex);

        }
//for (int i =0;i< treeNodes.length;i++)
//{
//    System.out.print((i+1)+"="+treeNodes[i]+" ");
//}

//        System.out.println(map);
        Map<Integer, Tree> treeNodeList = new HashMap<>();
        boolean[] visitedNodes = new boolean[n];
        Tree parent = null;
        Stack<String> stack = new Stack<>();
        stack.push(rootIndex + " " + 0);
        parent = new TreeNode(treeNodes[rootIndex - 1], treeColors[0] == 0 ? Color.RED : Color.GREEN, 0);
        treeNodeList.put(rootIndex, parent);
//        ArrayDeque
        while (stack.size() > 0) {
//            System.out.println(stack);
            String item = stack.pop();
            int index = Integer.parseInt(item.split(" ")[0]);
//            if(index == 98)
//            {
//                System.out.println();
//            }
            int depth = Integer.parseInt(item.split(" ")[1]);
            if (visitedNodes[index - 1] == false) {
                visitedNodes[index - 1] = true;
                parent = treeNodeList.get(index);
                List<Integer> nodes = map.get(index);

                if (parent != null && parent instanceof TreeLeaf) {
                    continue;
                }

//            System.out.println(index+"--"+nodes);
                Tree child = null;
                for (int i : nodes) {
                    if (visitedNodes[i - 1] == false) {
//                    if(i==98)
//                    {
//                        System.out.println();
//                    }
                        if (map.get(i).size() == 1) {
                            child = new TreeLeaf(treeNodes[i - 1], treeColors[i - 1] == 0 ? Color.RED : Color.GREEN, depth + 1);
                        } else {
                            child = new TreeNode(treeNodes[i - 1], treeColors[i - 1] == 0 ? Color.RED : Color.GREEN, depth + 1);
                        }
                        treeNodeList.put(i, child);
                        ((TreeNode) parent).addChild(child);
                        stack.push(i + " " + (depth + 1));
                    }

                }

            }

        }


        return treeNodeList.get(rootIndex);
    }

    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}