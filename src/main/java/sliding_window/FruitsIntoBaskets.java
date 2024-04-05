/**
 * https://leetcode.com/problems/fruit-into-baskets/description/
 * Problem Statement #
 * Given an array of characters where each character represents a fruit tree, you are given two baskets and your goal is to put maximum number of fruits in each basket.
 * The only restriction is that each basket can have only one type of fruit.
 * You can start with any tree, but once you have started you can’t skip a tree.
 * You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.
 * Write a function to return the maximum number of fruits in both the baskets.
 * Input: Fruit=['A', 'B', 'C', 'A', 'C']
 * Output: 3
 * Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
 */
package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBaskets {
    // Time complexity: O(n)
    // Space complexity: O(1)
    private static int findLength(char[] arr) {
        Map<Character, Integer> freq = new HashMap<>();
        int windowLen = Integer.MIN_VALUE, windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            freq.put(arr[windowEnd], freq.getOrDefault(arr[windowEnd], 0) + 1);
            while (freq.size() > 2 && windowStart <= windowEnd) {
                freq.put(arr[windowStart], freq.getOrDefault(arr[windowStart], 0) - 1);
                if (freq.getOrDefault(arr[windowStart], 0) <= 0)
                    freq.remove(arr[windowStart]);
                windowStart++;
            }
            windowLen = Math.max(windowLen, windowEnd - windowStart + 1);
        }
        return windowLen == Integer.MIN_VALUE ? 0: windowLen;
    }
    public static void main(String[] args) {
        int result = FruitsIntoBaskets.findLength(new char[]{'A', 'B', 'C', 'A', 'C'});
        System.out.println(result);
        result = FruitsIntoBaskets.findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'});
        System.out.println(result);
    }
}
