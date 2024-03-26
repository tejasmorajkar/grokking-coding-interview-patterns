/**
 * Given an array of positive numbers and a positive number ‘S’,
 * find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’.
 * Return 0, if no such subarray exists.
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 */
package slidingwindow;

public class SmallestSubarrayWithGivenSum {
    public static int findMinSubArray(int[] nums, int sum) {
        int minLen = Integer.MAX_VALUE, windowStart = 0, windowSum = 0;
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd];
            while (windowSum >= sum) {
                minLen = Math.min(minLen, windowEnd - windowStart + 1);
                windowSum -= nums[windowStart];
                windowStart++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        int result = SmallestSubarrayWithGivenSum.findMinSubArray(new int[]{2, 1, 5, 2, 3, 2}, 7);
        System.out.println(result);
        result = SmallestSubarrayWithGivenSum.findMinSubArray(new int[]{2, 1, 5, 2, 8}, 7);
        System.out.println(result);
        result = SmallestSubarrayWithGivenSum.findMinSubArray(new int[]{3, 4, 1, 1, 6}, 8);
        System.out.println(result);
    }
}
