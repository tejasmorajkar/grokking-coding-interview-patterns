package SlidingWindow;

public class LongestSubstringWithOnesAfterReplacement {
    private static int findLength(int[] arr, int k) {
        int[] digitFreqMap = new int[2];
        int windowLen = 0, windowStart = 0, maxCount = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            digitFreqMap[arr[windowEnd]]++;
            maxCount = Math.max(maxCount, digitFreqMap[arr[windowEnd]]);
            while (windowEnd - windowStart + 1 - maxCount > k) {
                digitFreqMap[arr[windowStart]]--;
                windowStart++;
            }
            windowLen = Math.max(windowLen, windowEnd - windowStart + 1);
        }
        return windowLen;
    }

    public static void main(String[] args) {
        int result = LongestSubstringWithOnesAfterReplacement.
                findLength(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2);
        System.out.println(result);
        result = LongestSubstringWithOnesAfterReplacement.
                findLength(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3);
        System.out.println(result);
    }
}
