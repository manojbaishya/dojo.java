package org.dojo.algorithms;

import java.util.HashMap;
import java.util.Map;

public class TreeProblems {
    public static void processPostOrder(int[] inorder, int[] preorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) inorderMap.put(inorder[i], i);
        processPostOrderInternal(inorderMap, preorder, 0, preorder.length);
    }

    private static void processPostOrderInternal(Map<Integer, Integer> inorderMap, int[] preorder, int start, int end) {
        if (start > end) return;
        int node = inorderMap.get(preorder[0]);
        if (node != 0) processPostOrderInternal(inorderMap, preorder, start, node - 1);
        if (node != preorder.length - 1) processPostOrderInternal(inorderMap, preorder, node + 1, end);

        System.out.println("Node is " + preorder[0]);
    }
}
