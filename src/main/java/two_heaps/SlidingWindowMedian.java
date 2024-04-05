package two_heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

// Using 2 TreeSets
// TC: O(n * log(k))
// SC: O(k)
class Solution2 {
	private void balance(TreeSet<Integer> left, TreeSet<Integer> right) {
		while (right.size() < left.size()) {
			right.add(left.pollFirst());
		}
	}

	private double getMedian(int[] nums, int k, TreeSet<Integer> left, TreeSet<Integer> right) {
		if (k % 2 == 0) {
			return nums[left.first()] / 2.0 + nums[right.first()] / 2.0;
		} else {
			return nums[right.first()];
		}
	}

	public double[] medianSlidingWindow(int[] nums, int k) {
		Comparator<Integer> comparator = new Comparator<>() {
			public int compare(Integer a, Integer b) {
				if (nums[a] != nums[b]) {
					return Integer.compare(nums[a], nums[b]);
				} else {
					return a - b;
				}
			}
		};
		TreeSet<Integer> left = new TreeSet<>(comparator.reversed());
		TreeSet<Integer> right = new TreeSet<>(comparator);
		int n = nums.length;
		double[] medians = new double[n - k + 1];
		for (int idx = 0; idx < k; idx++) {
			left.add(idx);
		}
		balance(left, right);
		medians[0] = getMedian(nums, k, left, right);
		int medianIdx = 1;
		for (int idx = k; idx < n; idx++) {
			if (!left.remove(idx - k)) {
				right.remove(idx - k);
			}
			right.add(idx);
			left.add(right.pollFirst());
			balance(left, right);
			medians[medianIdx++] = getMedian(nums, k, left, right);
		}
		return medians;
	}
}

public class SlidingWindowMedian {
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		double[] result = new Solution2().medianSlidingWindow(nums, k);
		System.out.println(Arrays.toString(result));
		nums = new int[] { 1, 2, 3, 4, 2, 3, 1, 4, 2 };
		k = 3;
		result = new Solution2().medianSlidingWindow(nums, k);
		System.out.println(Arrays.toString(result));
	}
}
