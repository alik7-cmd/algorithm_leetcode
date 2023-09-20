package design;

import java.util.ArrayList;
import java.util.List;

public class StockSpanner {

    private List<Integer> list;

    public StockSpanner() {
        list = new ArrayList<>();
    }

    public int next(int price) {
        int res = 0;
        list.add(price);
        for(int i = list.size()-1; i>=0; i--){
            if(price <= list.get(i)){
                res++;
            }else {
                return res;
            }

        }

        return res;
    }
}
