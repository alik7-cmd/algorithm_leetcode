package design;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    //private TreeMap<Integer, Integer> map;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
        //map = new TreeMap<>();
    }

    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }

    }

    public void pop() {
        if(minStack.peek().equals(stack.peek())){
            minStack.pop();
        }
        stack.pop();
        //stack.push(val);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {

        return minStack.peek();

    }
}

class MinStackTest{

    public static void main (String [] args){
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
       // minStack.top();    // return 0
        System.out.println(minStack.getMin()); // return -2
    }

}
