package modified_binary_search;

public class SearchInInfiniteSortedArray {
	static class ArrayReader {
		int[] arr;

		public ArrayReader(int[] arr) {
			this.arr = arr;
		}

		public int get(int index) {
			if (index >= arr.length) {
				return Integer.MAX_VALUE;
			}
			return arr[index];
		}
	}

	private static int binarySearch(int key, ArrayReader ar, int start, int end) {
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (ar.get(mid) > key) {
				end = mid - 1;
			} else if (ar.get(mid) < key) {
				start = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	private static int findIndex(int key, ArrayReader ar) {
		int start = 0, end = 1;
		while (ar.get(end) < key) {
			start = end;
			end = end * 2;
		}
		return binarySearch(key, ar, start, end);
	}

	public static void main(String[] args) {
		int[] arr = { 9, 11, 17, 26, 37, 52, 89, 111, 129, 144, 198 };
		ArrayReader ar = new ArrayReader(arr);
		int result = findIndex(89, ar);
		System.out.println(result);
		result = findIndex(130, ar);
		System.out.println(result);
		result = findIndex(198, ar);
		System.out.println(result);
	}

}
