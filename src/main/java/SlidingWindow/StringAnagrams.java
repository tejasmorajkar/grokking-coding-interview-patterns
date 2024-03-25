/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s.
 * You may return the answer in any order.
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 */

package SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringAnagrams {
    private static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> result = new ArrayList<>();
        int[] patternMap = new int[26];
        for (int i = 0; i < pattern.length(); i++)  patternMap[pattern.charAt(i) - 'a']++;
        int[] currMap = new int[26];
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            currMap[str.charAt(windowEnd) - 'a']++;
            if (windowEnd >= pattern.length() - 1) {
                if (Arrays.equals(patternMap, currMap))
                    result.add(windowStart);
                currMap[str.charAt(windowStart) - 'a']--;
                windowStart++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = findStringAnagrams("ppqp", "pq");
        System.out.println(result);
        result = findStringAnagrams("abbcabc", "abc");
        System.out.println(result);
    }
}
