/**
 * Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
 * Input: [1, 2, 3, 4, 6], target=6
 * Output: [1, 3]
 * Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
 */
package two_pointers;

import java.util.Arrays;

public class PairWithTargetSum {
    private static int[] search(int[] arr, int targetSum) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int currSum = arr[left] + arr[right];
            if (currSum < targetSum) {
                left++;
            } else if (currSum > targetSum) {
                right--;
            } else {
                return new int[]{left, right};
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] result = search(new int[]{1, 2, 3, 4, 6}, 6);
        System.out.println(Arrays.toString(result));
        result = search(new int[]{2, 5, 9, 11}, 11);
        System.out.println(Arrays.toString(result));
    }
}
