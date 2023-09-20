package design;

import java.util.Arrays;

public class MyHashMap {

    private int [] keysArray;
    private int [] valuesArray;

    public MyHashMap() {
        keysArray = new int[1000001];
        valuesArray = new int[1000001];

        Arrays.fill(keysArray,-1);
        Arrays.fill(valuesArray,-1);
    }

    public void put(int key, int value) {

        keysArray[key] = key;
        valuesArray[key] = value;

    }

    public int get(int key) {
        if(keysArray[key] ==-1) return -1;
        return valuesArray[key];

    }

    public void remove(int key) {
        keysArray[key] = -1;
        valuesArray[key] = -1;
    }
}
