public class Kadane {
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
