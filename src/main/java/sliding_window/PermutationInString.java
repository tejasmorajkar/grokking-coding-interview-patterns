/**
 * https://leetcode.com/problems/permutation-in-string/description/
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 */

package sliding_window;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    // TC: O(n)
    // SC: O(1)
    private static boolean findPermutation(String str, String pattern) {
        int[] mp = new int[26];
        for (int i = 0; i < pattern.length(); i++) mp[pattern.charAt(i) - 'a']++;
        int[] curr = new int[26];
        boolean result = false;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            curr[str.charAt(windowEnd) - 'a']++;
            if (windowEnd >= pattern.length() - 1) {
                if (Arrays.equals(curr, mp)) {
                    result = true;
                    break;
                }
                curr[str.charAt(windowStart) - 'a']--;
                windowStart++;
            }
        }
        return result;
    }

    // Using a single map for pattern and then tracking matches
    // TC: O(n)
    // SC: O(1)
    private static boolean findPermutation2(String str, String pattern) {
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (char ch : pattern.toCharArray())
            charFreqMap.put(ch, charFreqMap.getOrDefault(ch, 0) + 1);
        int windowStart = 0, match = 0;
        boolean result = false;
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (charFreqMap.containsKey(rightChar)) {
                charFreqMap.put(rightChar, charFreqMap.get(rightChar) - 1);
                if (charFreqMap.get(rightChar) == 0)
                    match++;
            }
            if (match == charFreqMap.size()) {
                result = true;
                break;
            }
            if (windowEnd >= pattern.length() - 1) {
                char leftChar = str.charAt(windowStart);
                if (charFreqMap.containsKey(leftChar)) {
                    if (charFreqMap.get(leftChar) == 0)
                        match--;
                    charFreqMap.put(leftChar, charFreqMap.get(leftChar) + 1);
                }
                windowStart++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        boolean result = PermutationInString.findPermutation("oidbcaf", "abc");
        System.out.println(result);
        result = PermutationInString.findPermutation("odicf", "dc");
        System.out.println(result);
        result = PermutationInString.findPermutation2("bcdxabcdy", "bcdyabcdx");
        System.out.println(result);
        result = PermutationInString.findPermutation2("aaacb", "abc");
        System.out.println(result);
    }
}
