/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Given a string, find the length of the longest substring which has no repeating characters.
 * Input: String="aabccbb"
 * Output: 3
 * Explanation: The longest substring without any repeating characters is "abc".
 */
package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstring {
    // Time complexity: O(n)
    // Space complexity: O(26) -> O(1)
    private static int findLength(String str) {
        if (str == null || str.isEmpty())
            return 0;
        Map<Character, Integer> freq = new HashMap<>();
        int maxLen = Integer.MIN_VALUE, windowStart = 0;
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            if (freq.containsKey(str.charAt(windowEnd))) {
                windowStart = Math.max(windowStart,
                        freq.get(str.charAt(windowEnd)) + 1);
            }
            freq.put(str.charAt(windowEnd), windowEnd);
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }
        return maxLen == Integer.MIN_VALUE ? 0: maxLen;
    }

    public static void main(String[] args) {
        int result = NoRepeatSubstring.findLength("aabccbb");
        System.out.println(result);
        result = NoRepeatSubstring.findLength("abbbb");
        System.out.println(result);
        result = NoRepeatSubstring.findLength("abccde");
        System.out.println(result);
    }
}
