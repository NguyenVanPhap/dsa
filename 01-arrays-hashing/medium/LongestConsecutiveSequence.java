// LeetCode Problem: 128 - Longest Consecutive Sequence
// Difficulty: Medium
// Link: https://leetcode.com/problems/longest-consecutive-sequence/

import java.util.HashSet;

/**
 * TODO:
 * 1. Understand the problem: Find longest consecutive sequence in unsorted array
 * 2. Identify the approach: Use HashSet to check for consecutive numbers
 * 3. Implement the solution
 * 4. Test with edge cases (empty array, single element, duplicates)
 * 5. Analyze time complexity: O(n)
 * 6. Analyze space complexity: O(n)
 * 7. Optimize if possible
 */
class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        // TODO: Implement your solution here
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;

        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int count = 1;
                int currentNum = num;

                while (set.contains(currentNum + 1)) {
                    count++;
                    currentNum++;
                }

                longest = Math.max(longest, count);
            }
        }


        return longest;
    }

    public static void main(String[] args) {

        // TODO: Add your test cases here
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        int[] nums = {1, 2, 3, 5, 4, 6, 9, 2};
        System.out.println("Longest Consecutive Sequense:" + lcs.longestConsecutive(nums));
    }
}

