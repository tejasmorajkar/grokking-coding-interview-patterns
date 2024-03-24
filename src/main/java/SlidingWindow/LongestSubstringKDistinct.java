/**
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 * Input: String="araaci", K=2
 * Output: 4
 * Explanation: The longest substring with no more than '2' distinct characters is "araa".
 */

package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
    private static int findLength(String str, int k) {
        if (str == null || str.isEmpty() || str.length() < k)
            return 0;
        Map<Character, Integer> freq = new HashMap<>();
        int maxLen = Integer.MIN_VALUE, windowStart = 0;
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            freq.put(str.charAt(windowEnd), 1 + freq.getOrDefault(str.charAt(windowEnd), 0));
            while (freq.size() > k && windowStart <= windowEnd) {
                freq.put(str.charAt(windowStart), freq.getOrDefault(str.charAt(windowStart), 0) - 1);
                if (freq.getOrDefault(str.charAt(windowStart), 0) <= 0) {
                    freq.remove(str.charAt(windowStart));
                }
                windowStart++;
            }
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }
        return maxLen == Integer.MIN_VALUE ? 0: maxLen;
    }

    public static void main(String[] args) {
        int result = LongestSubstringKDistinct.findLength("araaci",2);
        System.out.println(result);
        result = LongestSubstringKDistinct.findLength("araaci",1);
        System.out.println(result);
        result = LongestSubstringKDistinct.findLength("cbbebi",3);
        System.out.println(result);
        result = LongestSubstringKDistinct.findLength("aabacbebebe", 3);
        System.out.println(result);
    }
}
