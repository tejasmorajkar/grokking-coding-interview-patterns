package twopointers;

public class RemoveDuplicates {
    /**
     * Given an array of sorted numbers, remove all duplicates from it.
     * You should not use any extra space; after removing the duplicates in-place return the new length of the array.
     * Input: [2, 3, 3, 3, 6, 9, 9]
     * Output: 4
     * Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
     */
    private static int remove(int[] arr) {
        int nonDuplicateCount = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[nonDuplicateCount - 1] != arr[i]) {
                arr[nonDuplicateCount] = arr[i];
                nonDuplicateCount++;
            }
        }
        return nonDuplicateCount;
    }

    /**
     * Given an unsorted array of numbers and a target ‘key’, remove all instances of ‘key’ in-place and
     * return the new length of the array.
     * Input: [3, 2, 3, 6, 3, 10, 9, 3], Key=3
     * Output: 4
     * Explanation: The first four elements after removing every 'Key' will be [2, 6, 10, 9].
     */
    private static int removeKey(int[] arr, int key) {
        int nextElement = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != key) {
                arr[nextElement] = arr[i];
                nextElement++;
            }
        }
        return nextElement;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 3, 3, 6, 9, 9};
        int result = remove(nums);
        System.out.println(result);
        nums = new int[] {2, 2, 2, 11};
        result = remove(nums);
        System.out.println(result);

        nums = new int[]{3, 2, 3, 6, 3, 10, 9, 3};
        result = removeKey(nums, 3);
        System.out.println(result);
        nums = new int[]{2, 11, 2, 2, 1};
        result = removeKey(nums, 2);
        System.out.println(result);
    }
}
