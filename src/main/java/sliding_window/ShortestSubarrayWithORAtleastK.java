package sliding_window;

import java.util.Arrays;

public class ShortestSubarrayWithORAtleastK {
	private static void fill(int[] bits, int num) {
		int idx = 0;
		while (num > 0) {
			bits[idx++] += num & 1;
			num /= 2;
		}
	}
	
	private static void remove(int[] bits, int num) {
		int idx = 0;
		while (num > 0) {
			bits[idx++] -= num & 1;
			num /= 2;
		}
	}
	
	private static boolean isBigger(int[] bits, int[] target) {
		for (int idx = 31; idx >= 0; idx--) {
			if ((bits[idx] != 0 && target[idx] != 0) ||
				(bits[idx] == 0 && target[idx] == 0))
				continue;
			return bits[idx] != 0;
		}
		return true;
	}
	
	public static int minimumSubarrayLength(int[] nums, int k) {
		if (k == 0) return 1;
		int n = nums.length;
		int result = n + 1, windowStart = 0;
		int[] bits = new int[32];
		int[] target = new int[32];
		fill(target, k);
		for (int windowEnd = 0; windowEnd < n; windowEnd++) {
			fill(bits, nums[windowEnd]);
			while (isBigger(bits, target)) {
				result = Math.min(result, windowEnd - windowStart + 1);
				remove(bits, nums[windowStart++]);
			}			
		}
		return result > n ? -1 : result;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3};
		int k = 2;
		int result = minimumSubarrayLength(nums, k);
		System.out.println(result);
		
		nums = new int[]{2,1,8};
		k = 10;
		result = minimumSubarrayLength(nums, k);
		System.out.println(result);
		
		nums = new int[]{1,2};
		k = 0;
		result = minimumSubarrayLength(nums, k);
		System.out.println(result);
	}

}
