/*
You are given a 2D integer array descriptions where descriptions[i] = [parenti, childi, isLefti] indicates that parenti is the parent of childi in a binary tree of unique values. Furthermore,

If isLefti == 1, then childi is the left child of parenti.
If isLefti == 0, then childi is the right child of parenti.
Construct the binary tree described by descriptions and return its root.

The test cases will be generated such that the binary tree is valid.



Example 1:


Input: descriptions = [[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]
Output: [50,20,80,15,17,19]
Explanation: The root node is the node with value 50 since it has no parent.
The resulting binary tree is shown in the diagram.
Example 2:


Input: descriptions = [[1,2,1],[2,3,0],[3,4,1]]
Output: [1,2,null,null,3,4]
Explanation: The root node is the node with value 1 since it has no parent.
The resulting binary tree is shown in the diagram.

 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
public class createBinaryTree {
    public TreeNode createBinaryTree(int[][] descriptions) {
        // Map to store nodes by their values
        HashMap<Integer, TreeNode> map = new HashMap<>();
        // Set to keep track of all child nodes
        Set<Integer> children = new HashSet<>();

        // Iterate through each description to build the tree
        for (int[] arr : descriptions) {
            int parent = arr[0];  // Parent node value
            int child = arr[1];   // Child node value
            int isLeft = arr[2];  // Whether the child is a left (1) or right (0) child

            // Add the child to the set of children
            children.add(child);

            // Get or create the parent node
            TreeNode parentNode = map.getOrDefault(parent, new TreeNode(parent));

            // Get or create the child node
            TreeNode childNode = map.getOrDefault(child, new TreeNode(child));

            // Link the child to the parent appropriately
            if (isLeft == 1) {
                parentNode.left = childNode;  // Left child
            } else {
                parentNode.right = childNode; // Right child
            }

            // Update the map with the parent and child nodes
            map.put(parent, parentNode);
            map.put(child, childNode);
        }

        // Find the root node (which is not any child)
        int root = -1;
        for (int[] arr : descriptions) {
            if (!children.contains(arr[0])) {
                root = arr[0];
                break;
            }
        }

        // Return the root node, or null if not found
        return map.getOrDefault(root, null);
    }
}
