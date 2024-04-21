// Graph coloring problem using Branch and Bound
// Branch and Bound is an algorithm design paradigm that is used to solve optimization problems. It is a systematic method to find the optimal solution of a problem. The algorithm explores the search space by branching into subproblems and bounding the solution space to find the optimal solution.
// Bounding means neglecting the subproblems that cannot lead to the optimal solution. This is done by calculating the bound (upper or lower bound) of the subproblems and comparing them with the current best solution.

package Assignment4;

import java.util.HashSet;
import java.util.Set;

class Graph {
    private int vertices; // Number of vertices
    private int[][] graph; // Adjacency matrix

    public Graph(int vertices) {
        this.vertices = vertices;
        this.graph = new int[vertices][vertices];
    }

    // Function to check if it is safe to color the current vertex with the given
    // color.
    // It iterates through all vertices connected to currentVertex and checks if any
    // adjacent vertex already has the same color (resultColor[i] == color), which
    // would violate the graph coloring rules.

    public boolean isSafe(int currentVertex, int[] resultColor, int color) {
        for (int i = 0; i < vertices; i++) {
            if (graph[currentVertex][i] == 1 && resultColor[i] == color) {
                return false;
            }
        }
        return true;
    }

    // Calculates the bound (number of remaining available colors) for the
    // currentVertex based on already colored adjacent vertices.
    // It checks which colors are already used by adjacent vertices and subtracts
    // that from the total number of colors (noOfColors), giving the remaining
    // available colors.

    public int getBound(int currentVertex, int[] resultColor, int noOfColors) {
        Set<Integer> usedColors = new HashSet<>();
        for (int i = 0; i < vertices; i++) {
            if (graph[currentVertex][i] == 1 && resultColor[i] != 0) {
                usedColors.add(resultColor[i]);
            }
        }
        return noOfColors - usedColors.size();
    }

    // Recursively explores the graph to find a valid coloring using the Branch and
    // Bound approach.
    // It tries different colors for the currentVertex, checks if the coloring is
    // safe, calculates the bound, and proceeds recursively to the next vertex if
    // the bound allows further exploration.
    // If a valid coloring is found, it returns true; otherwise, it backtracks and
    // tries different colors for the currentVertex.
    public boolean graphColoringUtil(int noOfColors, int[] resultColor, int currentVertex) {
        if (currentVertex == vertices) {
            return true;
        }

        for (int color = 1; color <= noOfColors; color++) {
            if (isSafe(currentVertex, resultColor, color)) {
                resultColor[currentVertex] = color;

                int bound = getBound(currentVertex, resultColor, noOfColors);
                if (bound > 0) {
                    if (graphColoringUtil(noOfColors, resultColor, currentVertex + 1)) {
                        return true;
                    }
                }

                resultColor[currentVertex] = 0;
            }
        }

        return false;
    }

    // Main function to perform graph coloring with the given number of colors.
    public void graphColoring(int noOfColors) {
        int[] resultColor = new int[vertices];

        if (graphColoringUtil(noOfColors, resultColor, 0)) {
            System.out.println("Graph coloring possible with " + noOfColors + " colors.");
            System.out.println("Vertex   Color");
            for (int i = 0; i < vertices; i++) {
                System.out.println(i + "\t" + resultColor[i]);
            }
        } else {
            System.out.println("No solution exists.");
        }
    }

    public static void main(String[] args) {
        // Test case 1
        Graph g1 = new Graph(4);
        g1.graph = new int[][] { { 0, 1, 1, 1 },
                { 1, 0, 1, 0 },
                { 1, 1, 0, 1 },
                { 1, 0, 1, 0 } };
        g1.graphColoring(3);
        System.out.println();

        // Test case 2
        Graph g2 = new Graph(5);
        g2.graph = new int[][] { { 0, 1, 0, 1, 0 },
                { 1, 0, 1, 1, 1 },
                { 0, 1, 0, 1, 0 },
                { 1, 1, 1, 0, 1 },
                { 0, 1, 0, 1, 0 } };
        g2.graphColoring(2);
    }
}
