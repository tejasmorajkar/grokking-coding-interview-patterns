/**
 * https://leetcode.com/problems/minimum-window-substring/description/
 * Given two strings s and t of lengths m and n respectively, return the minimum window
 * substring of s such that every character in t (including duplicates) is included in the window.
 * If there is no such substring, return the empty string "".
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 */

package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {
    private static String findSubstring(String str, String pattern) {
        Map<Character, Integer> letterFreqMap = new HashMap<>();
        int windowStart = 0, minWindowStart = 0, minWindowLen = str.length() + 1, matchCount = 0;
        for (char ch: pattern.toCharArray())
            letterFreqMap.put(ch, 1 + letterFreqMap.getOrDefault(ch, 0));
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (letterFreqMap.containsKey(rightChar)) {
                letterFreqMap.put(rightChar, letterFreqMap.get(rightChar) - 1);
                if (letterFreqMap.get(rightChar) >= 0)
                    matchCount++;
            }
            while (matchCount == pattern.length()) {
                if (windowEnd - windowStart + 1 < minWindowLen) {
                    minWindowLen = windowEnd - windowStart + 1;
                    minWindowStart = windowStart;
                }
                char leftChar = str.charAt(windowStart);
                if (letterFreqMap.containsKey(leftChar)) {
                    if (letterFreqMap.get(leftChar) == 0)
                        matchCount--;
                    letterFreqMap.put(leftChar, letterFreqMap.get(leftChar) + 1);
                }
                windowStart++;
            }
        }
        return minWindowLen > str.length() ? "" :
                str.substring(minWindowStart, minWindowStart + minWindowLen);
    }

    public static void main(String[] args) {
        String result = findSubstring("aabdec", "abc");
        System.out.println(result);
        result = findSubstring("abdabca", "abc");
        System.out.println(result);
        result = findSubstring("adcad", "abc");
        System.out.println(result);
    }
}
