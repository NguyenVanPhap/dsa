// LeetCode Problem: 41 - First Missing Positive
// Difficulty: Hard
// Link: https://leetcode.com/problems/first-missing-positive/

import static java.util.Collections.swap;

/**
 * TODO:
 * 1. Understand the problem: Find smallest missing positive integer in O(n) time, O(1) space
 * 2. Identify the approach: Use array indices as hash keys (cyclic sort)
 * 3. Implement the solution
 * 4. Test with edge cases (all negatives, all positives, duplicates)
 * 5. Analyze time complexity: O(n)
 * 6. Analyze space complexity: O(1)
 * 7. Optimize if possible
 */
class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        // TODO: Implement your solution here
        int n = nums.length;

        int i = 0;
        while (i < n) {
            if (nums[i] > 0 && nums[i] <= n) {
                int correct = nums[i] - 1;
                if (nums[i] != nums[correct]) {
                    int tmp = nums[i];
                    nums[i] = nums[correct];
                    nums[correct] = tmp;

                    continue;
                }
            }
            i++;
        }

        for (i = 0; i < n; i++)
            System.out.println(nums[i]);

        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {

        
        // TODO: Add your test cases here

       int[] nums = {-1, 1, 3, 4};
       System.out.println(new FirstMissingPositive().firstMissingPositive(nums));
    }
}

