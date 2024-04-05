/**
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/
 * You are given a string s and an array of strings words. All the strings of words are of the same length.
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Since words.length == 2 and words[i].length == 3, the concatenated substring has to be of length 6.
 * The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
 * The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.
 * The output order does not matter. Returning [9,0] is fine too.
 */

package sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class WordsConcatenation {
    // TC: O(n * m)
    // SC: O(n + m)
    // n: len(str), m: len(words)
    private static List<Integer> findWordConcatenation(String str, String[] words) {
        Map<String, Integer> wordFreq = new HashMap<>();
        for (String word: words)
            wordFreq.put(word, 1 + wordFreq.getOrDefault(word, 0));
        int wordLen = words[0].length(), wordCount = words.length;
        List<Integer> result = new ArrayList<>();
        for (int windowStart = 0; windowStart <= str.length() - wordCount * wordLen; windowStart++) {
            Map<String, Integer> seenFreq = new HashMap<>();
            for (int wordIndex = 0; wordIndex < wordCount; wordIndex++) {
                int nextWordStartIndex = windowStart + wordIndex * wordLen;
                String word = str.substring(nextWordStartIndex, nextWordStartIndex + wordLen);
                if (!wordFreq.containsKey(word))
                    break;
                seenFreq.put(word, 1 + seenFreq.getOrDefault(word, 0));
                if (seenFreq.get(word) > wordFreq.getOrDefault(word, 0))
                    break;
                if (wordIndex + 1 == wordCount)
                    result.add(windowStart);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = findWordConcatenation("catfoxcat", new String[]{"cat", "fox"});
        System.out.println(result);
        result = findWordConcatenation("catcatfoxfox", new String[]{"cat", "fox"});
        System.out.println(result);
    }
}
