package modified_binary_search;

public class MinDiffElement {
	private static int searchMinDiffElement(int[] arr, int key) {
		int n = arr.length;
		if (key < arr[0]) {
			return arr[0];
		}
		if (key > arr[n - 1]) {
			return arr[n - 1];
		}
		int start = 0, end = n - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] > key) {
				end = mid - 1;
			} else if (arr[mid] < key) {
				start = mid + 1;
			} else {
				return arr[mid];
			}
		}
		if (arr[start] - key < key - arr[end]) {
			return arr[start];
		}
		return arr[end];
	}

	public static void main(String[] args) {
		int result = searchMinDiffElement(new int[] { 4, 6, 10 }, 7);
		System.out.println(result);
		result = searchMinDiffElement(new int[] { 4, 6, 10 }, 4);
		System.out.println(result);
		result = searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12);
		System.out.println(result);
		result = searchMinDiffElement(new int[] { 4, 6, 10 }, 17);
		System.out.println(result);
	}
}
