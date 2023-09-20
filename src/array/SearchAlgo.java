package array;

public class SearchAlgo {

    /**
     * Linear Search to find a key inside an array
     * Complexity O(N)
     * @param arr
     * @param key
     * @return first index of the key, and if the key is not present return -1
     */
    public static int linearSearch(int [] arr, int key){
        for(int i = 0; i< arr.length; i++){
            if(arr[i] == key) return i;
        }
        return -1;
    }

    /**
     * Binary Search to find a key inside an array
     * Complexity O(LogN).
     * @param arr
     * @param key
     * @return first index of the key, and if the key is not present return -1
     */
    public static int binarySearch(int [] arr, int key){

        int start = 0;
        int end = arr.length-1;

        while (start <= end){
            int mid = start + (end-start)/2;

            if(key == arr[mid]) return mid;

            if(key > arr[mid]) start = mid+1;

            else end = mid-1;
        }

        return -1;

    }

    public static void main (String [] args){
        int [] arr = {15,21,9,5,4,1};
        System.out.println(binarySearch(arr, 9));
        //System.out.println(Math.pow(2,3));
    }
}
