package agoda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {

    private Map<Integer, Integer> map;
    private List<Integer> list;
    //private int size = 10;

    public Store() {
        map = new HashMap<>();
        list = new ArrayList<>();

    }

    public void insert(int value){

        if(map.containsKey(value)){
            return;
        }
        list.add(value);
        map.put(value, list.indexOf(value));
    }

    public void delete(int value){
        if(!map.containsKey(value)){
            return;
        }

        int key = list.get(list.size()-1);
        int index = list.indexOf(value);
        list.add(index, key);
        list.add(list.size()-1, value);
        list.remove(list.size()-1);
        map.remove(value);


    }
}
