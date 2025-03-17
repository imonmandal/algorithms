public class Kadane {
    /**
     * Kadane's Algorithm to find maximum sum subarray with indices
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    static int[] maxSubarraySum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        int tempStart = 0, start = 0, end = 0;

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];

            if (currSum > maxSum) {
                maxSum = currSum;
                start = tempStart;
                end = i;
            }

            if (currSum < 0) {
                // Not to carry negative sum becoz it will decrease the value further
                // Only positive value will maximize the sum
                currSum = 0;
                tempStart = i + 1; // Start from next element
            }
        }

        return new int[]{start, end, maxSum};
    }

    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int[] result = maxSubarraySum(arr);
        System.out.println("Start Index: " + result[0]);
        System.out.println("End Index: " + result[1]);
        System.out.println("Maximum Sum: " + result[2]);
    }
}
