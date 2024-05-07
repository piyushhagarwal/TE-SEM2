package Assignment3;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KrushkalsMST {
    static List<Element> mstEdges = new ArrayList<>();

    static class DisjointSet {
        int[] parent;
        int[] size;

        public DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int findUltimateParent(int node) {
            if (parent[node] == node) {
                return node;
            }

            int ultimateParent = findUltimateParent(parent[node]);
            parent[node] = ultimateParent;
            return parent[node];
        }

        public void union(int node1, int node2) {
            int ultimateParent1 = findUltimateParent(node1);
            int ultimateParent2 = findUltimateParent(node2);

            // If both nodes are already in the same set, return
            if (ultimateParent1 == ultimateParent2) {
                return;
            }

            if (size[ultimateParent1] < size[ultimateParent2]) {
                parent[ultimateParent1] = ultimateParent2;
                size[ultimateParent2] += size[ultimateParent1];
            } else {
                parent[ultimateParent2] = ultimateParent1;
                size[ultimateParent1] += size[ultimateParent2];
            }
        }
    }

    static class Element {
        int node1;
        int node2;
        int weight;

        public Element(int node1, int node2, int weight) {
            this.node1 = node1;
            this.node2 = node2;
            this.weight = weight;
        }
    }

    static int spanningTree(int V, int E, int edges[][]) {

        // Sort the edges based on their weights(Minimum weights first)
        PriorityQueue<Element> pq = new PriorityQueue<Element>((a, b) -> a.weight - b.weight);
        for (int i = 0; i < E; i++) {
            pq.add(new Element(edges[i][0], edges[i][1], edges[i][2]));
        }

        int sum = 0;
        DisjointSet ds = new DisjointSet(V);
        while (!pq.isEmpty()) {
            Element popped = pq.poll();
            int node1 = popped.node1;
            int node2 = popped.node2;
            if (ds.findUltimateParent(node1) == ds.findUltimateParent(node2)) {
                continue;
            }

            ds.union(node1, node2);
            sum += popped.weight;

            mstEdges.add(popped);
        }

        return sum;
    }

    public static void main(String[] args) {
        int V = 4;
        int E = 5;
        int[][] edges = { { 0, 1, 10 }, { 0, 2, 6 }, { 0, 3, 5 }, { 1, 3, 15 }, { 2, 3, 4 } };

        System.out.println(spanningTree(V, E, edges));
        for (Element e : mstEdges) {
            System.out.println(e.node1 + " " + e.node2 + " " + e.weight);
        }
    }
}
