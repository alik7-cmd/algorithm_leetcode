package design;

import java.util.ArrayList;

public class CustomStack {

    private int [] array;
    private int topOfArray;

    public CustomStack(int maxSize) {
        array = new int[maxSize];
        topOfArray = -1;
    }

    public void push(int x) {
        if(topOfArray+1 == array.length) return;
        array[++topOfArray] = x;
    }

    public int pop() {
        if(topOfArray == -1) return -1;
        return array[topOfArray--];

    }

    public void increment(int k, int val) {
        for(int i = 0; i< k && i <= topOfArray; i++){
            array[i] += val;
        }
    }

}
