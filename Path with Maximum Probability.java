/*
1514. Path with Maximum Probability
Solved
Medium
Topics
Companies
Hint
You are given an undirected weighted graph of n nodes (0-indexed), represented by an edge list where edges[i] = [a, b] is an undirected edge connecting the nodes a and b with a probability of success of traversing that edge succProb[i].

Given two nodes start and end, find the path with the maximum probability of success to go from start to end and return its success probability.

If there is no path from start to end, return 0. Your answer will be accepted if it differs from the correct answer by at most 1e-5.

 

Example 1:



Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
Output: 0.25000
Explanation: There are two paths from start to end, one having a probability of success = 0.2 and the other has 0.5 * 0.5 = 0.25.
Example 2:



Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0, end = 2
Output: 0.30000
Example 3:



Input: n = 3, edges = [[0,1]], succProb = [0.5], start = 0, end = 2
Output: 0.00000
Explanation: There is no path between 0 and 2.
 

Constraints:

2 <= n <= 10^4
0 <= start, end < n
start != end
0 <= a, b < n
a != b
0 <= succProb.length == edges.length <= 2*10^4
0 <= succProb[i] <= 1
There is at most one edge between every two nodes.
*/
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // Array to store the maximum probability to reach each node starting from the start_node
        double[] maxProb = new double[n];
        // Initialize the probability of reaching the start_node as 1 (since we are already there)
        maxProb[start_node] = 1.0;

        // Perform a relaxation step up to n-1 times (like in the Bellman-Ford algorithm)
        for (int i = 0; i < n - 1; i++) {
            // Flag to check if any update happened during this iteration
            boolean updated = false;

            // Traverse each edge in the graph
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0]; // First node of the edge
                int v = edges[j][1]; // Second node of the edge
                double prob = succProb[j]; // Success probability of traveling this edge

                // Check if going from u to v gives a better probability and update if it does
                if (maxProb[u] * prob > maxProb[v]) {
                    maxProb[v] = maxProb[u] * prob;
                    updated = true; // Mark that an update happened
                }
                // Check if going from v to u gives a better probability and update if it does
                if (maxProb[v] * prob > maxProb[u]) {
                    maxProb[u] = maxProb[v] * prob;
                    updated = true; // Mark that an update happened
                }
            }

            // If no updates happened during this iteration, we can stop early
            if (!updated) break;
        }

        // Return the maximum probability to reach the end_node from the start_node
        return maxProb[end_node];
    }
}
