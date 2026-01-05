// LeetCode Problem: 271 - Encode and Decode Strings
// Difficulty: Medium
// Link: https://leetcode.com/problems/encode-and-decode-strings/

import java.util.*;

/**
 * TODO:
 * 1. Understand the problem: Encode list of strings to single string and decode back
 * 2. Identify the approach: Use delimiter or length prefix
 * 3. Implement both encode and decode methods
 * 4. Test with edge cases (empty strings, special characters, empty list)
 * 5. Analyze time complexity
 * 6. Analyze space complexity
 * 7. Optimize if possible
 */
public class EncodeAndDecodeStrings {
    // Encodes a list of strings to a single string.
    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public static List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            int j = i;
            // tìm dấu #
            while (s.charAt(j) != '#') {
                j++;
            }

            int len = Integer.parseInt(s.substring(i, j));
            j++; // bỏ qua '#'

            result.add(s.substring(j, j + len));
            i = j + len;
        }

        return result;
    }


    public static void main(String[] args) {


        // TODO: Add your test cases here
        List<String> strs = new ArrayList<>();
        strs.add("abc");
        strs.add("def");
        strs.add("ghi");
        strs.add("jkl");
        strs.add("mno");
        strs.add("pqr");

        String encoded = encode(strs);
        System.out.println("Encoded:" + encoded);
        List<String> decoded = decode(encoded);
        System.out.println("Decoded:" + decoded);
    }
}

