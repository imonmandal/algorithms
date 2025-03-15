public class QuickSelelct {
     /**
     * Find the kth smallest element in the array.
     *
     * @param arr The input array
     * @param k   The position of the element to find (1-indexed)
     * @return The kth smallest element
     */
    public static int kthSmallest(int[] arr, int k) {
        // Convert to 0-indexed for internal implementation
        return quickSelect(arr, 0, arr.length - 1, k - 1);
    }

    /**
     * Core QuickSelect algorithm implementation.
     * Works by recursively partitioning the array and only exploring the partition
     * that contains the kth element.
     *
     * @param arr  The input array
     * @param low  Starting index of the current subarray
     * @param high Ending index of the current subarray
     * @param k    The position to find (0-indexed)
     * @return The element at the kth position
     */
    private static int quickSelect(int[] arr, int low, int high, int k) {
        // Base case: if the subarray has only one element
        if (low == high) return arr[low];

        // Partition the array and get the pivot index
        int pivotIndex = partition(arr, low, high);

        // Three cases:
        if (k == pivotIndex) {
            // 1. We found the kth element (lucky!)
            return arr[k];
        } else if (k < pivotIndex) {
            // 2. The kth element is in the left subarray
            return quickSelect(arr, low, pivotIndex - 1, k);
        } else {
            // 3. The kth element is in the right subarray
            return quickSelect(arr, pivotIndex + 1, high, k);
        }
    }

    /**
     * Rearranges elements in the array so that:
     * - Elements <= pivot are on the left side
     * - Elements > pivot are on the right side
     * Uses the rightmost element as the pivot.
     *
     * @param arr  The array to partition
     * @param low  Starting index of the partition range
     * @param high Ending index of the partition range
     * @return The final position of the pivot element
     */
    private static int partition(int[] arr, int low, int high) {
        // Choose the rightmost element as the pivot
        int pivot = arr[high];

        // i tracks the boundary between elements <= pivot and > pivot
        int i = low;

        // Process all elements except the pivot
        for (int j = low; j < high; j++) {
            // If current element is <= pivot, move it to the left side
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++; // Advance the boundary
            }
        }

        // Place the pivot in its correct sorted position
        swap(arr, i, high);

        // Return the pivot's final position
        return i;
    }

    /**
     * Swaps two elements in an array.
     *
     * @param arr The array containing elements to swap
     * @param i   Index of first element
     * @param j   Index of second element
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // Test your implementation
        int[] arr = { 7, 10, 4, 3, 20, 15 };
        int k = 3;
        System.out.println(kthSmallest(arr, k)); // Output: 7
    }
}
