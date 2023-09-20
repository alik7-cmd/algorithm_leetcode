package design;

import java.util.LinkedHashMap;
import java.util.Map;

public class NewLRU {


    private Map<Integer, Integer> map;
    private int size;


    public NewLRU(int size) {
        this.size = size;
        map = new LinkedHashMap<>();
    }

    public int get(int key) {

        if(map.containsKey(key)){
            int value = map.get(key);
            map.remove(key);
            map.put(key, value);
            return value;
        }

        return -1;

    }

    public void put(int key, int value) {

        if(map.containsKey(key)){
            map.remove(key);
            map.put(key,value);
            return;
        }

        if(size ==0){
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                int k = entry.getKey();
                map.remove(k);
                break;
            }
            size++;
        }

        map.put(key,value);
        size--;

    }
}
