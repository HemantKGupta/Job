package basic;

/**
 * Find the Rotation Count in Rotated Sorted array
 * https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
 *
 * Consider an array of distinct numbers sorted in increasing order.
 * The array has been rotated (clockwise) k number of times.
 * Given such an array, find the value of k.
 */

public class AB16FindRotationCount {
    public static void main(String[] args) {

    }

    // Returns count of rotations for an array
    // which is first sorted in ascending order,
    // then rotated
    public static int countRotations(int arr[], int low, int high){
        // This condition is needed to handle
        // the case when array is not rotated
        // at all
        if (high < low)
            return 0;

        // If there is only one element left
        if (high == low)
            return low;

        // Find mid
        // /*(low + high)/2;*/
        int mid = low + (high - low)/2;

        // Check if element (mid+1) is minimum
        // element. Consider the cases like
        // {3, 4, 5, 1, 2}
        if (mid < high && arr[mid+1] < arr[mid])
            return (mid + 1);

        // Check if mid itself is minimum element
        if (mid > low && arr[mid] < arr[mid - 1])
            return mid;

        // Decide whether we need to go to left
        // half or right half
        if (arr[high] > arr[mid])
            return countRotations(arr, low, mid - 1);

        return countRotations(arr, mid + 1, high);
    }
}
