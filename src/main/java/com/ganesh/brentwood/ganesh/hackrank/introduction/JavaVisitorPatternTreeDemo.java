package com.ganesh.brentwood.ganesh.hackrank.introduction;
//
//import java.util.ArrayList;
//import java.util.*;
//
//import java.util.Scanner;
//
//enum Color {
//    RED, GREEN
//}
//
//abstract class Tree {
//
//    private int value;
//    private com.ganesh.brentwood.ganesh.hackrank.introduction2.Color color;
//    private int depth;
//
//    public Tree(int value, com.ganesh.brentwood.ganesh.hackrank.introduction2.Color color, int depth) {
//        this.value = value;
//        this.color = color;
//        this.depth = depth;
//    }
//
//    public int getValue() {
//        return value;
//    }
//
//    public com.ganesh.brentwood.ganesh.hackrank.introduction2.Color getColor() {
//        return color;
//    }
//
//    public int getDepth() {
//        return depth;
//    }
//
//    public abstract void accept(com.ganesh.brentwood.ganesh.hackrank.introduction2.TreeVis visitor);
//}
//
//class TreeNode extends com.ganesh.brentwood.ganesh.hackrank.introduction2.Tree {
//
//    private ArrayList<com.ganesh.brentwood.ganesh.hackrank.introduction2.Tree> children = new ArrayList<>();
//
//    public TreeNode(int value, com.ganesh.brentwood.ganesh.hackrank.introduction2.Color color, int depth) {
//        super(value, color, depth);
//    }
//
//    public void accept(com.ganesh.brentwood.ganesh.hackrank.introduction2.TreeVis visitor) {
//        visitor.visitNode(this);
//
//        for (com.ganesh.brentwood.ganesh.hackrank.introduction2.Tree child : children) {
//            child.accept(visitor);
//        }
//    }
//
//    public void addChild(com.ganesh.brentwood.ganesh.hackrank.introduction2.Tree child) {
//        children.add(child);
//    }
//}
//
//class TreeLeaf extends com.ganesh.brentwood.ganesh.hackrank.introduction2.Tree {
//
//    public TreeLeaf(int value, com.ganesh.brentwood.ganesh.hackrank.introduction2.Color color, int depth) {
//        super(value, color, depth);
//    }
//
//    public void accept(com.ganesh.brentwood.ganesh.hackrank.introduction2.TreeVis visitor) {
//        visitor.visitLeaf(this);
//    }
//}
//
//abstract class TreeVis {
//    public abstract int getResult();
//
//    public abstract void visitNode(com.ganesh.brentwood.ganesh.hackrank.introduction2.TreeNode node);
//
//    public abstract void visitLeaf(com.ganesh.brentwood.ganesh.hackrank.introduction2.TreeLeaf leaf);
//
//}
//
//class SumInLeavesVisitor extends com.ganesh.brentwood.ganesh.hackrank.introduction2.TreeVis {
//    int counter = 0;
//
//    public int getResult() {
//
//        return counter;
//    }
//
//    public void visitNode(com.ganesh.brentwood.ganesh.hackrank.introduction2.TreeNode node) {
//
//    }
//
//    public void visitLeaf(com.ganesh.brentwood.ganesh.hackrank.introduction2.TreeLeaf leaf) {
//        counter += leaf.getValue();
//    }
//}
//
//class ProductOfRedNodesVisitor extends com.ganesh.brentwood.ganesh.hackrank.introduction2.TreeVis {
//    int counter = 1;
//
//    public int getResult() {
//
//        return counter;
//    }
//
//    public void visitNode(com.ganesh.brentwood.ganesh.hackrank.introduction2.TreeNode node) {
//        if (node.getColor() == com.ganesh.brentwood.ganesh.hackrank.introduction2.Color.RED)
//            counter = counter * node.getValue();
//    }
//
//    public void visitLeaf(com.ganesh.brentwood.ganesh.hackrank.introduction2.TreeLeaf leaf) {
//        if (leaf.getColor() == com.ganesh.brentwood.ganesh.hackrank.introduction2.Color.RED)
//            counter = counter * leaf.getValue();
//    }
//}
//
//class FancyVisitor extends com.ganesh.brentwood.ganesh.hackrank.introduction2.TreeVis {
//    int sumOfNonLeafAtEvenDepth = 0;
//    int sumOfGreenLeadNodes = 0;
//
//    public int getResult() {
//        int result = sumOfNonLeafAtEvenDepth - sumOfGreenLeadNodes;
//        return result < 0 ? result * -1 : result;
//    }
//
//    public void visitNode(com.ganesh.brentwood.ganesh.hackrank.introduction2.TreeNode node) {
//        if (node.getDepth() % 2 == 0) {
//            // System.out.println("---"+node.getValue()+" "+node.getDepth());
//            sumOfNonLeafAtEvenDepth += node.getValue();
//        }
//    }
//
//    public void visitLeaf(com.ganesh.brentwood.ganesh.hackrank.introduction2.TreeLeaf leaf) {
//        if (leaf.getColor() == com.ganesh.brentwood.ganesh.hackrank.introduction2.Color.GREEN) {
//            sumOfGreenLeadNodes += leaf.getValue();
//        }
//    }
//}

