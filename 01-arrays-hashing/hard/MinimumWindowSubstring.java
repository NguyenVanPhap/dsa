// LeetCode Problem: 76 - Minimum Window Substring
// Difficulty: Hard
// Link: https://leetcode.com/problems/minimum-window-substring/

import java.util.HashMap;

/**
 * TODO:
 * 1. Understand the problem: Find minimum window substring containing all characters of pattern
 * 2. Identify the approach: Sliding window with two pointers
 * 3. Implement the solution
 * 4. Test with edge cases (no valid window, pattern longer than string, duplicates in pattern)
 * 5. Analyze time complexity: O(|s| + |t|)
 * 6. Analyze space complexity: O(|s| + |t|)
 * 7. Optimize if possible
 */
class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        // TODO: Implement your solution here
        int left = 0, right = 0;

        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        String shortedSubstring = s;


        while (right < s.length()) {
            char c = s.charAt(right);

            if (t.indexOf(s.charAt(left)) != -1) {
                if (t.indexOf(c) != -1) {
                    if (frequencyMap.get(c) != null) {
                        frequencyMap.put(c, frequencyMap.get(c) - 1);
                        if (frequencyMap.get(c) == 0)
                            frequencyMap.remove(c);
                    }

                }

                if (frequencyMap.isEmpty()) {
                    String substring = s.substring(left, right + 1);
                    System.out.println("Found substring: " + substring);
                    shortedSubstring = substring.length() < shortedSubstring.length() ? substring : shortedSubstring;
                    frequencyMap.put(s.charAt(left), frequencyMap.getOrDefault(s.charAt(left), 0) + 1);
                    left++;
                }
                right++;
            } else {
                left++;
            }
        }

        if(!frequencyMap.isEmpty())
            return "";

        return shortedSubstring;
    }

    public static String minWindowV2(String s, String t) {
        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> freq = new HashMap<>();
        for (char c : t.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int left = 0, minLen = Integer.MAX_VALUE, start = 0;
        int required = t.length();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (freq.containsKey(c)) {
                if (freq.get(c) > 0) required--;
                freq.put(c, freq.get(c) - 1);
            }

            while (required == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left++);
                if (freq.containsKey(leftChar)) {
                    freq.put(leftChar, freq.get(leftChar) + 1);
                    if (freq.get(leftChar) > 0) required++;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {


        // TODO: Add your test cases here
        String s = "ADOBECAODEBANC";
        String t = "ABCH";
        System.out.println("Result:" + minWindow(s, t));
    }
}

