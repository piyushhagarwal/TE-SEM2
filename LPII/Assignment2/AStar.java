// A* Algorithm to solve the 8-puzzle problem
// What is 8-puzzle problem?
// Link:
// https://blog.goodaudience.com/solving-8-puzzle-using-a-algorithm-7b509c331288
package Assignment2;

import java.util.HashSet;
import java.util.PriorityQueue;

class Node {
    int[][] currentState;
    int g; // This is the cost to reach the current state, in our case it is number of
           // tiles moved to reach the current state
    int h; // This is the heuristic value, in our case it is the number of tiles that are
           // not in their correct position
    int f; // f = g + h
    Node parent;

    Node(int[][] currentState, int g, int h, Node parent) {

        this.currentState = currentState;
        this.g = g;
        this.h = h;
        this.f = g + h;
        this.parent = parent;
    }
}

public class AStar {

    // This function calculates the heuristic value of the current state
    public static int calculateHeuristic(int[][] currentState, int[][] goal) {
        int heuristic = 0;
        for (int i = 0; i < currentState.length; i++) {
            for (int j = 0; j < currentState[i].length; j++) {
                if (currentState[i][j] != goal[i][j]) {
                    heuristic++;
                }
            }
        }
        return heuristic;
    }

    // This function checks if the current state is the goal state
    public static boolean isGoal(int[][] currentState, int[][] goal) {
        for (int i = 0; i < currentState.length; i++) {
            for (int j = 0; j < currentState[i].length; j++) {
                if (currentState[i][j] != goal[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // This function copies the current state to a new state
    public static void copyState(int[][] currentState, int[][] newState) {
        for (int i = 0; i < currentState.length; i++) {
            for (int j = 0; j < currentState[i].length; j++) {
                newState[i][j] = currentState[i][j];
            }
        }
    }

    // This function finds the position of the zero/blank tile in the current state
    public static int[] findZero(int[][] currentState) {
        int[] zeroPosition = new int[2];
        for (int i = 0; i < currentState.length; i++) {
            for (int j = 0; j < currentState[i].length; j++) {
                if (currentState[i][j] == 0) {
                    zeroPosition[0] = i;
                    zeroPosition[1] = j;
                    return zeroPosition;
                }
            }
        }
        return zeroPosition;
    }

    // This function prints the path from the initial state to the goal state
    public static void printPath(Node node) {
        if (node == null) {
            return;
        }
        printPath(node.parent);
        for (int i = 0; i < node.currentState.length; i++) {
            for (int j = 0; j < node.currentState[i].length; j++) {
                System.out.print(node.currentState[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void AStarSearch(int[][] initial, int[][] goal) {
        PriorityQueue<Node> list = new PriorityQueue<Node>((a, b) -> a.f - b.f); // This stores the nodes in the order
                                                                                 // of
                                                                                 // their f value(lowest f value first)

        HashSet<Node> isVisited = new HashSet<Node>(); // To store the visited nodes

        Node initialNode = new Node(initial, 0, 0, null);
        list.add(initialNode);

        while (!list.isEmpty()) {
            Node currentNode = list.poll();

            if (isGoal(currentNode.currentState, goal)) {
                System.out.println("Goal State Reached");
                printPath(currentNode);
                return;
            }

            isVisited.add(currentNode);

            int[] zeroPosition = findZero(currentNode.currentState);
            int x = zeroPosition[0];
            int y = zeroPosition[1];

            // Move up
            if (x > 0) {
                int[][] newState = new int[currentNode.currentState.length][currentNode.currentState[0].length];
                copyState(currentNode.currentState, newState);
                int temp = newState[x][y];
                newState[x][y] = newState[x - 1][y];
                newState[x - 1][y] = temp;

                Node newNode = new Node(newState, currentNode.g + 1, calculateHeuristic(newState, goal), currentNode);

                if (!isVisited.contains(newNode)) {
                    list.add(newNode);
                }
            }

            // Move down
            if (x < currentNode.currentState.length - 1) {
                int[][] newState = new int[currentNode.currentState.length][currentNode.currentState[0].length];
                copyState(currentNode.currentState, newState);
                int temp = newState[x][y];
                newState[x][y] = newState[x + 1][y];
                newState[x + 1][y] = temp;

                Node newNode = new Node(newState, currentNode.g + 1, calculateHeuristic(newState, goal), currentNode);

                if (!isVisited.contains(newNode)) {
                    list.add(newNode);
                }
            }

            // Move left
            if (y > 0) {
                int[][] newState = new int[currentNode.currentState.length][currentNode.currentState[0].length];
                copyState(currentNode.currentState, newState);
                int temp = newState[x][y];
                newState[x][y] = newState[x][y - 1];
                newState[x][y - 1] = temp;

                Node newNode = new Node(newState, currentNode.g + 1, calculateHeuristic(newState, goal), currentNode);

                if (!isVisited.contains(newNode)) {
                    list.add(newNode);
                }
            }

            // Move right
            if (y < currentNode.currentState[0].length - 1) {
                int[][] newState = new int[currentNode.currentState.length][currentNode.currentState[0].length];
                copyState(currentNode.currentState, newState);
                int temp = newState[x][y];
                newState[x][y] = newState[x][y + 1];
                newState[x][y + 1] = temp;

                Node newNode = new Node(newState, currentNode.g + 1, calculateHeuristic(newState, goal), currentNode);

                if (!isVisited.contains(newNode)) {
                    list.add(newNode);
                }
            }
        }
    }

    public static void main(String args[]) {
        int[][] initial = { { 1, 2, 3 }, { 0, 4, 6 }, { 7, 5, 8 } };
        int[][] goal = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 0 } };

        AStarSearch(initial, goal);
    }
}