public class JavaVisitorPatternTreeDemo {
//
//    public static com.ganesh.brentwood.ganesh.hackrank.introduction2.Tree solve() {
//        //read the tree from STDIN and return its root as a return value of this function
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] treeNodes = new int[n];
//        int[] treeColors = new int[n];
//        for (int i = 1; i <= n; i++) {
//            treeNodes[i - 1] = scanner.nextInt();
//        }
//        for (int i = 1; i <= n; i++) {
//            treeColors[i - 1] = scanner.nextInt();
//        }
//
//        LinkedHashMap<Integer, List<Integer>> map = new LinkedHashMap<>();
//        for (int i = 1; i < n; i++) {
//            int firstNodeIndex = scanner.nextInt();
//            int secomdNodeIndex = scanner.nextInt();
//            if (map.containsKey(firstNodeIndex)) {
//                map.get(firstNodeIndex).add(secomdNodeIndex);
//
//            } else {
//                List<Integer> list = new ArrayList<Integer>();
//                list.add(secomdNodeIndex);
//                map.put(Integer.valueOf(firstNodeIndex), list);
//            }
//
//        }
//
//         System.out.println(map);
//        int atomicCounter = 0;
//        List<com.ganesh.brentwood.ganesh.hackrank.introduction2.Tree> treeNodeList = new ArrayList<>();
//        for (Map.Entry<Integer, List<Integer>> entity : map.entrySet()) {
//            com.ganesh.brentwood.ganesh.hackrank.introduction2.Tree parent = null;
//            for (com.ganesh.brentwood.ganesh.hackrank.introduction2.Tree tree : treeNodeList) {
//                if (tree.getValue() == treeNodes[entity.getKey() - 1]) {
//                    parent = tree;
//                    break;
//                }
//            }
//
//
//            if (parent == null) {
//                parent = new com.ganesh.brentwood.ganesh.hackrank.introduction2.TreeNode(treeNodes[entity.getKey() - 1], treeColors[entity.getKey() - 1] == 0 ? com.ganesh.brentwood.ganesh.hackrank.introduction2.Color.RED : com.ganesh.brentwood.ganesh.hackrank.introduction2.Color.GREEN, atomicCounter);
//                treeNodeList.add(parent);
//            }
//            for (Integer n1 : entity.getValue()) {
//                com.ganesh.brentwood.ganesh.hackrank.introduction2.Tree child = null;
//                if (map.containsKey(n1)) {
//                    child = new com.ganesh.brentwood.ganesh.hackrank.introduction2.TreeNode(treeNodes[n1 - 1], treeColors[n1 - 1] == 0 ? com.ganesh.brentwood.ganesh.hackrank.introduction2.Color.RED : com.ganesh.brentwood.ganesh.hackrank.introduction2.Color.GREEN, atomicCounter + 1);
//
//                } else {
//                    child = new com.ganesh.brentwood.ganesh.hackrank.introduction2.TreeLeaf(treeNodes[n1 - 1], treeColors[n1 - 1] == 0 ? com.ganesh.brentwood.ganesh.hackrank.introduction2.Color.RED : com.ganesh.brentwood.ganesh.hackrank.introduction2.Color.GREEN, atomicCounter + 1);
//                }
//                ((com.ganesh.brentwood.ganesh.hackrank.introduction2.TreeNode) parent).addChild(child);
//
//                treeNodeList.add(child);
//
//            }
//
//
//            atomicCounter++;
//        }
//
//
//        //    for(Tree tree:treeNodeList)
//        //    {
//        //        System.out.println(tree.getValue());
//        //    }
//        return treeNodeList.get(0);
//    }
//
//
//    public static void main(String[] args) {
//        com.ganesh.brentwood.ganesh.hackrank.introduction2.Tree root = solve();
//        com.ganesh.brentwood.ganesh.hackrank.introduction2.SumInLeavesVisitor vis1 = new com.ganesh.brentwood.ganesh.hackrank.introduction2.SumInLeavesVisitor();
//        com.ganesh.brentwood.ganesh.hackrank.introduction2.ProductOfRedNodesVisitor vis2 = new com.ganesh.brentwood.ganesh.hackrank.introduction2.ProductOfRedNodesVisitor();
//        com.ganesh.brentwood.ganesh.hackrank.introduction2.FancyVisitor vis3 = new com.ganesh.brentwood.ganesh.hackrank.introduction2.FancyVisitor();
//
//        root.accept(vis1);
//        root.accept(vis2);
//        root.accept(vis3);
//
//        int res1 = vis1.getResult();
//        int res2 = vis2.getResult();
//        int res3 = vis3.getResult();
//
//        System.out.println(res1);
//        System.out.println(res2);
//        System.out.println(res3);
//    }
}