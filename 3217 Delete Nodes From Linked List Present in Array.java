/*
You are given an array of integers nums and the head of a linked list. Return the head of the modified linked list after removing all nodes from the linked list that have a value that exists in nums.

 

Example 1:

Input: nums = [1,2,3], head = [1,2,3,4,5]

Output: [4,5]

Explanation:



Remove the nodes with values 1, 2, and 3.

Example 2:

Input: nums = [1], head = [1,2,1,2,1,2]

Output: [2,2,2]

Explanation:



Remove the nodes with value 1.

Example 3:

Input: nums = [5], head = [1,2,3,4]

Output: [1,2,3,4]

Explanation:



No node has value 5.

 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 105
All elements in nums are unique.
The number of nodes in the given list is in the range [1, 105].
1 <= Node.val <= 105
The input is generated such that there is at least one node in the linked list that has a value not present in nums.
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
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        // Find the maximum value in the nums array to create a frequency array
        int max = -1;
        // Loop through nums to find the maximum value
        for(int num : nums ){
            max = num > max ? num : max;  // Update max if the current num is greater
        }

        // Create a boolean array of size max + 1 to track the presence of each number in nums
        boolean[] freq = new boolean[max + 1]; // freq[i] will be true if 'i' exists in nums

        // Mark the presence of each number in nums in the boolean array
        for(int num : nums) {
            freq[num] = true; // Mark the number as present
        }

        // Create a dummy node to start building the modified list
        ListNode temp = new ListNode();
        // Pointer to traverse and build the new list
        ListNode current = temp;

        // Traverse the original linked list
        while(head != null) {
            // If the current node's value is either greater than the size of freq array 
            // (i.e., out of bounds) or not present in the nums array (freq[head.val] == false),
            // add it to the new list
            if(head.val >= freq.length || !freq[head.val]) {
                current.next = head;  // Add the current node to the new list
                current = current.next;  // Move the current pointer to the next position
            }
            head = head.next;  // Move to the next node in the original list
        }

        // Terminate the new list by setting current.next to null
        current.next = null;
        
        // Return the new list starting from the next node of the dummy node
        return temp.next;
    }
}
