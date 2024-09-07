/*
 Given a binary tree root and a linked list with head as the first node. 

Return True if all the elements in the linked list starting from the head correspond to some downward path connected in the binary tree otherwise return False.

In this context downward path means a path that starts at some node and goes downwards.

 

Example 1:



Input: head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
Output: true
Explanation: Nodes in blue form a subpath in the binary Tree.  
Example 2:



Input: head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
Output: true
Example 3:

Input: head = [1,4,2,6,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
Output: false
Explanation: There is no path in the binary tree that contains all the elements of the linked list from head.
 

Constraints:

The number of nodes in the tree will be in the range [1, 2500].
The number of nodes in the list will be in the range [1, 100].
1 <= Node.val <= 100 for each node in the linked list and binary tree.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Main function to check if there exists a path in the binary tree
    // that matches the given linked list.
    public boolean isSubPath(ListNode head, TreeNode root) {
        // Start a DFS (Depth-First Search) from the root of the tree.
        // We pass the linked list's head (for matching the entire list)
        // and start the search using DFS.
        return dfs(head, head, root);
    }

    // Helper function for DFS search to check if a path in the tree matches the linked list.
    boolean dfs(ListNode head, ListNode cur, TreeNode root) {
        // If `cur` becomes null, it means we have matched all nodes of the linked list successfully.
        if (cur == null) return true;
        // If `root` becomes null but `cur` is not null, it means we reached a dead-end in the tree
        // without matching the full list, so return false.
        if (root == null) return false;
        
        // If the current tree node's value matches the current linked list node's value,
        // advance to the next node in the linked list (`cur = cur.next`).
        if (cur.val == root.val) cur = cur.next;
        // If the current tree node doesn't match the current linked list node,
        // but matches the head of the linked list, we restart matching from the head
        // of the linked list (`head = head.next`).
        else if (head.val == root.val) head = head.next;
        // If the tree node doesn't match either the current node or the head of the list,
        // we reset the matching pointer to the start of the list (`cur = head`).
        else cur = head;

        // Continue the DFS by checking both the left and right child nodes of the tree.
        // We return true if any path down the left or right subtree successfully matches the list.
        return dfs(head, cur, root.left) || dfs(head, cur, root.right);
    }
}
