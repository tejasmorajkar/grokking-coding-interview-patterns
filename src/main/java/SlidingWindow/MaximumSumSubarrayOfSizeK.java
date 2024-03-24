/**
 * Given an array of positive numbers and a positive number ‘k’,
 * find the maximum sum of any contiguous subarray of size ‘k’.
 * Input: [2, 1, 5, 1, 3, 2], k=3
 * Output: 9
 * Explanation: Subarray with maximum sum is [5, 1, 3].
 */

package SlidingWindow;

public class MaximumSumSubarrayOfSizeK {
    // Time complexity: O(n)
    // Space complexity: O(1)
    private static int maxSubArrayOfSizeK(int[] nums, int k) {
        int windowSum = 0, maxSum = Integer.MIN_VALUE, windowStart = 0;
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++ ) {
            windowSum += nums[windowEnd];
            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= nums[windowStart];
                windowStart++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int result = MaximumSumSubarrayOfSizeK.maxSubArrayOfSizeK(new int[]{2, 1, 5, 1, 3, 2} , 3);
        System.out.println(result);
        result = MaximumSumSubarrayOfSizeK.maxSubArrayOfSizeK(new int[]{2, 3, 4, 1, 5}, 2);
        System.out.println(result);
    }
}
