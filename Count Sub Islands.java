/*
1905. Count Sub Islands
Solved
Medium
Topics
Companies
Hint
You are given two m x n binary matrices grid1 and grid2 containing only 0's (representing water) and 1's (representing land). An island is a group of 1's connected 4-directionally (horizontal or vertical). Any cells outside of the grid are considered water cells.

An island in grid2 is considered a sub-island if there is an island in grid1 that contains all the cells that make up this island in grid2.

Return the number of islands in grid2 that are considered sub-islands.

 

Example 1:


Input: grid1 = [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]], grid2 = [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]
Output: 3
Explanation: In the picture above, the grid on the left is grid1 and the grid on the right is grid2.
The 1s colored red in grid2 are those considered to be part of a sub-island. There are three sub-islands.
Example 2:


Input: grid1 = [[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]], grid2 = [[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]
Output: 2 
Explanation: In the picture above, the grid on the left is grid1 and the grid on the right is grid2.
The 1s colored red in grid2 are those considered to be part of a sub-island. There are two sub-islands.
 

Constraints:

m == grid1.length == grid2.length
n == grid1[i].length == grid2[i].length
1 <= m, n <= 500
grid1[i][j] and grid2[i][j] are either 0 or 1.
*/
class Solution {

    int m;  // Number of rows in the grid
    int n;  // Number of columns in the grid

    boolean isSubIsland;  // Flag to track if the current island in grid2 is a sub-island of grid1

    // Depth-First Search (DFS) to explore the island in grid2
    public void dfs(int[][] grid1, int[][] grid2, int i, int j) {
        // If the current position is out of bounds or already visited (grid2[i][j] == 0), return
        if (i < 0 || i == m || j < 0 || j == n || grid2[i][j] == 0) return;

        // If the current cell in grid2 is land but not in grid1, mark this island as not a sub-island
        if (grid1[i][j] != grid2[i][j]) {
            isSubIsland = false;
        }

        // Mark the current cell as visited by setting grid2[i][j] to 0
        grid2[i][j] = 0;

        // Continue the DFS in all four directions
        dfs(grid1, grid2, i + 1, j);  // Down
        dfs(grid1, grid2, i - 1, j);  // Up
        dfs(grid1, grid2, i, j + 1);  // Right
        dfs(grid1, grid2, i, j - 1);  // Left
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid1.length;    // Number of rows in the grid
        n = grid1[0].length; // Number of columns in the grid

        int subIslandCount = 0;  // To store the count of sub-islands

        // Iterate through each cell in grid2
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If the cell is land in grid2, it could be part of a sub-island
                if (grid2[i][j] == 1) {
                    isSubIsland = true;  // Start assuming this is a sub-island
                    dfs(grid1, grid2, i, j);  // Perform DFS to check the whole island

                    // If the flag remains true after DFS, it means this island is a sub-island
                    if (isSubIsland) {
                        subIslandCount++;  // Increment the count of sub-islands
                    }
                }
            }
        }

        return subIslandCount;  // Return the total count of sub-islands
    }
}