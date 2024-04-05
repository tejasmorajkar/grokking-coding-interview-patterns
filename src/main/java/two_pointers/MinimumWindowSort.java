package two_pointers;

public class MinimumWindowSort {
    private static int findUnsortedSubarray(int[] nums) {
            int n = nums.length;
            int low = 0, high = n - 1;
            while (low < n - 1 && nums[low] <= nums[low + 1])
                low++;
            if (low == n - 1)
                return 0;
            while (high > 0 && nums[high] >= nums[high - 1])
                high--;
            int subarrayMin = Integer.MAX_VALUE, subarrayMax = Integer.MIN_VALUE;
            for (int i = low; i <= high; i++) {
                subarrayMin = Math.min(subarrayMin, nums[i]);
                subarrayMax = Math.max(subarrayMax, nums[i]);
            }
            while (low > 0 && nums[low - 1] > subarrayMin)
                low--;
            while (high < n - 1 && nums[high + 1] < subarrayMax)
                high++;
            return high - low + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,6,4,8,10,9,15};
        int length = findUnsortedSubarray(nums);
        System.out.println(length);
        nums = new int[]{1,2,3,4};
        length = findUnsortedSubarray(nums);
        System.out.println(length);
    }
}
