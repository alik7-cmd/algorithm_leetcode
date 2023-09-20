package problem;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Problem {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ll = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int start = i + 1;
            int end = nums.length - 1;

            int sum = a + nums[start] + nums[end];
            if (sum == 0) {
                List<Integer> lisOfNum = new ArrayList<>();
                lisOfNum.add(nums[i]);
                lisOfNum.add(nums[start]);
                lisOfNum.add(nums[end]);
                ll.add(Arrays.asList(nums[i], nums[start], nums[end]));
            }

            if (sum > 0) {
                end--;
            } else {
                start++;
            }
        }
        return ll;
    }

    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int sum = a + nums[start] + nums[end];

                if (Math.abs(target - sum) < Math.abs(target - res)) {
                    res = sum;
                }

                if (sum > target) end--;
                else start++;
            }


        }

        return res;

    }

    public static int climbStairs(int n) {

        if (n == 1 || n == 2) return n;

        int a = 1;
        int b = 2;
        int c = 0;

        for (int i = 2; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;

    }

    public static void rotate(int[] nums, int k) {

        int n = nums.length;
        int[] res = new int[n];
        k = k % n;

        for (int i = 0; i < n; i++) {

            if (i < k) {
                res[i] = nums[n + i - k];
            } else {
                res[i] = nums[i - k];
            }
        }

        int index = 0;

        for (int num : res) {
            System.out.print(num + " ");
            nums[index] = num;
            index++;
        }

    }

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) return true;
        }

        return false;

    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }

        return 1;
    }

    /*public int[] twoSum(int[] nums, int target) {

        int[] arr = new int[2];

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    arr[0] = i;
                    arr[1] = j;
                }
            }
        }

        return arr;

    }*/

    public static int append5AndGetMax(int num) {
        int k = 5;
        String n = String.valueOf(num);
        StringBuilder builder = new StringBuilder();
        int index = 0;
        int len = n.length();

        while (index < len && k <= n.charAt(index) - '0') {
            builder.append(n.charAt(index));
            index++;
        }

        builder.append(k);

        while (index < len) {
            builder.append(n.charAt(index));
            index++;
        }

        return Integer.parseInt(builder.toString().trim());
    }

    public static String findPhoneNumber(String[] A, String[] B, String P) {

        TreeSet<String> set = new TreeSet<>();

        for (int i = 0; i < B.length; i++) {
            if (B[i].contains(P)) {
                set.add(A[i]);
            }
        }

        if (set.isEmpty()) return "Nothing found";

        return set.first();
    }

    public static int calculateSumOfAllTwoDigitInt(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            if (num > 9 && num < 100) {
                sum += num;
            }
        }
        return sum;
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];

            }
        }

        return i + 1;
    }

    public static int[] productWithoutSelf(int[] arr) {
        int[] res = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int mul = 1;
            for (int j = 0; j < arr.length; j++) {
                if (i != j) {
                    mul = mul * arr[j];
                }

            }
            res[i] = mul;
        }

        return res;
    }

    public static int countNoOfPalindromes(String s) {
        int count = s.length();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j++) {
                String ss = s.substring(i, j);
                String rev = new StringBuilder(ss).reverse().toString();
                if (ss.equals(rev)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int[][] mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();

        for (int n : nums2) {

            if (map.containsKey(n) && map.get(n) != 0) {
                list.add(n);
                map.put(n, map.get(n) - 1);
            }
        }

        int[] res = new int[list.size()];
        System.out.println(list);
        int index = 0;
        for (int n : res) {
            res[index++] = n;
        }

        return res;

    }

    public static String replaceCharByOther(String s) {

        return s.replace("f", " ");
    }

    public static void findPermutations(String str) {
        List<String> list = new ArrayList<>();
        list.add(String.valueOf(str.charAt(0)));
        for (int i = 1; i < str.length(); i++) {
            for (int j = list.size() - 1; j >= 0; j--) {
                String s = list.remove(j);
                for (int k = 0; k <= s.length(); k++) {
                    //list.add(s.substring(0, k) + str.charAt(i) + s.substring(k));
                    String a = s.substring(0, k);
                    String b = String.valueOf(str.charAt(i));
                    String c = s.substring(k);

                    list.add(a + b + c);
                }
            }
        }

        System.out.println(list);
    }

    public static boolean checkIfPalindrome(String str) {

        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + String.valueOf(str.charAt(i));
        }

        return str.equals(rev);
    }

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }

        }

        return nums.length;

    }

    public static int findMedian(List<Integer> arr) {
        Collections.sort(arr);
        return arr.get(arr.size() / 2);
    }

    public static void plusMinus(List<Integer> arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = arr.size();
        for (int n : arr) {
            if (n > 0) {
                map.put(1, map.getOrDefault(1, 0) + 1);
            } else if (n < 0) {
                map.put(-1, map.getOrDefault(-1, 0) + 1);
            } else {
                map.put(0, map.getOrDefault(0, 0) + 1);
            }
        }

        if (map.getOrDefault(1, 0) >= 0) {
            float a = (float) map.getOrDefault(1, 0) / (float) len;
            String str = String.format("%2.05f", a);
            System.out.println(str);
        }
        if (map.getOrDefault(-1, 0) >= 0) {
            float a = (float) map.getOrDefault(-1, 0) / (float) len;
            String str = String.format("%2.05f", a);
            System.out.println(str);
        }
        if (map.getOrDefault(0, 0) >= 0) {
            float a = (float) map.getOrDefault(0, 0) / (float) len;
            String str = String.format("%2.05f", a);
            System.out.println(str);
        }

    }

    public static void miniMaxSum(List<Integer> arr) {

        Collections.sort(arr);
        long min = 0;
        long max = 0;

        for (int i = 0; i < arr.size() - 1; i++) {
            min = min + arr.get(i);
        }

        for (int i = 1; i < arr.size(); i++) {
            max = max + arr.get(i);
        }

        System.out.println(min + " " + max);

    }

    public static String timeConversion(String s) {
        String[] parts = s.split(":");

        for (String str : parts) {
            System.out.println(str);
        }

        if (parts[2].contains("AM")) {
            int hour = Integer.parseInt(parts[0]);
            if (hour > 12) {
                int a = hour - 12;
            }

        }

        if (parts[2].contains("PM")) {

        }

        return "";

    }

    public static int diagonalDifference(List<List<Integer>> arr) {

        int dg1 = 0;
        int dg2 = 0;
        int i = 0;
        int j = arr.size() - 1;
        while (i < arr.size()) {
            List<Integer> ll = arr.get(i);
            //List<Integer> lll = arr.get(j);
            dg1 += ll.get(i);
            //dg2+= lll.get(j);
            i++;
            //j--;
        }

        while (j >= 0) {
            List<Integer> ll = arr.get(j);
            dg2 += ll.get(j);
            j--;
        }

        System.out.println(dg1);
        System.out.println(dg2);

        return Math.abs(dg1 - dg2);

    }

    static int maxSubArraySum(int a[]) {
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;

        for (int j : a) {
            max_ending_here = max_ending_here + j;
            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
            }

            if (max_ending_here < 0) {
                max_ending_here = 0;
            }

        }

        return max_so_far;

    }

    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            int a = digits[i] + 1;
            if (a != 10) {
                digits[i] = a;
                return digits;
            } else {
                digits[i] = 0;
                if (i == 0) {
                    int[] res = new int[digits.length + 1];
                    res[0] = 1;
                    for (int j = 0; j < digits.length; j++) {
                        res[j + 1] = digits[j];
                    }
                    return res;

                }
            }

        }

        return digits;

    }

    public int minimumTotal(List<List<Integer>> triangle) {

        Collections.sort(triangle, Comparator.comparingInt(a -> a.get(0)));
        int sum = 0;

        for (int i = 0; i < triangle.size(); i++) {

            List<Integer> ll = triangle.get(i);
            sum += ll.get(0);
        }

        return sum;

    }

    public int lengthOfLongestSubstring(String s) {

        int maxLen = 1;
        int res = 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 1);

        for (int i = 1; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                res++;
                map.put(s.charAt(i), 1);
            } else {
                if (res > maxLen) {
                    maxLen = res;
                    res = 1;
                    map.clear();
                }
            }

        }

        return maxLen;

    }

    public int maxArea(int[] height) {

        int maxArea = 0;

        for (int i = height.length - 1; i >= 0; i--) {

            for (int j = 0; j <= height.length - 2; j++) {
                int width = i - j;
                int area = width * Math.min(height[i], height[j]);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        return maxArea;

    }

    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int start = 0;
        int middle = start + 1;
        int end = nums.length - 1;
        Arrays.sort(nums);

        while (end > start) {
            if (nums[start] + nums[middle] + nums[end] > 0) {
                end--;
            } else if (nums[start] + nums[middle] + nums[end] < 0) {
                start++;
                middle++;
            } else {
                List<Integer> ll = Arrays.asList(nums[start], nums[middle], nums[end]);
                list.add(ll);
            }
        }

        return list;

    }

    public static int getNumOfSubArrayWithZeroSum(int[] arr) {
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();

        int i = -1;
        int sum = 0;

        while (i < arr.length - 1) {
            i++;
            sum += arr[i];

            if (map.containsKey(sum)) {
                count += map.get(sum);
            } else {
                map.put(sum, 1);
            }
        }

        return count;
    }

    public static int subarraySum(int[] nums, int k) {

        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();

        int i = -1;
        int sum = 0;

        while (i < nums.length - 1) {
            i++;
            sum += nums[i];

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            } else {
                map.put(sum, 1);
            }
        }

        return count;

    }

    public boolean isValid(String s) {
        if (s.length() < 2) return false;
        Deque<Character> stack = new ArrayDeque<>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }

            if (stack.isEmpty()) return false;
            char closingChar;
            switch (c) {

                case ')':
                    closingChar = stack.pop();
                    if (closingChar == '{' || closingChar == '[') return false;
                    break;

                case '}':
                    closingChar = stack.pop();
                    if (closingChar == '(' || closingChar == '[') return false;
                    break;

                case ']':
                    closingChar = stack.pop();
                    if (closingChar == '(' || closingChar == '{') return false;
                    break;

            }
        }
        return stack.isEmpty();
    }

    static int evaluatePostfix(String exp) {
        Deque<Integer> stack = new ArrayDeque<>();
        char[] arr = exp.toCharArray();

        for (char c : arr) {
            if (Character.isDigit(c)) {
                stack.push((int) c - '0');
            } else {

                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(val1 + val2);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '*':
                        stack.push(val1 * val2);
                        break;
                    case '/':
                        stack.push(val2 / val1);
                        break;
                }
            }
        }

        return stack.pop();
    }

    public int coinChange(int[] coins, int amount) {

        if (getTotalSum(coins) < amount) return -1;
        if (getTotalSum(coins) == amount) return coins.length;

        Arrays.sort(coins);
        int res = 0;

        for (int i = coins.length - 1; i >= 0; i--) {
            int times = amount / coins[i];
            res += times;
            amount -= times * coins[i];
        }
        return res;

    }

    int getTotalSum(int[] coins) {
        int sum = 0;
        for (int n : coins) {
            sum += n;
        }
        return sum;
    }

    static int maxSum(int arr[], int n, int k) {

        int res = Integer.MIN_VALUE;

        for (int i = 0; i < n - k + 1; i++) {
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += arr[i + j];
            }

            res = Math.max(res, sum);
        }

        return res;

    }

    static int maxSum1(int arr[], int n, int k) {
        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        int maxSum = windowSum;

        for (int i = k; i < n; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(windowSum, maxSum);
        }

        return maxSum;
    }

    public double findMaxAverage(int[] nums, int k) {

        double windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        double maxSum = windowSum;

        for (int j = k; j < nums.length; j++) {
            windowSum += nums[j] - nums[j - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum / k;

    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        char[] seqArray = s.toCharArray();
        int k = 10;

        StringBuilder dna = new StringBuilder();

        for (int i = 0; i < k; i++) {
            dna.append(seqArray[i]);
        }

        if (s.contains(dna.toString())) {
            list.add(dna.toString());
        }

        for (int j = k; j < seqArray.length; j++) {
            dna.append(seqArray[j]);
            //dna.substring(seqArray[j-k]+1);
            dna.deleteCharAt(0);
            if (s.contains(dna) && !list.contains(dna.toString())) {
                list.add(dna.toString());
            }
        }

        return list;

    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int start = 0;
        int end = matrix.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target >= matrix[mid][0] && target <= matrix[mid][matrix[mid].length - 1]) {
                return binarySearch(matrix[mid], target) != -1;
            }

            if (target > matrix[mid][0] && target > matrix[mid][matrix[mid].length - 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;

    }

    public static int binarySearch(int[] arr, int key) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (key == arr[mid]) return mid;

            if (key > arr[mid]) start = mid + 1;

            else end = mid - 1;
        }

        return -1;

    }

    public static int lengthOfLongestSubstring1(String s) {

        Set<Character> set = new HashSet<>();
        int start = 0;
        int end = 0;
        int len = 0;
        String str = "";

        while (end < s.length()) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                len = Math.max(len, end - start + 1);
                end++;
            } else {
                set.remove(s.charAt(start));
                start++;
            }
        }

        return len;

    }

    public static int[] kWeakestRows(int[][] mat, int k) {

        int[][] arr = new int[mat.length][2];
        int[] res = new int[k];

        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    count += count;
                }
            }
            arr[i][0] = count;
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        for (int i = 0; i < k; i++) {
            res[i] = arr[i][1];
        }
        return res;


    }

    public int minAddToMakeValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] array = s.toCharArray();

        for (char c : array) {
            if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }

        return stack.size();

    }

    public boolean isStart(char c) {
        return c == '(';
    }

    public boolean isEnd(char c) {
        return c == ')';
    }

    public boolean isPair(char c1, char c2) {
        return (c1 == '(' && c2 == ')');
    }

    static int getMaxArea(int hist[], int n) {
        // Create an empty stack. The stack holds indexes of
        // hist[] array The bars stored in stack are always
        // in increasing order of their heights.
        Stack<Integer> s = new Stack<>();

        int max_area = 0; // Initialize max area
        int tp; // To store top of stack
        int area_with_top; // To store area with top bar as
        // the smallest bar

        // Run through all bars of given histogram
        int i = 0;
        while (i < n) {
            // If this bar is higher than the bar on top
            // stack, push it to stack
            if (s.empty() || hist[s.peek()] <= hist[i])
                s.push(i++);

                // If this bar is lower than top of stack, then
                // calculate area of rectangle with stack top as
                // the smallest (or minimum height) bar. 'i' is
                // 'right index' for the top and element before
                // top in stack is 'left index'
            else {
                tp = s.peek(); // store the top index
                s.pop(); // pop the top

                // Calculate the area with hist[tp] stack as
                // smallest bar

                int c = (s.empty() ? i : i - s.peek() - 1);
                area_with_top
                        = hist[tp]
                        * c;

                // update max area, if needed
                if (max_area < area_with_top)
                    max_area = area_with_top;
            }
        }

        // Now pop the remaining bars from stack and
        // calculate area with every popped bar as the
        // smallest bar
        while (!s.empty()) {
            tp = s.peek();
            s.pop();
            area_with_top
                    = hist[tp]
                    * (s.empty() ? i : i - s.peek() - 1);

            if (max_area < area_with_top)
                max_area = area_with_top;
        }

        return max_area;
    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String [] array = path.split("/");
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        for(String s : array){
            if(!stack.isEmpty() && Objects.equals(s, "..")){
                stack.pop();
            }else if(!skip.contains(s)) {
                stack.push(s);
            }
        }

        String dir = "";

        for(String s : stack){
            dir = "/"+s+dir;
        }

        return stack.isEmpty() ? "/" : dir;
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int [] res = new int[2];
        for(int i=0; i< nums.length; i++){
            if(map.containsKey(target - nums[i])){
                res[0] = map.get(target-nums[i]);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);

        }
        return res;

    }

    //Sliding window max sum
    static int maxSumUsingSld(int arr[], int n, int k){
        int windowSum = 0;

        for(int i = 0; i< k; i++){
            windowSum += arr[i];
        }
        int maxSum = windowSum;

        for(int i =k; i< n; i++){
            windowSum = windowSum+arr[i]- arr[i-k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;

    }

    public static boolean isPrime(int n){

        if(n <=1) return false;
        if(n ==2) return true;

        for(int i =2; i <= Math.sqrt(n); i+=2){
            if(n%i == 0) return true;
        }

        return false;
    }


    public static void main(String[] args) {
        int [] array = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
        //System.out.println(Arrays.toString(twoSum(array, 9)));
        System.out.println(maxSumUsingSld(array, array.length, 4));
    }
}
