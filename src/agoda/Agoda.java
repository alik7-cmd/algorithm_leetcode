package agoda;

import java.util.*;

public class Agoda {

    public int [] rotateArray(int [] array, int k){
        int n = array.length;
        int [] res = new int[n];
        k = k%n;
        for(int i = 0; i< n; i++){
            if(i < k){
                res[i] = array[n+i-k];
            }else {
                res[i] = array[i-k];
            }
        }
        return res;
    }

    public List<Integer> findDuplicate(int [] array){

        Map<Integer, Integer> map = new HashMap<>();
        for(int n : array){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        List<Integer> list = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue()> 1){
                list.add(entry.getValue());
            }
        }
        return list;

    }

    public static void printAllPermutationOfString(String s, String ans){
        if(s.length()==0){
            System.out.println(ans);
            return;
        }

        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            String ros = s.substring(0, i) + s.substring(i+1);
            printAllPermutationOfString(ros, ans+c);
        }
    }

    public static boolean halvesAreAlike(String s) {
        var v = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int middle = s.length()/2;

        String s1 = s.substring(0,middle);
        String s2 = s.substring(middle);
        int count1 = 0;
        int count2 = 0;

        for(char c : s1.toCharArray()){
            if(v.contains(c)){
                count1++;
            }

        }

        for(char c : s2.toCharArray()){
            if(v.contains(c)){
                count2++;
            }

        }
        return count1==count2;
    }

    public int[] plusOne(int[] digits) {

        for(int i =  digits.length-1; i>= 0;i++){
            int sum = digits[i]+1;
            if(sum != 10){
                digits[i] = sum;
                return digits;
            }else {
                digits[i] = 0;
                if(i ==0){
                    int [] res = new int[digits.length+1];
                    res[0] =1;
                    for(int j = 0; j< digits.length; j++){
                        res[j+1] = digits[i];
                    }
                    return res;
                }

            }
        }

        return digits;

    }

    public int lengthOfLongestSubStrWithoutRepeatingChar(String s){
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0),1);
        int res = 1;
        int maxLen = 1;
        for(int i=1; i< s.length(); i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                res++;
                map.put(c, 1);
            }else {
                if(res > maxLen){
                    maxLen = res;
                    res =1;
                    map.clear();
                }
            }

        }

        return res;
    }

    public static void main(String [] args){
        halvesAreAlike("motovo");

    }

}
