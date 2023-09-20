package design;

import java.util.Arrays;

public class MyHashSet {

    private int [] array;

    public MyHashSet() {
        array = new int[1000000];
        Arrays.fill(array,-1);
    }

    public void add(int key) {
        array[key] = key;
    }

    public void remove(int key) {
        array[key] = -1;
    }

    public boolean contains(int key) {
        return array[key] != -1;

    }
}
