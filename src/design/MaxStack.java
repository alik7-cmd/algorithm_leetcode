package design;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxStack {

    private Deque<Integer> mainStack;
    private Deque<Integer> trackStack;

    public MaxStack() {
        this.mainStack = new ArrayDeque<>();
        this.trackStack = new ArrayDeque<>();
    }

    public void push(int x){
        mainStack.push(x);
        if(mainStack.size() ==1){
            trackStack.push(x);
            return;
        }

        if(x > trackStack.peek()){
            trackStack.push(x);
        }else {
            trackStack.push(trackStack.peek());
        }
    }

    public int getMax(){
        return trackStack.peek();
    }

    public void pop(){
        mainStack.pop();
        trackStack.pop();
    }
}

class Solution{
    public static void main(String [] args){
        MaxStack stack = new MaxStack();
        stack.push(15);
        stack.push(11);
        stack.push(16);
        stack.push(9);
        stack.push(16);
        stack.pop();
        stack.getMax();
        System.out.println(stack.getMax());
    }
}
