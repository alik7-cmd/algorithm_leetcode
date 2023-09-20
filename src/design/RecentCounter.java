package design;

import java.util.LinkedList;
import java.util.List;

public class RecentCounter {

    private List<Integer> list;

    public RecentCounter() {
        list = new LinkedList<>();

    }

    public int ping(int t) {
        list.add(t);
        int lowerLimit = t-3000;
        //int higherLimit = t;

        int count = 0;

        for(int n : list){
            if(n >= lowerLimit && n <= t){
                count++;
            }
        }

        return count;


    }
}
