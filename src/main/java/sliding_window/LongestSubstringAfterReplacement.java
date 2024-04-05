/**
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 * Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter,
 * find the length of the longest substring having the same letters after replacement.
 *
 * Input: String="aabccbb", k=2
 * Output: 5
 * Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
 *
 * Input: String="abbcb", k=1
 * Output: 4
 * Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".
 */
package sliding_window;

public class LongestSubstringAfterReplacement {
    private static int findLength(String s, int k) {
        int[] letterFreqMap = new int[26];
        int windowLen = 0, windowStart = 0, maxCount = 0;
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            int rightChar = letterFreqMap[s.charAt(windowEnd) - 'A'];
            rightChar++;
            maxCount = Math.max(maxCount, rightChar);
            while (windowEnd - windowStart + 1 - maxCount > k) {
                letterFreqMap[s.charAt(windowStart) - 'A']--;
                windowStart++;
            }
            windowLen = Math.max(windowLen, windowEnd - windowStart + 1);
        }
        return windowLen;
    }

    public static void main(String[] args) {
        int result = LongestSubstringAfterReplacement.findLength("aabccbb", 2);
        System.out.println(result);
        result = LongestSubstringAfterReplacement.findLength("abbcb", 1);
        System.out.println(result);
        result = LongestSubstringAfterReplacement.findLength("abccde", 1);
        System.out.println(result);
    }
}
