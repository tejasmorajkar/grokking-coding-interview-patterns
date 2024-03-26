/**
 * https://leetcode.com/problems/3sum-closest/description/
 * Given an integer array nums of length n and an integer target,
 * find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
package TwoPointers;

import java.util.Arrays;

public class TripletSumClosestToTarget {
    private static int searchTriplet(int[] nums, int target) {
        int n = nums.length;
        int smallestDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;
            while (left < right) {
                int currDiff = target - (nums[i] + nums[left] + nums[right]);
                if (currDiff == 0)
                    return target - currDiff;
                if (currDiff > 0)
                    left++;
                else
                    right--;
                if (Math.abs(currDiff) < Math.abs(smallestDiff) ||
                        (Math.abs(currDiff) == Math.abs(smallestDiff) && currDiff > smallestDiff))
                    smallestDiff = currDiff;
            }
        }
        return target - smallestDiff;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,1,-4};
        int target = 1;
        int result = searchTriplet(nums, target);
        System.out.println(result);
        int[] nums2 = new int[]{0,0,0};
        int target2 = 1;
        int result2 = searchTriplet(nums2, target2);
        System.out.println(result2);
    }
}
