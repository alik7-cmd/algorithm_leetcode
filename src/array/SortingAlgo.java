package array;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortingAlgo {

    /**
     * Bubble sort to sort an array in ascending order
     * Time Complexity O(N^2)
     * Space Complexity O(1)
     *
     * @param arr, an integer array
     * @return sorted array in ascending order
     *
     * See https://www.geeksforgeeks.org/bubble-sort/
     */
    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            //boolean swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                // swap if next element is smaller
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    //swapped = true;
                }
            }
            //if(!swapped) break;
        }

        return arr;

    }

    public static int[] insertion(int [] arr){

        for(int i = 1; i< arr.length; i++){
            int j = i-1;
            int key = arr[i];

            while (j>= 0 && key < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }

        return arr;
    }

    /**
     * Insertion sort to sort an array in ascending order
     * Time Complexity O(n^2)
     * Space Complexity O(1)
     *
     * @param arr, an integer array
     * @return sorted array in ascending order
     * See https://www.geeksforgeeks.org/insertion-sort/?ref=leftbar-rightbar and
     * https://www.youtube.com/watch?v=OGzPmgsI-pQ
     *
     */
    public static int[] insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        return arr;

    }

    /**
     * Selection sort to sort an array in ascending order
     * Time Complexity O(n^2)
     * Space Complexity O(1)
     * @param arr, an integer array
     * @return sorted array in ascending order
     * See https://www.geeksforgeeks.org/selection-sort/
     */
    public static int [] selectionSort(int[] arr){

        for(int i = 0; i< arr.length-1;i++){
            int key = arr[i];
            int swap = i;

            for(int j = i+1; j< arr.length; j++){
                if(arr[j] < arr[swap]){
                    swap = j;
                }
            }

            int temp = arr[swap];
            arr[swap] = arr[i];
            arr[i] = temp;
        }

        return arr;
    }

    public static void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    /**
     * Merge sort to sort an array in ascending order
     * Complexity O(NLogN)
     * @param arr
     * @param l, left side of an array initially 0
     * @param r, right most point of an array initially arr.size-1
     * See https://www.geeksforgeeks.org/merge-sort/
     */
    public static void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    /**
     * Complexity O(n1+n2)
     * Space Complexity O(n1+n2)
     *
     * @param arr1
     * @param arr2
     * @return an array by merging arr1 & arr2 in ascending order
     */
    public static int[] mergeTwoSortedArray(int[] arr1, int[] arr2) {

        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0, j = 0, k = 0;
        int[] res = new int[n1 + n2];


        // Check if current element of first
        // array is smaller than current element
        // of second array. If yes, store first
        // array element and increment first array
        // index. Otherwise do same with second array
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                res[k++] = arr1[i++];
            } else {
                res[k++] = arr2[j++];
            }
        }
        // Store remaining elements of first array
        while (i < n1) {
            res[k++] = arr1[i++];
        }
        // Store remaining elements of first array
        while (j < n2) {
            res[k++] = arr2[j++];
        }

        return res;
    }

    /**
     * Complexity O(nlog(n1)+ nlog(n2))
     * Space Complexity O(n1+n2)
     * @param arr1
     * @param arr2
     * @return an array by merging arr1 & arr2 in ascending order
     */
    public static int[] mergeTwoSortedArrayUsingMap(int[] arr1, int[] arr2) {

        Map<Integer, Boolean> map = new TreeMap<>();
        int index = 0;
        int[] res = new int[arr1.length + arr2.length];

        for (int n : arr1) {
            map.put(n, true);
        }

        for (int n : arr2) {
            map.put(n, true);
        }

        for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
            res[index++] = entry.getKey();
        }

        return res;
    }

    public static void printArray(int[] arr) {
        for (int n : arr) {
            System.out.print(n+" ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, 11, 1, 7};
        printArray(insertion(arr));
    }
}
