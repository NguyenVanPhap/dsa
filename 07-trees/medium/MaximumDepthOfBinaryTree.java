// LeetCode Problem: 104 - Maximum Depth of Binary Tree
// Difficulty: Easy/Medium
// Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/

/**
 * TODO:
 * 1. Understand the problem: Find maximum depth of binary tree
 * 2. Identify the approach: DFS (recursive or iterative)
 * 3. Implement the solution
 * 4. Test with edge cases (empty tree, single node, skewed tree)
 * 5. Analyze time complexity: O(n)
 * 6. Analyze space complexity: O(h) where h is height
 * 7. Optimize if possible
 */

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
        // TODO: Implement your solution here
        return 0;
    }
}

// Test cases
class MaximumDepthOfBinaryTreeTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // TODO: Add your test cases here
    }
}

