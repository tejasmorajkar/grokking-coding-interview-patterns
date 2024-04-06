package modified_binary_search;

public class BitonicArrayMax {
	private static int findMax(int[] nums) {
		int start = 0, end = nums.length - 1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] < nums[mid + 1]) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return nums[start];
	}

	public static void main(String[] args) {
		int result = findMax(new int[] { 1, 3, 8, 12, 4, 2 });
		System.out.println(result);
		result = findMax(new int[] { 3, 8, 3, 1 });
		System.out.println(result);
		result = findMax(new int[] { 1, 3, 8, 12 });
		System.out.println(result);
		result = findMax(new int[] { 10, 9, 8 });
		System.out.println(result);
	}
}
