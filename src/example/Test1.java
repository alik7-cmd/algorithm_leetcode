package example;

import java.util.*;

public class Test1 {

    public void sortColors(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;

            while (j >= 0 && key < nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }

    }

    public String removeKdigits(String num, int k) {

        if(num.isEmpty()) return  "0";

        if(num.length() == k) return "0";

        Stack<Character> stack = new Stack<>();
        int count = 0;
        int len = num.length();

        while (count < len){

            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(count)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(count));
            count++;

        }

        while (k > 0){
            stack.pop();
            k--;
        }

        StringBuilder builder = new StringBuilder();
        while (stack.isEmpty()){
            builder.append(stack.pop());
        }

        //return String.valueOf(Integer.parseInt(builder.toString()));

        while(builder.length() > 1 && builder.charAt(0)=='0'){
            builder.deleteCharAt(0);
        }

        builder.reverse();

        return builder.toString();
    }

    public int[] searchRange(int[] nums, int target) {

        int start = -1;
        int end = -1;

        int [] ans = new int[2];

        for(int i = 0; i< nums.length; i++){
            if(nums[i] == target){
                if(start == -1){
                    start = i;
                }else {
                    end = i;
                }
            }
        }

        ans[0] = start;
        ans[1] = end;

        return ans;

    }

    public static int addDigits(int num) {
        int ans = 0;

        while (digitSum(num) >10){
            ans++;
            num = digitSum(num);
        }

        return ans;

    }

    private static int digitSum(int num){
        int sum = 0;

        while (num > 0){
            sum += num%10;
            num = num/10;
        }
        return sum;
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
    public static int largestAltitude(int[] gain) {
        int result = 0;
        int pred = 0;

        for(int n : gain){
            pred = pred+n;
            if(pred > result){
                result = pred;
            }
        }

        return result;

    }

    public int maxProduct(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        for(int  i = 0; i< nums.length-1; i++){
            for(int j = i+1; j< nums.length; j++){
                int sum = (nums[i]-1) * (nums[j]-1);
                if(sum > maxSum){
                    maxSum = sum;
                }
            }
        }

        return maxSum;

    }

    public double trimMean(int[] arr) {

        Arrays.sort(arr);
        int len = arr.length;
        double sum = 0;
        double index = 0;

        int fivePercentOfCurrentLength = (int) (len*0.5);
        for(int i = 0+fivePercentOfCurrentLength; i< len- fivePercentOfCurrentLength; i++){
            sum+=arr[i];
            index++;
        }

        return sum/index;


    }

    public static String removeWhiteSpace(String str){
        char [] charArray = str.toCharArray();
        StringBuilder builder = new StringBuilder();
        for(char c : charArray){
           if(c != ' '){
               builder.append(c);
           }
        }

        return builder.toString();
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(char c : ransomNote.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(char c : magazine.toCharArray()){

            if(map.containsKey(c) && map.get(c) > 0){
                map.put(c, map.get(c)-1);
            }else {
                return false;
            }
        }

        return true;


    }


    public static void main (String [] args){
        int [] arr = {-5,1,5,0,-7};
        //System.out.println(largestAltitude(arr));
        System.out.println(removeWhiteSpace("a /man can,only dream --  "));
    }
}
