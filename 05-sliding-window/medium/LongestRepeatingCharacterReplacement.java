// LeetCode Problem: 424 - Longest Repeating Character Replacement
// Difficulty: Medium
// Link: https://leetcode.com/problems/longest-repeating-character-replacement/

/**
 * TODO:
 * 1. Understand the problem: Find longest substring with at most k replacements
 * 2. Identify the approach: Sliding window
 * 3. Implement the solution
 * 4. Test with edge cases (k = 0, k >= string length, all same characters)
 * 5. Analyze time complexity: O(n)
 * 6. Analyze space complexity: O(1) - fixed alphabet size
 * 7. Optimize if possible
 */
class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        // TODO: Implement your solution here
        int left = 0;
        int maxFreq = 0;
        int maxLen = 0;
        int[] count = new int[26];

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);
            count[c - 'A']++;
            maxFreq = Math.max(maxFreq, count[c - 'A']);
            int windownSize = right - left + 1;
            if (windownSize - maxFreq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);

        }
        return maxLen;
    }

    public static void main(String[] args) {

        // TODO: Add your test cases here
        String s = "AABABBA";
        int k = 1;
        int result = characterReplacement(s, k);
        System.out.println("Longest substring length: " + result);
    }
}
