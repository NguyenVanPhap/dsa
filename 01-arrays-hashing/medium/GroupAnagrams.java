// LeetCode Problem: 49 - Group Anagrams
// Difficulty: Medium
// Link: https://leetcode.com/problems/group-anagrams/

import java.util.*;

/**
 * TODO:
 * 1. Understand the problem: Group strings that are anagrams of each other
 * 2. Identify the approach: Use HashMap with sorted string as key
 * 3. Implement the solution
 * 4. Test with edge cases (empty array, single element, all anagrams, no anagrams)
 * 5. Analyze time complexity: O(n * k log k) where n is number of strings, k is max length
 * 6. Analyze space complexity: O(n * k)
 * 7. Optimize if possible
 */
class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }


    public static void main(String[] args) {
        // TODO: Add your test cases here
        // Example:
        String[] test1 = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(test1));
    }
}

