// LeetCode Problem: 11 - Container With Most Water
// Difficulty: Medium
// Link: https://leetcode.com/problems/container-with-most-water/

/**
 * TODO:
 * 1. Understand the problem: Find two lines that form container with most water
 * 2. Identify the approach: Two pointers from both ends
 * 3. Implement the solution
 * 4. Test with edge cases (two elements, all same height, decreasing heights)
 * 5. Analyze time complexity: O(n)
 * 6. Analyze space complexity: O(1)
 * 7. Optimize if possible
 */
class ContainerWithMostWater {
    private static int maxArea(int[] height) {
        // TODO: Implement your solution here


        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                maxArea = Math.max(maxArea, height[left] * (right - left));
                left++;
            } else {
                maxArea = Math.max(maxArea, height[right] * (right - left));
                right--;
            }

        }

        return maxArea;
    }

    public static void main(String[] args) {
        // TODO: Add your test cases here
        int[] testcase = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Result:" + maxArea(testcase));


    }
}

