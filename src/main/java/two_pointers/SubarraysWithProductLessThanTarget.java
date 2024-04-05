/**
 * Given an array with positive numbers and a target number,
 * find all of its contiguous subarrays whose product is less than the target number.
 * Input: [2, 5, 3, 10], target=30
 * Output: [2], [5], [2, 5], [3], [5, 3], [10]
 * Explanation: There are six contiguous subarrays whose product is less than the target.
 */

package two_pointers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubarraysWithProductLessThanTarget {
    private static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> subarrays = new ArrayList<>();
        int product = 1, left = 0;
        for (int right = 0; right < arr.length; right++) {
            product *= arr[right];
            while (product >= target && left <= right) {
                product /= arr[left++];
            }
            List<Integer> subList = new LinkedList<>();
            for (int idx = right; idx >= left; idx--) {
                subList.add(0, arr[idx]);
                subarrays.add(subList);
            }
        }
        return subarrays;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 3, 10};
        int target = 30;
        List<List<Integer>> result = findSubarrays(arr, target);
        System.out.println(result);
        int[] arr2 = new int[]{8, 2, 6, 5};
        int target2 = 50;
        List<List<Integer>> result2 = findSubarrays(arr2, target2);
        System.out.println(result2);
    }
}
