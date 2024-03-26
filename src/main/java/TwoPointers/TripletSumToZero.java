/**
 * https://leetcode.com/problems/3sum/
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 */
package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {
    private static List<List<Integer>> searchTriplets(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int idx = 0; idx < arr.length - 2; idx++) {
            if (idx > 0 && arr[idx] == arr[idx - 1])
                continue;
            searchPairsWithTargetSum(arr, -arr[idx], idx + 1, triplets);
        }
        return triplets;
    }

    private static void searchPairsWithTargetSum(int[] arr, int targetSum, int left, List<List<Integer>> triplets) {
        int right = arr.length - 1;
        while (left < right) {
            int currSum = arr[left] + arr[right];
            if (currSum == targetSum) {
                triplets.add(new ArrayList<>(Arrays.asList(-targetSum, arr[left], arr[right])));
                left++;
                right--;
                while (left < right && arr[left] == arr[left - 1])
                    left++;
                while (left < right && arr[right] == arr[right + 1])
                    right--;
            } else if (currSum > targetSum) {
                right--;
            } else  {
                left++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-3, 0, 1, 2, -1, 1, -2};
        List<List<Integer>> result = searchTriplets(nums);
        System.out.println(result);
    }
}
