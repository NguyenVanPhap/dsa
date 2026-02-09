// LeetCode Problem: 3 - Longest Substring Without Repeating Characters
// Difficulty: Medium
// Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.*;

/**
 * TODO:
 * 1. Understand the problem: Find length of longest substring without repeating characters
 * 2. Identify the approach: Sliding window with HashMap
 * 3. Implement the solution
 * 4. Test with edge cases (all same char, all unique, empty string)
 * 5. Analyze time complexity: O(n)
 * 6. Analyze space complexity: O(min(n, m)) where m is charset size
 * 7. Optimize if possible
 */
class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        // TODO: Implement your solution here

        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                while (s.charAt(left) != c) {
                    map.remove(s.charAt(left));
                    left++;
                }
                left++;
            } else {
                map.put(s.charAt(right), right);
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }


        return maxLength;
    }

    public static void main(String[] args) {

        String s = "AABABBA";
        int result = lengthOfLongestSubstring(s);
        System.out.println("Longest substring length: " + result);

        // TODO: Add your test cases here
    }
}

