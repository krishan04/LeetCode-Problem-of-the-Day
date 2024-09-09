/*
 You are given two integers m and n, which represent the dimensions of a matrix.

You are also given the head of a linked list of integers.

Generate an m x n matrix that contains the integers in the linked list presented in spiral order (clockwise), starting from the top-left of the matrix. If there are remaining empty spaces, fill them with -1.

Return the generated matrix.

 

Example 1:


Input: m = 3, n = 5, head = [3,0,2,6,8,1,7,9,4,2,5,5,0]
Output: [[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]
Explanation: The diagram above shows how the values are printed in the matrix.
Note that the remaining spaces in the matrix are filled with -1.
Example 2:


Input: m = 1, n = 4, head = [0,1,2]
Output: [[0,1,2,-1]]
Explanation: The diagram above shows how the values are printed from left to right in the matrix.
The last space in the matrix is set to -1.
 

Constraints:

1 <= m, n <= 105
1 <= m * n <= 105
The number of nodes in the list is in the range [1, m * n].
0 <= Node.val <= 1000
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        // Create a 2D array with 'm' rows. 
        // Each row is an empty array that will later hold 'n' columns.
        int[][] arr = new int[m][];
        
        // Initialize each row of the 2D array with 'n' columns and fill with -1.
        // The -1 indicates unfilled positions.
        for (int i = 0; i < m; i++) {
            arr[i] = new int[n];
            Arrays.fill(arr[i], -1);  // Filling all positions with -1 initially
        }

        // Define four boundaries to traverse the matrix in a spiral pattern:
        // top: starting row index
        // left: starting column index
        // bottom: last row index
        // right: last column index
        int top = 0, left = 0;
        int bottom = m - 1, right = n - 1;

        // Traverse the matrix in spiral order as long as the linked list (head) is not null.
        while (head != null) {
            // Fill the top row from left to right
            for (int i = left; i <= right && head != null; i++) {
                arr[top][i] = head.val;  // Assign the current node value to the matrix
                head = head.next;        // Move to the next node in the list
            }
            top++;  // Move the top boundary down by one row

            // Fill the rightmost column from top to bottom
            for (int i = top; i <= bottom && head != null; i++) {
                arr[i][right] = head.val; // Assign the current node value to the matrix
                head = head.next;         // Move to the next node in the list
            }
            right--;  // Move the right boundary left by one column

            // Fill the bottom row from right to left, but only if there are still rows left
            if (top <= bottom) {
                for (int i = right; i >= left && head != null; i--) {
                    arr[bottom][i] = head.val;  // Assign the current node value to the matrix
                    head = head.next;           // Move to the next node in the list
                }
                bottom--;  // Move the bottom boundary up by one row
            }

            // Fill the leftmost column from bottom to top, but only if there are still columns left
            if (left <= right) {
                for (int i = bottom; i >= top && head != null; i--) {
                    arr[i][left] = head.val;  // Assign the current node value to the matrix
                    head = head.next;         // Move to the next node in the list
                }
                left++;  // Move the left boundary right by one column
            }
        }

        // Return the filled 2D array
        return arr;
    }
}
