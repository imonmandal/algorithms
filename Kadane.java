public class Kadane {
    /**
     * Kadane's Algorithm to find maximum sum subarray with indices
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    static int[] maxSumSubarray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        int maxSum = arr[0];
        int currentSum = arr[0];
        int start = 0;
        int end = 0;
        int tempStart = 0;

        for (int i = 1; i < arr.length; i++) {
            // Decide whether to start a new subarray or extend the existing one
            if (currentSum + arr[i] > arr[i]) {
                currentSum += arr[i];
            } else {
                currentSum = arr[i];
                tempStart = i;
            }

            // Update maxSum and indices if we found a better solution
            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }

        return new int[]{start, end, maxSum};
    }

    static int maxSubarraySum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int elem : arr) {
            sum += elem;
            maxSum = Math.max(maxSum, sum);

            if (sum < 0) {
                // Not to carry negative sum becoz it will decrease the value further
                // Only positive value will maximize the sum
                sum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxSubarraySum(arr));
    }
}
