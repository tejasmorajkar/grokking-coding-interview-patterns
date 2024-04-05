/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/description/
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted in non-decreasing order.
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 */
package two_pointers;

import java.util.Arrays;

public class SquaringSortedArray {
    private static int[] makeSquares(int[] nums) {
        int n = nums.length;
        int[] squares = new int[n];
        int left = 0, right = n - 1, highestNumIndex = n - 1;
        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            if (leftSquare > rightSquare) {
                squares[highestNumIndex--] = leftSquare;
                left++;
            } else {
                squares[highestNumIndex--] = rightSquare;
                right--;
            }
        }
        return squares;
    }

    public static void main(String[] args) {
        int[] result = makeSquares(new int[]{-2, -1, 0, 2, 3});
        System.out.println(Arrays.toString(result));
        result = makeSquares(new int[]{-3, -1, 0, 1, 2});
        System.out.println(Arrays.toString(result));
    }
}
