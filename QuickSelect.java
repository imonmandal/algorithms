public class QuickSelelct {
    public static int kthSmallest(int[] arr, int k) {
        return quickSelect(arr, 0, arr.length - 1, k - 1);
    }

    private static int quickSelect(int[] arr, int low, int high, int k) {
        if (low == high) return arr[low];

        int pivotIndex = partition(arr, low, high);

        if (k == pivotIndex) return arr[k];
        else if (k < pivotIndex) return quickSelect(arr, low, pivotIndex - 1, k);
        else return quickSelect(arr, pivotIndex + 1, high, k);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, i, high);
        return i;
    }

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
