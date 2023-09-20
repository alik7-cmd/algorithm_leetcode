package contest;

import java.util.*;

public class Mock {

    public static int findMedian(List<Integer> arr) {

        if(arr.size() == 1) return arr.get(0);
        Collections.sort(arr);
        return arr.get(arr.size()/2);

    }

    public static String timeConversion(String s) { // 07:05:45PM
        String [] words = s.split(":");
        if(s.contains("AM")){
            int hour = Integer.parseInt(words[0]);
            if(hour ==12){
                words[0] = "00";
            }

        }else if (s.contains("PM")){
            int hour = Integer.parseInt(words[0]);
            if(hour <12){
                hour = hour+12;
                words[0] = String.valueOf(hour);
            }
        }

        words[2] = words[2].substring(0,2);

        return words[0].concat(":").concat(words[1]).concat(":").concat(words[2]);
    }

    public static int lonelyinteger(List<Integer> a) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : a){
            map.put(i,map.getOrDefault(i, 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }

        return -1;

    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int startIndex = 0;
        int sum = 0;
        int endSum = 0;

        for(int i = 0; i< arr.size(); i++){
            sum += arr.get(i).get(startIndex);
            startIndex++;
        }
        startIndex = 0;

        for(int j = arr.size()-1; j >= 0 ;j--){
            endSum+= arr.get(j).get(startIndex);
            startIndex++;
        }

        return Math.abs(sum-endSum);

    }

    public static List<Integer> countingSort(List<Integer> arr) {

        Collections.sort(arr);
        int [] res = new int[arr.get(arr.size()-1)];

        for(int n : arr){
            res[n] = res[n]+1;
        }

        List<Integer> ll = new ArrayList<>();

        for (int n : res){
            ll.add(n);
        }

       return ll;

    }

    public static void findZigZagSequence(int [] a, int n){
        Arrays.sort(a);
        int mid = (n + 1)/2;
        int temp = a[mid];
        a[mid] = a[n - 1];
        a[n - 1] = temp;

        int st = mid + 1;
        int ed = n - 1;
        while(st <= ed){
            temp = a[st];
            a[st] = a[ed];
            a[ed] = temp;
            st = st + 1;
            ed = ed + 1;
        }
        for(int i = 0; i < n; i++){
            if(i > 0) System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println();
    }

    public static String caesarCipher(String s, int k) {
        StringBuilder builder = new StringBuilder("");
        for(char c : s.toCharArray()){
            if(c >= 65 && c <=90){
                int value = (c-65+k)%26+65;
                builder.append((char) value);
            }else if(c >= 97 && c <=122){
                int value = (c-97+k)%26+97;
                builder.append((char) value);
            }else {
                builder.append(c);
            }
        }

        return builder.toString();

    }

    public static boolean checkIfInCapitalRange(int value){
        return (value >= 65 && value <= 90);
    }

    public static boolean checkIfInSmallRange(int value){
        return (value >= 97 && value <= 122);
    }

    public static String removeSpace(String str){
        return str.replace(" ", "");
    }


    public static void main(String [] args){
        int [] arr = {1,2,3,4,5,6,7};

        //findZigZagSequence(arr, 7);
        System.out.println(removeSpace(" i am boss"));

    }
}
