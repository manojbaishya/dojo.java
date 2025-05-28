package org.dojo.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graphs {
    public int countGroupsBFS(List<String> related) {
        List<List<Integer>> G = getAdjacencyList(related);
        boolean[] visitedNodes = new boolean[G.size()];
        int groups = 0;

        for (int k = 0; k < visitedNodes.length; k++) {
            if (!visitedNodes[k]) {
                BFS(k, G, visitedNodes);
                groups += 1;
            }
        }

        return groups;
    }

    public int countGroupsDFS(List<String> related) {
        List<List<Integer>> G = getAdjacencyList(related);
        boolean[] visitedNodes = new boolean[G.size()];
        int groups = 0;

        for (int k = 0; k < visitedNodes.length; k++) {
            if (!visitedNodes[k]) {
                DFS(k, G, visitedNodes);
                groups += 1;
            }
        }

        return groups;
    }

    private List<List<Integer>> getAdjacencyList(List<String> related) {
        List<List<Integer>> G = new ArrayList<>();
        for (int k = 0; k < related.size(); k++) {
            G.add(new ArrayList<>());
            for (int m = k + 1; m < related.get(k).length(); m++) {
                if (Character.getNumericValue(related.get(k).charAt(m)) == 1) {
                    G.get(k).add(m);
                }
            }
        }
        return G;
    }

    private void DFS(int nodeId, List<List<Integer>> graph, boolean[] visitedNodes) {
        List<Integer> neighbours = graph.get(nodeId);
        visitedNodes[nodeId] = true;
        for (int P : neighbours) {
            if (!visitedNodes[P]) {
                DFS(P, graph, visitedNodes);
            }
        }
    }

    private void BFS(int nodeId, List<List<Integer>> graph, boolean[] visitedNodes) {
        Queue<Integer> nodesToCheck = new LinkedList<>();
        nodesToCheck.offer(nodeId);
        visitedNodes[nodeId] = true;

        while (!nodesToCheck.isEmpty()) {
            int node = nodesToCheck.poll();
            List<Integer> neighbours = graph.get(node);
            for (int item : neighbours) {
                if (!visitedNodes[item]) {
                    nodesToCheck.offer(item);
                    visitedNodes[item] = true;
                }
            }
        }
    }
}
