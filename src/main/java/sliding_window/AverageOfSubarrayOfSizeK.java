/**
 *  Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
 *  Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
 *  Output: [2.2, 2.8, 2.4, 3.6, 2.8]
 */

package sliding_window;

import java.util.Arrays;

public class AverageOfSubarrayOfSizeK {
    // Time complexity: O(n)
    // Space complexity: O(1) (Ignore result array)
    public static double[] findAverages(int[] nums, int k) {
        int len = nums.length, windowSum = 0, windowStart = 0;
        double[] averages = new double[len - k + 1];
        for (int windowEnd = 0; windowEnd < len; windowEnd++) {
            windowSum += nums[windowEnd];
            if (windowEnd >= k - 1) {
                averages[windowStart] = (double)windowSum/k;
                windowSum -= nums[windowStart];
                windowStart++;
            }
        }
        return averages;
    }

    public static void main(String[] args) {
        double[] result = AverageOfSubarrayOfSizeK.findAverages(new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2} , 5);
        System.out.println(Arrays.toString(result));
    }
}
