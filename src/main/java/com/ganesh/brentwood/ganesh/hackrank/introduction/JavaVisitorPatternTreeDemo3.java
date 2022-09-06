package com.ganesh.brentwood.ganesh.hackrank.introduction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class JavaVisitorPatternTreeDemo3 {

    public static Tree solve() {
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
        LinkedHashMap<Integer, List<Integer>> edges = new LinkedHashMap<>();
        for (int i = 1; i <= n; i++) {
            edges.put(i, new ArrayList<Integer>());
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
            edges.get(firstNodeIndex).add(secomdNodeIndex);
            edges.get(secomdNodeIndex).add(firstNodeIndex);

        }
        Map<Integer, Tree> treeNodeList = new HashMap<>();
        boolean[] visitedNodes = new boolean[n];
        Tree parent = null;
        Stack<String> stack = new Stack<>();
        stack.push(rootIndex + " " + 0);
        parent = new TreeNode(treeNodes[rootIndex - 1], treeColors[0] == 0 ? Color.RED : Color.GREEN, 0);
        treeNodeList.put(rootIndex, parent);
        runDFS(visitedNodes,rootIndex,edges,treeNodeList,0,treeNodes, treeColors);


        return treeNodeList.get(rootIndex);
    }

    public static void runDFS(boolean[] visitedNodes, int indexToStartWith, Map<Integer, List<Integer>> edges, Map<Integer, Tree> nodeList, int depth,int []treeNodes, int []treeColors) {


        if (visitedNodes[indexToStartWith - 1] == false) {
            visitedNodes[indexToStartWith - 1] = true;
            Tree parent = nodeList.get(indexToStartWith);
            List<Integer> nodes = edges.get(indexToStartWith);


            Tree child = null;
            for (int i : nodes) {
                if (visitedNodes[i - 1] == false) {
                    if (edges.get(i).size() == 1) {
                        child = new TreeLeaf(treeNodes[i - 1], treeColors[i - 1] == 0 ? Color.RED : Color.GREEN, depth + 1);
                        nodeList.put(i, child);
                        ((TreeNode) parent).addChild(child);

                    } else {
                        child = new TreeNode(treeNodes[i - 1], treeColors[i - 1] == 0 ? Color.RED : Color.GREEN, depth + 1);
                        nodeList.put(i, child);
                        ((TreeNode) parent).addChild(child);
                        runDFS(visitedNodes,i, edges, nodeList,depth+1, treeNodes, treeColors);
                    }

                }

            }


        }

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