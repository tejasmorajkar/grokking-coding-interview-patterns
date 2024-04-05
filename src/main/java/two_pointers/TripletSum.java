package two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSum {
	public static List<List<Integer>> findTriplets(int[] nums, int target) {
		List<List<Integer>> triplets = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1, right = nums.length - 1;
			while (i > 0 && i < nums.length && nums[i] == nums[i - 1]) {
				i++;
			}
			int targetSum = target - nums[i];
			while (left < right && left < nums.length) {
				while (left > 0 && left - 1 > i && nums[left] == nums[left - 1]) {
					left++;
				}
				while (right + 1 < nums.length && right > i && nums[right] == nums[right + 1]) {
					right--;
				}
				int currSum = nums[left] + nums[right];
				if (currSum == targetSum) {
					triplets.add(Arrays.asList(nums[i], nums[left], nums[right]));
					left++;
					right--;
				} else if (currSum < targetSum) {
					left++;
				} else {
					right--;
				}
			}
		}
		return triplets;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { -1, 0, 1, 2, -1, -4 };
		int target = 0;
		List<List<Integer>> triplets = findTriplets(nums, target);
		System.out.println(triplets);
	}

}
