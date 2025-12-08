// LeetCode Problem: 143 - Reorder List
// Difficulty: Medium
// Link: https://leetcode.com/problems/reorder-list/

/**
 * TODO:
 * 1. Understand the problem: Reorder list: L0 -> L1 -> ... -> Ln-1 -> Ln to L0 -> Ln -> L1 -> Ln-1 -> ...
 * 2. Identify the approach: Find middle, reverse second half, merge
 * 3. Implement the solution
 * 4. Test with edge cases (empty list, single node, two nodes, odd/even length)
 * 5. Analyze time complexity: O(n)
 * 6. Analyze space complexity: O(1)
 * 7. Optimize if possible
 */

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public void reorderList(ListNode head) {
        // TODO: Implement your solution here
    }
}

// Test cases
class ReorderListTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // TODO: Add your test cases here
    }
}

