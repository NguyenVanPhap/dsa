// LeetCode Problem: 102 - Binary Tree Level Order Traversal
// Difficulty: Medium
// Link: https://leetcode.com/problems/binary-tree-level-order-traversal/

import java.util.*;

/**
 * TODO:
 * 1. Understand the problem: Return level order traversal of binary tree
 * 2. Identify the approach: BFS using queue
 * 3. Implement the solution
 * 4. Test with edge cases (empty tree, single node, skewed tree)
 * 5. Analyze time complexity: O(n)
 * 6. Analyze space complexity: O(n)
 * 7. Optimize if possible
 */


class LevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        // TODO: Implement your solution here
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            result.add(level);
        }


        return result;
    }


    public static void main(String[] args) {

        // Test case:
        //        1
        //       / \
        //      2   3
        //     /     \
        //    4       5

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(4);

        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        // Gọi hàm level order
        List<List<Integer>> result = levelOrder(root);

        // In kết quả
        System.out.println(result);

    }

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

